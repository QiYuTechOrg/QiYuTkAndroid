package com.qiyutech.tbk

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.databinding.ActivityItemDetailV2Binding
import com.qiyutech.tbk.dt.ApiTbkItemDetailStub
import com.qiyutech.tbk.dt.DtTbkItemDetailForm
import com.qiyutech.tbk.extend.MyManualImageView
import com.qiyutech.tbk.logic.AppErrnoLogic
import com.qiyutech.tbk.logic.TaoBaoLogic
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.utils.TipUtils

/**
 * 商品详情页 v2 版本
 */
class ItemDetailV2Activity : AppCompatActivity() {
    // 商品 ID
    private var itemId: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail_v2)

        itemId = intent.getStringExtra("item_id")!!
    }

    override fun onStart() {
        super.onStart()

        initGoodInfo()
    }

    private fun initGoodInfo() {
        val form = DtTbkItemDetailForm(tao_id = itemId)
        ApiTbkItemDetailStub.myPost(this, form, { ret ->
            AppErrnoLogic.genericServerErrnoProcess(ret.errno, this)

            val bd = this.getBinding()
            ret.data?.let { data ->
                // std details
                data.price_coupon?.let {
                    bd.couponPrice.text = it.toInt().toString()
                }
                bd.productName.text = data.title_long
                bd.productIcon.loadImageFromUrl(data.tao_img)
                data.seller_logo?.let {
                    bd.shopIcon.loadImageFromUrl(it)
                }
                bd.priceActual.text = "¥ ${data.price_actual}"
                bd.priceOrigin.text = "¥ ${data.price_origin}"
                // add middle line
                bd.priceOrigin.paintFlags = bd.priceOrigin.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                bd.monthSale.text = data.sale_month.toString()
                data.seller_name?.let {
                    bd.sellerName.text = it
                }
                bd.descScore.text = data.score_dsr.toString()
                bd.serviceScore.text = data.score_service.toString()
                bd.shipScore.text = data.score_ship.toString()


                data.tao_details?.let {
                    it.forEach { url ->
                        val img = MyManualImageView(this)
                        bd.imageList.addView(img)
                        img.loadImageFromUrl(url)
                    }
                }
            }
        }, {
            TipUtils.toastLong(this, "获取商品信息失败: ${it.localizedMessage}")
        })
    }

    /**
     * 尝试购买 商品 信息
     */
    fun tryToBuy(view: View) {
        val tb = TaoBaoLogic(this)
        tb.buyItem(itemId)
    }

    fun shareToSys(view: View) {

    }

    @Suppress("UNUSED_PARAMETER")
    fun itemDetailV2Finish(view: View) {
        this.finish()
    }

    fun getBinding(): ActivityItemDetailV2Binding {
        val rv = AppUtils.getRootView(this)
        return ActivityItemDetailV2Binding.bind(rv)
    }
}
