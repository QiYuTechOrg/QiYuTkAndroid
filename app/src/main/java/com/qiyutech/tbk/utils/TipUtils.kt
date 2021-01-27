package com.qiyutech.tbk.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

object TipUtils {

    fun toastShort(ctx: Context, s: String) {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show()
    }

    fun toastLong(ctx: Context, s: String) {
        Toast.makeText(ctx, s, Toast.LENGTH_LONG).show()
    }

    fun barShort(view: View, msg: String) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show()
    }

    fun barLong(view: View, msg: String) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
    }
}
