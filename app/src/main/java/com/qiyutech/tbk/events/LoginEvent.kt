package com.qiyutech.tbk.events

import android.content.Context
import com.qiyutech.tbk.logic.TaoBaoLogic
import com.qiyutech.tbk.utils.PushUtils

/**
 * 登陆之后的回调
 */
object LoginEvent {
    /**
     * 回调函数
     */
    fun callback(ctx: Context) {
        /// 登陆之后 需要发送 绑定新的 push ID
        PushUtils.reportPushId(ctx)
        /// 登陆之后自动检测是否已经绑定淘宝号
        TaoBaoLogic.detectTaoBaoBind(ctx)
    }
}

