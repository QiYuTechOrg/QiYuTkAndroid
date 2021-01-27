package com.qiyutech.tbk.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationManagerCompat

/**
 * 推送活动
 */
object PushUtils {
    /**
     * 检测 通知消息是否已经 打开
     */
    fun isNotificationEnabled(context: Context): Boolean {
        return NotificationManagerCompat.from(context).areNotificationsEnabled()
    }

    /**
     * 上报 设备的 推送 id
     *
     * 在
     * * 用户登陆
     * * 用户登出
     * * 打开 APP
     * 的时候需要上报
     */
    fun reportPushId(context: Context) {
    }

    /**
     * 通知权限申请
     * @param context
     */
    fun requestNotify(context: Context) {
        ///< 直接跳转到应用通知设置的代码
        val localIntent = Intent()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            localIntent.action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
            localIntent.putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
            localIntent.putExtra(Settings.EXTRA_CHANNEL_ID, context.applicationInfo.uid)
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            localIntent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            localIntent.data = Uri.fromParts("package", context.packageName, null)
        }

        context.startActivity(localIntent)
    }
}
