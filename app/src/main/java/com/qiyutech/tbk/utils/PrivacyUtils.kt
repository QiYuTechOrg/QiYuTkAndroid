package com.qiyutech.tbk.utils

import android.content.Context
import com.qiyutech.tbk.values.AppPreferenceUtils

/**
 * 奇遇淘客隐私政策辅助类
 */
object AppPrivacyUtils {
    /**
     * 是否已经同意隐私政策
     */
    fun isPrivacyAgree(ctx: Context): Boolean {
        return AppPreferenceUtils.getPrivacyAgree(ctx)
    }

    /**
     * 设置已经同意隐私政策
     */
    fun setPrivacyAgree(ctx: Context) {
        AppPreferenceUtils.setPrivacyAgree(ctx)
    }
}
