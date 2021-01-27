package com.qiyutech.tbk.utils

import android.widget.Toast
import com.qiyutech.tbk.SearchActivity
import com.qiyutech.tbk.api.ZTK
import com.qiyutech.tbk.values.HttpTags

/**
 * 加载热词搜索列表
 */
class LoadKeywordUtils(private val activity: SearchActivity) {
    /**
     * 加载搜索热词列表
     */
    fun loadKeyword() {
        val ztk = ZTK(activity, HttpTags.SEARCH)
        ztk.hotKeyword(
            { v ->
                if (v.errno != 0) {
                    Toast.makeText(activity, v.errmsg, Toast.LENGTH_SHORT).show()
                } else {
                    v.data?.let { data ->
                        activity.pushHotSearchKeyword(data)
                    }
                }
            },
            {
                println(it)
            }
        )
    }
}
