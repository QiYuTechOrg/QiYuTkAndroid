package com.qiyutech.tbk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.fragments.TextHeaderFragment
import com.qiyutech.tbk.utils.AppNavUtils
import com.qiyutech.tbk.utils.AppPrivacyUtils
import com.qiyutech.tbk.utils.DialogUtils
import com.qiyutech.tbk.utils.PushUtils
import com.qiyutech.tbk.values.LogTags


/**
 * 主页面
 */
class HomeActivity : AppCompatActivity() {
    private var mAlreadyInit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager.beginTransaction()
            .replace(R.id.index_header, TextHeaderFragment("奇遇淘客"))
            .commit()

    }


    override fun onStart() {
        super.onStart()

        if (!mAlreadyInit) {
            oneTimeInit()
        }

        if (!AppPrivacyUtils.isPrivacyAgree(this)) {
            AppNavUtils.gotoPrivacy(this, false)
        }
    }


    private fun oneTimeInit() {
        if (mAlreadyInit) {
            return
        }
        PushUtils.reportPushId(this)
        notificationCheck()

        mAlreadyInit = true
    }

    private fun notificationCheck() {
        if (PushUtils.isNotificationEnabled(applicationContext)) {
            Log.i(LogTags.Push, "推送已经开启")
        } else {
            Log.i(LogTags.Push, "推送没有开启")
            val dialog = DialogUtils.notificationDialog(this)
            dialog.show()
        }
    }

}
