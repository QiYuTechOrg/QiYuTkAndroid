package com.qiyutech.tbk.activity.question

import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

class MyJsonObjectRequest(
    i: Int,
    url: String,
    json: JSONObject,
    success: Response.Listener<JSONObject>,
    failure: Response.ErrorListener
) :
    JsonObjectRequest(i, url, json, success, failure) {

    override fun getHeaders(): Map<String, String> {
        return mapOf("Accept" to "application/json", "Content-Type" to "application/json")
    }
}

class MyGetRequest(
    url: String,
    success: Response.Listener<JSONObject>,
    failure: Response.ErrorListener
) : JsonObjectRequest(Method.GET, url, null, success, failure) {

    override fun getHeaders(): Map<String, String> {
        return mapOf("accept" to "application/json")
    }
}


class MySuggestRequest(
    url: String,
    success: Response.Listener<JSONObject>,
    failure: Response.ErrorListener
) :
    JsonObjectRequest(url, null, success, failure) {

    override fun getHeaders(): Map<String, String> {
        return mapOf("accept" to "application/json")
    }
}

