package com.qiyutech.tbk.utils

import android.app.Activity
import android.content.Intent
import com.qiyutech.tbk.*

/**
 * [AppNavUtils] 全局导航辅助类
 */
object AppNavUtils {

    /**
     * 从当前的 [activity] 跳转到 [SettingsActivity]
     */
    fun gotoSettings(activity: Activity) {
        val intent = Intent(activity, SettingsActivity::class.java)
        goto(activity, intent)
    }

    /**
     * 从当前的 [activity] 跳转到 [GroupActivity]
     */
    fun gotoGroup(activity: Activity) {
        val intent = Intent(activity, GroupActivity::class.java)
        goto(activity, intent)
    }

    /**
     * 从当前的 [activity] 跳转到 [HomeActivity]
     */
    fun gotoHome(activity: Activity) {
        val intent = Intent(activity, HomeActivity::class.java)
        goto(activity, intent)
    }

    /**
     * 从当前的 [activity] 跳转到 [CouponActivity]
     */
    fun gotoCoupon(activity: Activity) {
        val intent = Intent(activity, CouponActivity::class.java)
        goto(activity, intent)
    }

    /**
     * 从当前的 [activity] 跳转到 [PrivacyActivity]
     *
     * view 是否是展示模式:
     *  如果是展示模式则不附带 确认/不同意 按钮
     *  默认是 纯展示 模式
     */
    fun gotoPrivacy(activity: Activity, view: Boolean = true) {
        val intent = Intent(activity, PrivacyActivity::class.java)
        intent.putExtra("view", view)
        goto(activity, intent)
    }


    /**
     * 从当前的 [activity] 跳转到 [SearchDetailNativeActivity]
     */
    fun gotoSearchDetailNative(activity: Activity, query: String) {
        val intent = Intent(activity, SearchDetailNativeActivity::class.java)
        intent.putExtra("query", query)
        goto(activity, intent)
    }


    /**
     * 从当前的 [activity] 跳转到 [MeActivity]
     */
    fun gotoMe(activity: Activity) {
        val intent = Intent(activity, MeActivity::class.java)
        goto(activity, intent)
    }


    /**
     * 跳转到商品详情页面
     */
    fun gotoItemDetailV2(activity: Activity, itemId: String) {
        val intent = Intent(activity, ItemDetailV2Activity::class.java)
        intent.putExtra("item_id", itemId)
        goto(activity, intent)
    }


    /**
     * 从当前的 [activity] 跳转到 [UserPasswordActivity]
     *
     * 账号登陆
     */
    fun gotoUserPassword(activity: Activity) {
        val intent = Intent(activity, UserPasswordActivity::class.java)
        goto(activity, intent)
    }


    /**
     * 跳转到开发信息界面
     */
    fun gotoDevInfo(activity: Activity) {
        val intent = Intent(activity, DevInfoActivity::class.java)
        goto(activity, intent)
    }

    /**
     * 跳转到用户信息界面
     */
    fun gotoUserInfo(activity: Activity) {
        val intent = Intent(activity, UserInfoActivity::class.java)
        goto(activity, intent)
    }


    private fun goto(activity: Activity, intent: Intent) {
        activity.startActivity(intent)
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}
