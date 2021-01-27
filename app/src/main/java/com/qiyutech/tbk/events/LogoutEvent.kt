package com.qiyutech.tbk.events

import android.content.Context
import com.qiyutech.tbk.utils.PushUtils

/**
 * 退出登陆之后的事件
 */
object LogoutEvent {
    /**
     * 回调函数
     */
    fun callback(ctx: Context) {
        PushUtils.reportPushId(ctx)
    }
}
