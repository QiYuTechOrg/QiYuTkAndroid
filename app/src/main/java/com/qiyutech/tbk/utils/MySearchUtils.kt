package com.qiyutech.tbk.utils

import com.qiyutech.tbk.CouponActivity
import com.qiyutech.tbk.SearchActivity
import com.qiyutech.tbk.values.AppPreferenceUtils

object MySearchUtils {
    /**
     * 执行搜索功能
     */
    fun doSearch(activity: SearchActivity, query: String) {
        val history = AppPreferenceUtils.getSearchHistory(activity)
        val newHistory = history.toMutableList()
        newHistory.add(0, query)
        AppPreferenceUtils.setSearchHistory(activity, newHistory)

        // 重新加载搜索历史
        activity.loadSearchHistoryKeyword()

        AppNavUtils.gotoSearchDetailNative(activity, query)
    }

    /**
     * 优惠券界面的搜索
     */
    fun doCouponSearch(activity: CouponActivity, query: String) {
        AppNavUtils.gotoSearchDetailNative(activity, query)
    }
}
