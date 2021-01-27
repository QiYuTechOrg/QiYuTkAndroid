package com.qiyutech.tbk.utils

import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.values.LogTags

/// 弹窗辅助类
object DialogUtils {

    /**
     * 推送通知检测对话框
     */
    fun notificationDialog(activity: AppCompatActivity): AlertDialog {
        val builder = AlertDialog.Builder(activity)
        builder.apply {
            setPositiveButton("去开启") { _, _ ->
                PushUtils.requestNotify(activity)
            }
            setNegativeButton("不用了") { _, _ ->
            }
        }

        builder.setTitle("开启推送")
        builder.setMessage("您没有给奇遇淘客开启消息推送，这样会导致错过一些重要信息, 是否去开启?")

        return builder.create()
    }

    /**
     * 淘宝重新授权
     */
    fun reBindTbDialog(
        activity: AppCompatActivity,
        doFunc: (activity: AppCompatActivity) -> Unit
    ): AlertDialog {
        val builder = AlertDialog.Builder(activity)

        builder.apply {
            setPositiveButton("重新授权") { _, _ ->
                doFunc(activity)
            }
            setNegativeButton("取消") { _, _ ->
            }
        }

        builder.setTitle("淘宝授权")
        builder.setMessage("您已经绑定过淘宝账号，重新授权会导致之前绑定的账号失效?")

        return builder.create()
    }

    /**
     * 用户注销用户的弹窗
     */
    fun userCancelDialog(
        activity: AppCompatActivity,
        doFunc: (AppCompatActivity) -> Unit
    ): AlertDialog {
        val builder = AlertDialog.Builder(activity)
        builder.apply {
            setPositiveButton("确认注销") { _, _ ->
                doFunc(activity)
            }
            setNegativeButton("取消") { _, _ ->
            }
        }

        builder.setTitle("注销账户")
        builder.setMessage("您是否确认注销当前的用户?\n\n注销账户之后:\n您将无法使用与会员有关的相关功能")

        return builder.create()
    }

    /**
     * 创建 dialog
     */
    fun createDialog(activity: AppCompatActivity): AlertDialog {
        val builder = AlertDialog.Builder(activity)

        builder.apply {
            setPositiveButton("确认") { dialog, id ->
                // User clicked OK button
                Log.i(LogTags.Dialog, id.toString())
                Log.i(LogTags.Dialog, "确认")
            }
            setNegativeButton("取消") { dialog, id ->
                // User cancelled the dialog
                Log.i(LogTags.Dialog, id.toString())
                Log.i(LogTags.Dialog, "取消")
            }
            setNeutralButton("你猜") { dialog, id ->
                Log.i(LogTags.Dialog, id.toString())
                Log.i(LogTags.Dialog, "你猜")
            }
        }

        // Set other dialog properties
        builder.setTitle("测试弹窗")
        builder.setMessage("这是一个测试的消息")

        // Create the AlertDialog
        return builder.create()
    }
}
