package com.qiyutech.tbk

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.baichuan.android.trade.AlibcTrade
import com.alibaba.baichuan.android.trade.model.AlibcShowParams
import com.alibaba.baichuan.android.trade.model.OpenType
import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcFailModeType
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams
import com.alibaba.baichuan.trade.biz.login.AlibcLogin
import com.alibaba.baichuan.trade.biz.login.AlibcLoginCallback
import com.qiyutech.tbk.activity.taobao.MyAuthTradeCb
import com.qiyutech.tbk.databinding.ActivityTaoBaoBinding
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.values.AppPreferenceUtils
import com.qiyutech.tbk.values.LogTags

@SuppressLint("SetJavaScriptEnabled")
class TaoBaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tao_bao)
    }

    @SuppressLint("JavascriptInterface")
    override fun onStart() {
        super.onStart()

        val wv = getTaoBaoWebView()
        wv.settings.javaScriptEnabled = true

        when (intent.getStringExtra("type")) {
            "auth" -> {
                myOpenAuthPage()
            }
            else -> {
                this.finish()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        val wv = getTaoBaoWebView()
        wv.destroy()
    }

    private fun getTaoBaoWebView(): WebView {
        val view = AppUtils.getRootView(this)
        val tbd = ActivityTaoBaoBinding.bind(view)
        return tbd.taoBaoWebView
    }

    private fun myOpenAuthPage() {
        val url = intent.getStringExtra("url")

        val activity = this

        /// 淘宝授权免密码输入
        /// https://blog.csdn.net/get_moon/article/details/102593901

        val alibc = AlibcLogin.getInstance()
        alibc.showLogin(object : AlibcLoginCallback {
            override fun onSuccess(LoginResult: Int, openId: String?, userNick: String?) {
                // loginResult(0--登录初始化成功；1--登录初始化完成；2--登录成功)
                // openId：用户id
                // userNick: 用户昵称

                // save user nick
                // save user avatar
                val session = alibc.session
                AppPreferenceUtils.setTaoId(activity, session.userid)

                Log.i(LogTags.AliBC, "$session")

                val show = AlibcShowParams()

                show.openType = OpenType.Auto
                show.clientType = "taobao"
                show.nativeOpenFailedMode = AlibcFailModeType.AlibcNativeFailModeJumpH5

                val taoke = AlibcTaokeParams("", "", "")
                taoke.pid = BuildConfig.ALI_PID

                AlibcTrade.openByUrl(
                    activity,
                    "",
                    url,
                    getTaoBaoWebView(),
                    WebViewClient(),
                    WebChromeClient(),
                    show,
                    taoke,
                    null,
                    MyAuthTradeCb()
                )
            }

            override fun onFailure(code: Int, msg: String?) {
                // code 错误码
                // msg  错误信息
                Toast.makeText(activity, "淘宝授权失败($code): $msg", Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {
        fun openAuthPage(activity: Activity, url: String) {
            val intent = Intent(activity, TaoBaoActivity::class.java)

            intent.putExtra("type", "auth") // enum type
            intent.putExtra("url", url)

            // activity.startActivity(intent)
            activity.startActivityForResult(intent, MeActivity.AUTH_REQUEST_CODE)
        }
    }
}
