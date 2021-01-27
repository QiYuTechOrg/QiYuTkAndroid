package com.qiyutech.tbk

// import com.mob.secverify.SecVerify
import android.app.Application
import android.webkit.WebView
import com.alibaba.baichuan.android.trade.AlibcTradeSDK
import com.billy.android.swipe.SmartSwipeBack
import com.qiyutech.tbk.application.AliBCCallback
import com.qiyutech.tbk.application.AppSwipeBack
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.values.AppSpKeys
import java.util.*


/**
 * 我的基础程序进程
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        SmartSwipeBack.activitySlidingBack(this, AppSwipeBack())

        AlibcTradeSDK.asyncInit(this, AliBCCallback(this))

        /// 自动生成 uuid 如果没有生成
        val t = AppUtils.getPreference(this)
        if (!t.contains(AppSpKeys.TBK_UUID)) {
            val uuid = "android-" + UUID.randomUUID().toString()
            t.edit().putString(AppSpKeys.TBK_UUID, uuid).apply()
        }


        if (AppUtils.inDevEnv()) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
    }
}
