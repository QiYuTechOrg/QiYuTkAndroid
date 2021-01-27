package com.qiyutech.tbk.logic

import android.content.Context
import android.util.Log
import com.qiyutech.tbk.dt.DtAppErrno
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.utils.TipUtils

/**
 * 奇遇淘客错误处理逻辑
 */
object AppErrnoLogic {
    /**
     * 通用的奇遇淘客错误处理逻辑
     *
     * 每一个请求都要使用这个函数去处理错误码
     */
    fun genericServerErrnoProcess(errno: DtAppErrno, ctx: Context) {
        when (errno) {
            0 -> {
                // success do nothing
            }
            1 -> {
                // 未知的错误
                TipUtils.toastLong(ctx, "未知错误 ~_~ 请稍后再试 (错误码: ${errno})")
            }
            2 -> {
                // 系统内部错误
                TipUtils.toastLong(ctx, "网络错误 ~_~ 请稍后再试 (错误码: ${errno})")
            }
            10 -> {
                // 无效的用输入
            }
            11 -> {
                // 认证失败 [登陆失败]
                TipUtils.toastLong(ctx, "登录凭证已经过期，请重新登录")
                UserLogic.logout(ctx)
            }
            20 -> {
                //     not_found = 20  # 未找到指定内容
            }
            21 -> {
                // token_invalid = 21  # 无效的 token  [客户端应该执行退出 ， 重新登录]
                // 执行 UserLogout 操作
                TipUtils.toastShort(ctx, "请登录后再试 (错误码: ${errno})")
                UserLogic.logout(ctx)
            }
            22 -> {
                //     ztk_error = 22  # 折淘客错误
            }
            23 -> {
                // user_not_exists = 23  # 用户不存在
            }
            24 -> {
                // 大淘客错误
                TipUtils.toastShort(ctx, "请求淘宝商品失败 错误($errno)")
                Log.i("大淘客", "请求大淘客失败")
            }
            30 -> {
                // release_not_found = 30  # 没有发布的历史
            }
            40 -> {
                // no_channel_id = 40  # 没有渠道 id
            }
            41 -> {
                //     item_not_found = 41  # 没有找到指定的商品
                TipUtils.toastLong(ctx, "没有找到对应的商品 (错误码: ${errno})")
            }
            else -> {
                // any other unknown value do nothing
                if (AppUtils.inDebugMode()) {
                    TipUtils.toastLong(ctx, "系统遇到了未知的错误, 请检查是否为最新版 (错误码: ${errno})")
                }
            }
        }
    }
}
