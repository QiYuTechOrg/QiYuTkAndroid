package com.qiyutech.tbk.utils

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.BuildConfig
import com.qiyutech.tbk.values.AppPreferenceUtils
import com.qiyutech.tbk.values.AppSharedPreferencesName

/**
 * App 辅助函数
 */
object AppUtils {
    /**
     * 获取 activity 的 RootView
     *
     * 主要是为了:
     * ***Binding.bind(view)
     */
    fun getRootView(activity: AppCompatActivity): View {
        /// 怎么样获取 root view
        /// https://stackoverflow.com/questions/4486034/get-root-view-from-current-activity
        return activity.findViewById<ViewGroup>(android.R.id.content).getChildAt(0)
    }

    /**
     * 是否在开发环境 (也就是允许获取测试商品)
     */
    fun inDevEnv(): Boolean {
        if (BuildConfig.ENV == "dev") {
            return true
        }
        return false
    }

    /**
     * 是否在调试环境中
     */
    fun inDebugMode(): Boolean {
        return BuildConfig.DEBUG
    }

    fun versionName(): String {
        return if (inDevEnv()) {
            BuildConfig.VERSION_NAME + "-dev"
        } else {
            BuildConfig.VERSION_NAME
        }
    }

    /**
     * 获取共享的配置
     */
    fun getPreference(ctx: Context): SharedPreferences {
        return ctx.getSharedPreferences(AppSharedPreferencesName.NAME, Context.MODE_PRIVATE)
    }

    /**
     * 检测用户是否登陆
     */
    fun checkUserLogin(ctx: Context): Boolean {
        val token = AppPreferenceUtils.getUserToken(ctx)
        return token != ""
    }
}
