package com.qiyutech.tbk.fragments.home

import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qiyutech.tbk.R
import com.qiyutech.tbk.databinding.FragmentHomeGuessYouLikeBinding
import com.qiyutech.tbk.databinding.LayoutRecycleViewItemInfoBinding
import com.qiyutech.tbk.dt.ApiDtkGuessYouLikeStub
import com.qiyutech.tbk.dt.DtGoodsExplosiveGoodsListArgs
import com.qiyutech.tbk.dt.DtItemInfo
import com.qiyutech.tbk.logic.AppErrnoLogic
import com.qiyutech.tbk.utils.AppNavUtils
import com.qiyutech.tbk.utils.TipUtils


class ItemInfoViewHolder(val view: View) : RecyclerView.ViewHolder(view)


class ItemInfoAdaptor(private val activity: Activity) :
    PagedListAdapter<DtItemInfo, ItemInfoViewHolder>(DIFF_CALLBACK) {

    private val inflater = LayoutInflater.from(activity)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemInfoViewHolder {
        val view = inflater.inflate(R.layout.layout_recycle_view_item_info, parent, false)
        return ItemInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemInfoViewHolder, position: Int) {
        val item = this.getItem(position)
        item?.let {
            val bd = LayoutRecycleViewItemInfoBinding.bind(holder.itemView)
            bd.title.text = it.title_short
            bd.image.loadImageFromUrl(it.tao_img)
            it.sale_month?.let { v ->
                bd.monthSale.text = v.toString()
            }
            it.price_coupon?.let { coupon ->
                bd.couponPrice.text = coupon.toInt().toString()
            }
            bd.priceOrigin.text = "¥ ${it.price_origin}"
            bd.priceActual.text = "¥ ${it.price_actual}"
            bd.priceOrigin.paintFlags = bd.priceOrigin.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

            val itemData = it.copy()
            bd.allInfo.setOnClickListener {
                AppNavUtils.gotoItemDetailV2(activity, itemData.tao_id)
            }
        }
    }

    override fun getItemCount(): Int {
        val count = super.getItemCount()
        Log.d("猜你喜欢", "count = $count")
        return count
    }

    companion object {
        val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<DtItemInfo>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(oldConcert: DtItemInfo, newConcert: DtItemInfo): Boolean {
                return oldConcert.tao_id == newConcert.tao_id
            }

            override fun areContentsTheSame(
                oldConcert: DtItemInfo,
                newConcert: DtItemInfo
            ) = oldConcert == newConcert
        }
    }

}

class MyPageDataSource(private val ctx: Context, private val pb: ContentLoadingProgressBar) :
    PageKeyedDataSource<Int, DtItemInfo>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, DtItemInfo>
    ) {

        val form = getForm(1)
        ApiDtkGuessYouLikeStub.myPost(ctx, form, { ret ->
            AppErrnoLogic.genericServerErrnoProcess(ret.errno, ctx)
            pb.hide()
            if (ret.data.isNullOrEmpty()) {
                callback.onResult(listOf(), 0, 0, null, 1)
            } else {
                callback.onResult(ret.data, 0, ret.data.count(), null, 2)
            }
        }, {
            TipUtils.toastLong(ctx, "获取数据失败: $it")
            callback.onResult(listOf(), 0, 0, null, 1)
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DtItemInfo>) {
        val pre = if (params.key > 1) {
            params.key - 1
        } else {
            null
        }


        val form = getForm(params.key)
        ApiDtkGuessYouLikeStub.myPost(ctx, form, { ret ->
            AppErrnoLogic.genericServerErrnoProcess(ret.errno, ctx)
            if (ret.data.isNullOrEmpty()) {
                callback.onResult(listOf(), pre)
            } else {
                callback.onResult(ret.data, pre)
            }
        }, {
            TipUtils.toastLong(ctx, "获取数据失败: $it")
            callback.onResult(listOf(), pre)
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DtItemInfo>) {
        val form = getForm(params.key)
        ApiDtkGuessYouLikeStub.myPost(ctx, form, { ret ->
            AppErrnoLogic.genericServerErrnoProcess(ret.errno, ctx)
            if (ret.data.isNullOrEmpty()) {
                callback.onResult(listOf(), params.key + 1)
            } else {
                callback.onResult(ret.data, params.key + 1)
            }
        }, {
            TipUtils.toastLong(ctx, "获取数据失败: $it")
            callback.onResult(listOf(), params.key + 1)
        })
    }

    private fun getForm(page: Int): DtGoodsExplosiveGoodsListArgs {
        Log.d("猜你喜欢", "加载数据 $page")
        return DtGoodsExplosiveGoodsListArgs(
            pageId = page.toString(),
            pageSize = "20",
            PriceCid = null,
            cids = null
        )
    }
}

class DataSourceFactory(val ctx: Context, val pb: ContentLoadingProgressBar) :
    DataSource.Factory<Int, DtItemInfo>() {
    var pageSource: MyPageDataSource? = null


    override fun create(): DataSource<Int, DtItemInfo> {
        pageSource = MyPageDataSource(ctx, pb)
        return pageSource!!
    }
}


class GuessYouLikeViewModel : ViewModel() {

    var dataList: LiveData<PagedList<DtItemInfo>>? = null

    fun initLiveData(ctx: Context, pb: ContentLoadingProgressBar) {
        dataList = (DataSourceFactory(ctx, pb)).toLiveData(pageSize = 20)
    }
}


/**
 */
class HomeFragmentGuessYouLike : Fragment() {

    val viewModel: GuessYouLikeViewModel by activityViewModels()

    var bd: FragmentHomeGuessYouLikeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bd = FragmentHomeGuessYouLikeBinding.inflate(inflater, container, false)
        bd?.let {
            return it.root
        }
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bd?.let {
            val rv = it.guessYouLikeRecyclerView

            val activity = this.requireActivity()

            viewModel.initLiveData(activity, it.pb)

            val glm = GridLayoutManager(activity, 2)

            val adapter = ItemInfoAdaptor(activity)
            viewModel.dataList?.observe(viewLifecycleOwner, { dataList ->
                adapter.submitList(dataList)
                //
                // https://stackoverflow.com/questions/54856941/how-to-clear-remove-all-items-in-page-list-adapter
                // make it empty
                // adapter.submitList(null)
                //
            })
            // may be we can change adapter to achive change data set
            rv.adapter = adapter
            rv.layoutManager = glm
        }
    }
}
