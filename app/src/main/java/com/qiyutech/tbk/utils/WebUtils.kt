package com.qiyutech.tbk.utils

import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.FragmentActivity
import com.qiyutech.tbk.BuildConfig
import com.qiyutech.tbk.logic.TaoBaoLogic
import com.qiyutech.tbk.values.AppPreferenceUtils
import com.qiyutech.tbk.values.AppSpKeys


const val AndroidBindingName: String = "MyAndroidAutoResize"

/**
 * 自动设置 WebView 的高度
 * 注意: 请使用 ScrollView LinearView 包裹起来
 */
class MyWebViewAutoResizeClient(private val webView: WebView) : WebViewClient() {
    /* use js control for simplify
    override fun onPageFinished(view: WebView?, url: String?) {
        webView.loadUrl("javascript:${AndroidAutoResizeBindingName}.resize(document.body.getBoundingClientRect().height)")
        super.onPageFinished(view, url)
    }
     */
}

class ItemDetailWebViewClient(private val itemId: String) : WebViewClient() {
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        view!!.loadUrl("javascript:item_detail_init('${itemId}')")
    }
}


/**
 * 自动设置 resize
 * binding with this: AndroidAutoResizeBindingName
 */
class AndroidWebViewInterface(private var activity: FragmentActivity, private var wv: WebView) {

    @JavascriptInterface
    fun resize(height: Float) {
        activity.runOnUiThread {
            run {
                val dm = activity.resources.displayMetrics
                val w = dm.widthPixels
                val h = (height * dm.density).toInt()
                wv.layoutParams = LinearLayoutCompat.LayoutParams(w, h)
            }
        }
    }

    /// 打开一个指定的商品
    @JavascriptInterface
    fun openItem(item: String) {
        activity.runOnUiThread {
            run {
                AppNavUtils.gotoItemDetailV2(activity, item)
            }
        }
    }

    @JavascriptInterface
    fun buyItem(item: String) {
        activity.runOnUiThread {
            run {
                val tb = TaoBaoLogic(activity = activity as AppCompatActivity)
                tb.buyItem(item)
            }
        }
    }

    @JavascriptInterface
    fun uuid(): String {
        val sp = AppUtils.getPreference(activity)
        return sp.getString(AppSpKeys.TBK_UUID, "") ?: ""
    }

    @JavascriptInterface
    fun token(): String {
        return AppPreferenceUtils.getUserToken(activity)
    }

    /**
     * 获取基础的 url
     */
    @JavascriptInterface
    fun baseUrl(): String {
        return BuildConfig.BASE_URL
    }


    @JavascriptInterface
    fun openSuperSubCategory(subCid: Int, title: String) {
        activity.runOnUiThread {
            run {
                // 跳转到超级分类
                // 当前已经移除
            }
        }
    }
}
