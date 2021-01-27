package com.qiyutech.tbk.utils

import android.annotation.SuppressLint
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.fragment.app.FragmentActivity

/**
 * WebView 辅助函数
 */
object MyWebViewUtils {
    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(activity: FragmentActivity, webView: WebView) {
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        // alert need this
        webView.webChromeClient = WebChromeClient()

        val c = AndroidWebViewInterface(activity, webView)
        webView.addJavascriptInterface(c, AndroidBindingName)
    }
}
