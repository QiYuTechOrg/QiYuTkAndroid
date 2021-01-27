package com.qiyutech.tbk

import com.google.gson.Gson
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Test


data class Demo(val demo: String)

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun jsonDemo() {
        val s = Gson().toJson(Demo("hello"))
        assertEquals("JSON string:", "{\"demo\":\"hello\"}", s)
    }

    @Test
    fun good() {
        val v = Demo("hello")
        val s = Gson().toJson(v)
        val v2 = Gson().fromJson(s, Demo::class.java)
        assertEquals(v, v2)
    }

    @Test
    fun orgJsonGson() {
        val s = Gson().toJson(Demo("hello"))

        val v = JSONObject(s)

        assertEquals("not equal:", v.getString("demo"), "hello")
    }
}
