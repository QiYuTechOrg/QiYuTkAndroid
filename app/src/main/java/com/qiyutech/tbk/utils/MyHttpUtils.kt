package com.qiyutech.tbk.utils

import android.content.Context
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.Volley
import com.qiyutech.tbk.activity.question.MyGetRequest
import com.qiyutech.tbk.activity.question.MyJsonObjectRequest

object MyHttpUtils {

    /**
     * 取消所有的 HTTP 请求
     *
     * 应该在 onStop 的时候使用
     */
    fun cancelAllRequest(ctx: Context, tag: String) {
        Volley.newRequestQueue(ctx).cancelAll(tag)
    }

    /**
     * 添加到 HTTP 处理队列
     * 不要忘记了 在 onStop 的时候调用 cancelAllRequest
     */
    fun <T> addToQueue(ctx: Context, tag: String, request: Request<T>) {
        request.tag = tag
        Volley.newRequestQueue(ctx).add(request)
    }

    inline fun <reified Out> getRequest(
        url: String,
        crossinline success: (Out) -> Unit,
        crossinline failure: (VolleyError) -> Unit
    ): MyGetRequest {

        return MyGetRequest(
            url,
            { response ->
                val out = MyJsonUtils.fromJsonToClass(response, Out::class.java)
                success(out)
            },
            { failure(it) })
    }

    inline fun <reified Data, reified Out> postRequest(
        url: String,
        data: Data,
        crossinline success: (Out) -> Unit,
        crossinline failure: (VolleyError) -> Unit
    ): MyJsonObjectRequest {
        val json = MyJsonUtils.fromClassToJson(data)

        return MyJsonObjectRequest(
            Request.Method.POST, url, json,
            { response ->
                val out = MyJsonUtils.fromJsonToClass(response, Out::class.java)
                success(out)
            },
            { failure(it) })
    }
}
