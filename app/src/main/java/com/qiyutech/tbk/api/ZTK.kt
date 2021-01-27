package com.qiyutech.tbk.api

import androidx.appcompat.app.AppCompatActivity
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.qiyutech.tbk.dt.DtKeywordResponseModel
import com.qiyutech.tbk.dt.DtSuggestResponseModel
import com.qiyutech.tbk.utils.MyHttpUtils
import com.qiyutech.tbk.values.TbkAPIUrls
import java.net.URLEncoder

/**
 * 折淘客 API 接口
 */
class ZTK(val activity: AppCompatActivity, val tag: String) {

    /**
     * 获取 推荐词 的请求
     */
    fun suggestV2(
        q: String,
        success: (DtSuggestResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val url = "${TbkAPIUrls.ZtkSuggest}?content=${URLEncoder.encode(q, "UTF-8")}"
        val r = MyHttpUtils.getRequest(url, success, failure)
        addToQueue(r)
    }


    /**
     * 热词推荐
     */
    fun hotKeyword(success: (DtKeywordResponseModel) -> Unit, failure: (VolleyError) -> Unit) {
        val r = MyHttpUtils.getRequest(
            TbkAPIUrls.ZtkKeyword,
            success,
            failure
        )
        addToQueue(r)
    }

    private fun addToQueue(r: JsonObjectRequest) {
        r.tag = tag
        val volley = Volley.newRequestQueue(activity)
        volley.add(r)
    }
}
