package com.qiyutech.tbk.utils

import com.google.gson.Gson
import org.json.JSONObject
import java.lang.reflect.Type


object MyJsonUtils {

    fun <T> fromString(s: String, t: Class<T>): T {
        return Gson().fromJson<T>(s, t as Type)
    }

    fun <T> toString(v: T): String {
        return Gson().toJson(v)
    }

    fun <T> fromJsonToClass(v: JSONObject, t: Class<T>): T {
        val s = v.toString()
        return Gson().fromJson(s, t as Type)
    }


    inline fun <reified T> fromClassToJson(v: T): JSONObject {
        val s = Gson().toJson(v)
        return JSONObject(s)
    }
}
