package com.qiyutech.tbk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.databinding.ActivityDevInfoBinding
import com.qiyutech.tbk.databinding.PartsSimpleKvInfoBinding
import com.qiyutech.tbk.fragments.TextHeaderFragment
import com.qiyutech.tbk.utils.AppUtils

/**
 * 开发信息模式
 */
class DevInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_info)

        supportFragmentManager.beginTransaction()
            .replace(R.id.header, TextHeaderFragment("开发信息", true))
            .commit()

        val rv = AppUtils.getRootView(this)
        val bd = ActivityDevInfoBinding.bind(rv)


        val debug = if (AppUtils.inDebugMode()) {
            "是"
        } else {
            "否"
        }
        val test = if (AppUtils.inDevEnv()) {
            "是"
        } else {
            "否"
        }

        setKV(bd.debug, "调试", debug)
        setKV(bd.test, "测试", test)
        setKV(bd.server, "服务器", BuildConfig.BASE_URL)
        setKV(bd.sdkInt, "Android SDK", android.os.Build.VERSION.SDK_INT.toString())
        setKV(bd.mobileModel, "设备型号", android.os.Build.MODEL)
        setKV(bd.manufacturer, "制造商", android.os.Build.MANUFACTURER)
    }

    private fun setKV(p: PartsSimpleKvInfoBinding, k: String, v: String) {
        p.key.text = k
        p.value.text = v
    }
}
