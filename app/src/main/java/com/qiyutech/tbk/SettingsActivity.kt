package com.qiyutech.tbk

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.fragments.settings.SettingsFragmentLogin
import com.qiyutech.tbk.fragments.settings.SettingsFragmentUser
import com.qiyutech.tbk.logic.UserLogic
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.utils.DialogUtils
import com.qiyutech.tbk.utils.PopupUtils

/**
 * 配置 UI 页面
 */
class SettingsActivity : AppCompatActivity() {
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
    }

    override fun onStart() {
        super.onStart()

        this.refreshUI()
    }

    private fun refreshUI() {
        val fragment = if (AppUtils.checkUserLogin(this)) {
            SettingsFragmentUser()
        } else {
            SettingsFragmentLogin()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.setting_slot, fragment)
            .commit()
    }


    // 注销用户
    @Suppress("UNUSED_PARAMETER")
    fun settingUserCancel(view: View) {
        if (!AppUtils.checkUserLogin(this)) {
            return
        }

        /// 用户确认之后执行 注销用户的逻辑
        DialogUtils.userCancelDialog(this) {
            UserLogic.cancel(this)
        }.show()
    }

    /**
     * 退出登陆
     */
    @Suppress("UNUSED_PARAMETER")
    fun settingUserLogout(view: View) {
        if (AppUtils.checkUserLogin(this)) {
            UserLogic.logout(this)
            Toast.makeText(this, "您已经退出登陆!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "您当前没有登陆!", Toast.LENGTH_LONG).show()
        }
        setNotLoginView()
    }

    fun setNotLoginView() {
        // 用户已经退出登陆
        this.refreshUI()
    }

    /**
     * android 清理缓存
     */
    fun deleteCacheFiles(view: View) {

        val (_, popupWindow) = PopupUtils.createPopup(
            view,
            inflater = layoutInflater,
            R.layout.popup_clean_cache,
            false
        )

        val activity = this
        val cache = cacheDir

        Thread {
            cache.deleteRecursively()

            runOnUiThread {
                popupWindow.dismiss()
                Toast.makeText(activity, "清理缓存完成", Toast.LENGTH_LONG).show()
            }
        }.start()
    }


    /**
     * 检测是否有新版本 [android 检测] iOS 使用 App Store 接口就可以了
     */
    fun checkAppUpgrade(view: View) {
        Toast.makeText(this, "此功能已经移除", Toast.LENGTH_LONG).show()
    }
}
