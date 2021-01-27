package com.qiyutech.tbk.activity.taobao

import android.util.Log
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult
import com.qiyutech.tbk.values.LogTags

/**
 * 打开 认证页面的 回调
 */
class MyAuthTradeCb : AlibcTradeCallback {
    override fun onFailure(p0: Int, p1: String?) {
        Log.e(LogTags.AliBC, "错误信息: ${p0}: $p1")
    }

    override fun onTradeSuccess(p: AlibcTradeResult?) {
        if (p == null) {
            return
        }
        Log.i(LogTags.AliBC, p.toString())
    }
}
