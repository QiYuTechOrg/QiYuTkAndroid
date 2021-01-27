package com.qiyutech.tbk.application

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback
import com.qiyutech.tbk.values.LogTags

/**
 * 阿里百川回调
 */
class AliBCCallback(private val app: Application) : AlibcTradeInitCallback {
    override fun onFailure(p0: Int, p1: String?) {
        Toast.makeText(app.baseContext, "阿里百川初始化失败: $p1($p0)", Toast.LENGTH_LONG).show()
        Log.i(LogTags.AliBC, "初始化失败: $p1($p0)")
    }

    override fun onSuccess() {
        Log.i(LogTags.AliBC, "初始化成功")
    }
}
