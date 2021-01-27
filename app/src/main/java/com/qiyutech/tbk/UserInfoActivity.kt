package com.qiyutech.tbk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.databinding.ActivityUserInfoBinding
import com.qiyutech.tbk.databinding.PartsSimpleKvInfoBinding
import com.qiyutech.tbk.fragments.TextHeaderFragment
import com.qiyutech.tbk.logic.TaoBaoLogic
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.utils.DialogUtils
import com.qiyutech.tbk.values.AppPreferenceUtils

/**
 * 用户状态展示
 */
class UserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)


        supportFragmentManager.beginTransaction()
            .replace(R.id.header, TextHeaderFragment("用户信息", true))
            .commit()

        initBtnEvent()
    }

    override fun onStart() {
        super.onStart()

        initUserInfo()
    }

    private fun initBtnEvent() {
        val bd = getBinding()
        bd.bindTb.setOnClickListener {
            val doBind = {
                val logic = TaoBaoLogic(this)
                logic.tryAuth()
            }
            AppPreferenceUtils.getUserInfo(this)?.let { userInfo ->
                userInfo.relation_id?.let {
                    // 已经绑定了淘宝账号, 是否重新绑定
                    DialogUtils.reBindTbDialog(this) {
                        doBind()
                    }
                    return@setOnClickListener
                }
            }
            doBind()
        }
    }

    private fun initUserInfo() {
        val userInfo = AppPreferenceUtils.getUserInfo(this)
        if (userInfo == null) {
            this.finish()
            return
        }

        val bd = getBinding()

        setKV(bd.mobile, "手机号码", userInfo.mobile ?: "")
        setKV(bd.taoId, "淘宝ID", userInfo.tao_id ?: "")
        setKV(bd.wx, "微信", userInfo.wx ?: "")
        setKV(bd.relationId, "渠道ID", userInfo.relation_id ?: "")
        setKV(bd.aliName, "支付宝姓名", userInfo.ali_name ?: "")
        setKV(bd.aliAccount, "支付宝账号", userInfo.ali_account ?: "")
    }

    private fun setKV(bd: PartsSimpleKvInfoBinding, k: String, v: String) {
        bd.key.text = k
        bd.value.text = v
    }

    private fun getBinding(): ActivityUserInfoBinding {
        val rv = AppUtils.getRootView(this)
        return ActivityUserInfoBinding.bind(rv)
    }
}
