package com.qiyutech.tbk

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.databinding.ActivityPrivacyBinding
import com.qiyutech.tbk.fragments.TextHeaderFragment
import com.qiyutech.tbk.utils.AppPrivacyUtils
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.values.HttpFile

/**
 * 隐私协议活动
 */
class PrivacyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)

        supportFragmentManager.beginTransaction()
            .replace(R.id.header, TextHeaderFragment("奇遇淘客用户隐私协议", true))
            .commit()

        val wv = getWebView()
        wv.loadUrl(HttpFile.privacy)
    }

    override fun onStart() {
        super.onStart()

        val viewMode = intent.getBooleanExtra("view", false)
        if (viewMode) {
            val view = AppUtils.getRootView(this)
            val pb = ActivityPrivacyBinding.bind(view)
            pb.bottomButtons.visibility = View.GONE
        }
    }

    /**
     * 同意隐私协议
     */
    @Suppress("UNUSED_PARAMETER")
    fun agreePrivacy(view: View) {
        AppPrivacyUtils.setPrivacyAgree(this)
        privacyCloseActivity(view)
    }


    /**
     * 拒绝隐私协议
     * 直接退出程序
     */
    fun disagreePrivacy(view: View) {
        this.finishAffinity()
    }

    fun privacyCloseActivity(view: View) {
        this.finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        getWebView().destroy()
    }

    private fun getWebView(): WebView {
        val view = AppUtils.getRootView(this)
        val pb = ActivityPrivacyBinding.bind(view)
        return pb.privacyWebView
    }
}
