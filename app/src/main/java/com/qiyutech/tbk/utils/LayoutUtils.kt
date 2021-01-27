package com.qiyutech.tbk.utils

import android.content.Context

/**
 * @author me
 * @doc https://stackoverflow.com/questions/29664993/how-to-convert-dp-px-sp-among-each-other-especially-dp-and-sp
 */
object LayoutUtils {
    fun spToInt(ctx: Context, sp: Int): Int {
        val multi = ctx.resources.displayMetrics.scaledDensity

        return (sp * multi).toInt()
    }

    fun dpToInt(ctx: Context, dp: Int): Int {
        val multi = ctx.resources.displayMetrics.density

        return (dp * multi).toInt()
    }
}
