package com.qiyutech.tbk

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.databinding.UserPasswordActivityBinding
import com.qiyutech.tbk.fragments.TextHeaderFragment
import com.qiyutech.tbk.logic.UserLogic
import com.qiyutech.tbk.utils.AppUtils


/**
 * 账号密码登陆页面
 */
class UserPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_password_activity)

        supportFragmentManager.beginTransaction()
            .replace(R.id.user_password_header, TextHeaderFragment("奇遇淘客登录", true))
            .commit()
    }

    /**
     * 关闭当前的界面
     */
    fun userPasswordClose(view: View) {
        this.finish()
    }

    /**
     * 用户密码登陆
     */
    fun usernamePasswordLogin(view: View) {
        val rv = AppUtils.getRootView(this)
        val bind = UserPasswordActivityBinding.bind(rv)

        val username = bind.usernameText.text.toString()
        val password = bind.passwordText.text.toString()

        if (username.isEmpty()) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_LONG).show()
            return
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_LONG).show()
            return
        }

        UserLogic.usernamePasswordTryLogin(this, username = username, password = password)
    }
}
