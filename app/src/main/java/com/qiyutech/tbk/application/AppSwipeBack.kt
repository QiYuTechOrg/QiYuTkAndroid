package com.qiyutech.tbk.application

import android.app.Activity
import com.billy.android.swipe.SmartSwipeBack
import com.qiyutech.tbk.*

/**
 * 侧边滑动返回
 *
 * https://qibilly.com/SmartSwipe-tutorial/pages/SmartSwipeBack.html
 */
class AppSwipeBack : SmartSwipeBack.ActivitySwipeBackFilter {
    override fun onFilter(activity: Activity?): Boolean {
        if (activity == null) {
            return false
        }

        return when (activity) {
            is DevInfoActivity -> true
            is ItemDetailV2Activity -> true
            is PrivacyActivity -> true
            is SearchActivity -> true
            is SearchDetailNativeActivity -> true
            is SettingsActivity -> true
            is TaoBaoActivity -> true
            is UserInfoActivity -> true
            is UserPasswordActivity -> true
            else -> false
        }
    }
}
