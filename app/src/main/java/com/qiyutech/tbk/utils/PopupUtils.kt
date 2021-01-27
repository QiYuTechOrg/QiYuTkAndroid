package com.qiyutech.tbk.utils

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.annotation.LayoutRes

/**
 * 弹出框辅助类
 */
object PopupUtils {
    /**
     * 创建弹出框
     *    boolean focusable = true; // lets taps outside the popup also dismiss it
     *
     * doc: https://stackoverflow.com/questions/5944987/how-to-create-a-popup-window-popupwindow-in-android
     */
    fun createPopup(
        view: View,
        inflater: LayoutInflater,
        @LayoutRes resource: Int,
        focusable: Boolean
    ): Pair<View, PopupWindow> {
        val popupView = inflater.inflate(resource, null)

        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT

        val popupWindow = PopupWindow(popupView, width, height, focusable)
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

        return Pair(popupView, popupWindow)
    }

    fun createFullScreenPopup(
        view: View,
        inflater: LayoutInflater,
        @LayoutRes resource: Int,
        focusable: Boolean
    ): Pair<View, PopupWindow> {
        val popupView = inflater.inflate(resource, null)

        val width = LinearLayout.LayoutParams.MATCH_PARENT
        val height = LinearLayout.LayoutParams.MATCH_PARENT

        val popupWindow = PopupWindow(popupView, width, height, focusable)
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

        return Pair(popupView, popupWindow)
    }

}

