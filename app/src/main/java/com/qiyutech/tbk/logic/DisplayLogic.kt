package com.qiyutech.tbk.logic

import android.content.Context
import com.qiyutech.tbk.values.AppPreferenceUtils

/**
 * 展示的逻辑
 */
object DisplayLogic {
    /**
     * 获取展示的名称
     *
     * 在我的里面展示的名称
     */
    fun getDisplayName(ctx: Context): String {
        AppPreferenceUtils.getUserInfo(ctx)?.let {
            it.mobile?.let { mobile ->
                return mobile
            }
        }

        // 啥都没有就显示奇遇淘客
        return "奇遇淘客"
    }
}
