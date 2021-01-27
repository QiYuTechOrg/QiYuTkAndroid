package com.qiyutech.tbk.utils

import android.app.Activity
import android.content.ClipData
import android.content.ClipDescription.MIMETYPE_TEXT_PLAIN
import android.content.ClipboardManager

object ClipboardUtils {
    /**
     * 复制到剪切板
     */
    fun copy(txt: String, activity: Activity) {
        val clip =
            activity.getSystemService(Activity.CLIPBOARD_SERVICE) as ClipboardManager
        val data = ClipData.newPlainText("TEXT", txt)
        clip.setPrimaryClip(data)
    }

    fun read(activity: Activity): String {
        val clip = activity.getSystemService(Activity.CLIPBOARD_SERVICE) as ClipboardManager

        clip.primaryClipDescription?.let { desc ->
            if (desc.hasMimeType(MIMETYPE_TEXT_PLAIN)) {
                clip.primaryClip?.let {
                    it.getItemAt(0)?.let { item ->
                        return item.text.toString()
                    }
                }
            }
        }

        return ""
    }
}
