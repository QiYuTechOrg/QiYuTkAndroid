package com.qiyutech.tbk

import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ContentLoadingProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qiyutech.tbk.databinding.ActivitySearchDetailNativeBinding
import com.qiyutech.tbk.databinding.LayoutRecycleViewSearchDetailItemInfoBinding
import com.qiyutech.tbk.dt.ApiDtkSuperSearchStub
import com.qiyutech.tbk.dt.DtGoodsListSuperGoodsArgs
import com.qiyutech.tbk.dt.DtItemInfo
import com.qiyutech.tbk.dt.TbkSortType
import com.qiyutech.tbk.fragments.TextHeaderFragment
import com.qiyutech.tbk.fragments.home.ItemInfoViewHolder
import com.qiyutech.tbk.logic.AppErrnoLogic
import com.qiyutech.tbk.utils.AppNavUtils
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.utils.TipUtils

class SearchDetailItemInfoAdaptor(private val activity: Activity) :
    PagedListAdapter<DtItemInfo, ItemInfoViewHolder>(DIFF_CALLBACK) {

    private val inflater = LayoutInflater.from(activity)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemInfoViewHolder {
        val view = inflater.inflate(
            R.layout.layout_recycle_view_search_detail_item_info, parent, false
        )
        return ItemInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemInfoViewHolder, position: Int) {
        val item = this.getItem(position)
        item?.let {
            val bd = LayoutRecycleViewSearchDetailItemInfoBinding.bind(holder.itemView)
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
            bd.shopName.text = it.seller_name.toString()

            val itemData = it.copy()
            bd.allInfo.setOnClickListener {
                AppNavUtils.gotoItemDetailV2(activity, itemData.tao_id)
            }
        }
    }

    override fun getItemCount(): Int {
        val count = super.getItemCount()
        Log.d("搜索", "count = $count")
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

class SearchDetailNativeDataSource(
    private val ctx: Context,
    private val query: String,
    private val st: TbkSortType,
    private val pb: ContentLoadingProgressBar
) :
    PageKeyedDataSource<Int, DtItemInfo>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, DtItemInfo>
    ) {

        val form = getForm(1)
        ApiDtkSuperSearchStub.myPost(ctx, form, { ret ->
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
        ApiDtkSuperSearchStub.myPost(ctx, form, { ret ->
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
        ApiDtkSuperSearchStub.myPost(ctx, form, { ret ->
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

    private fun getForm(page: Int): DtGoodsListSuperGoodsArgs {
        Log.d("搜索", "加载数据 $page")
        return DtGoodsListSuperGoodsArgs(
            pageId = page.toString(),
            pageSize = "20",
            keyWords = query,
            type = "0",
            tmall = "0",
            haitao = "0",
            sort = st.getString(),
            specialId = "",
            channelId = ""
        )
    }
}

class SearchDetailNativeDataSourceFactory(
    val ctx: Context,
    private val query: String,
    private val sortType: TbkSortType,
    private val pb: ContentLoadingProgressBar,
) :
    DataSource.Factory<Int, DtItemInfo>() {
    var pageSource: SearchDetailNativeDataSource? = null


    override fun create(): DataSource<Int, DtItemInfo> {
        pageSource = SearchDetailNativeDataSource(ctx, query, sortType, pb)
        return pageSource!!
    }
}


class SearchDetailNativeViewModel : ViewModel() {

    val sortType by lazy {
        MutableLiveData(TbkSortType.Common)
    }

    var dataList: LiveData<PagedList<DtItemInfo>>? = null

    fun initLiveData(ctx: Context, query: String, st: TbkSortType, pb: ContentLoadingProgressBar) {
        dataList = SearchDetailNativeDataSourceFactory(ctx, query, st, pb).toLiveData(pageSize = 20)
    }
}

/**
 * 搜索原生代码的实现
 *
 * 兼容性更好
 */
class SearchDetailNativeActivity : AppCompatActivity() {

    private val searchDetailNativeViewModel: SearchDetailNativeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_detail_native)

        val query = this.getQueryOrDie()

        supportFragmentManager.beginTransaction()
            .replace(R.id.search_header, TextHeaderFragment(query, true))
            .commit()

        val bd = this.getBinding()
        val rv = bd.searchRecyclerView
        val llm = LinearLayoutManager(this)
        llm.orientation = RecyclerView.VERTICAL
        rv.layoutManager = llm

        bd.tbkHeader.sortCommon.setOnClickListener {
            searchDetailNativeViewModel.sortType.value = TbkSortType.Common
        }
        bd.tbkHeader.sortSales.setOnClickListener {
            searchDetailNativeViewModel.sortType.value = TbkSortType.Sales
        }
        bd.tbkHeader.sortPrice.setOnClickListener {
            searchDetailNativeViewModel.sortType.value = TbkSortType.Price
        }
        searchDetailNativeViewModel.sortType.observe(this, {
            it?.let { sortType ->
                this.switchSelectColor(sortType)

                this.refreshUI(sortType)
            }
        })

        refreshUI(TbkSortType.Common)
    }


    private fun refreshUI(st: TbkSortType) {
        //
        // for live data change
        // https://stackoverflow.com/questions/31367599/how-to-update-recyclerview-adapter-data
        //
        val bd = this.getBinding()
        bd.pb.show()

        val rv = bd.searchRecyclerView
        searchDetailNativeViewModel.initLiveData(this, this.getQueryOrDie(), st, bd.pb)

        val adapter = SearchDetailItemInfoAdaptor(this)
        searchDetailNativeViewModel.dataList?.let {
            it.removeObservers(this)
            it.observe(this, { dataList ->
                adapter.submitList(dataList)
            })
        }
        rv.adapter = adapter
    }

    fun switchSelectColor(t: TbkSortType) {

        val bd = this.getBinding()

        val header = bd.tbkHeader

        // set selected color
        val black = resources.getColor(android.R.color.black)
        val red = resources.getColor(android.R.color.holo_red_dark)

        arrayOf(header.sortCommon, header.sortPrice, header.sortSales).iterator()
            .forEach { tv ->
                tv.setTextColor(black)
            }

        when (t) {
            TbkSortType.Price -> header.sortPrice.setTextColor(red)
            TbkSortType.Sales -> header.sortSales.setTextColor(red)
            TbkSortType.Common -> header.sortCommon.setTextColor(red)
        }
    }


    private fun getBinding(): ActivitySearchDetailNativeBinding {
        val rv = AppUtils.getRootView(this)
        return ActivitySearchDetailNativeBinding.bind(rv)
    }

    private fun getQueryOrDie(): String {
        val query = intent.getStringExtra("query")
        return if (query.isNullOrBlank()) {
            this.finish()
            ""
        } else {
            query
        }
    }
}
