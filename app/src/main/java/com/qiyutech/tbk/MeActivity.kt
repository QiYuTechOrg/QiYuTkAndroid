package com.qiyutech.tbk

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qiyutech.tbk.fragments.SFooterFragment
import com.qiyutech.tbk.fragments.me.MeFragmentDefault
import com.qiyutech.tbk.fragments.me.MeFragmentUser
import com.qiyutech.tbk.logic.TaoBaoLogic
import com.qiyutech.tbk.utils.AppUtils


/**
 * ViewModel
 */
class MeActivityUserViewModel : ViewModel() {
    /**
     * 展示的名称
     */
    val displayName: MutableLiveData<String> by lazy {
        MutableLiveData<String>("...")
    }

    /**
     * 用户 ID
     */
    val uuid: MutableLiveData<String> by lazy {
        MutableLiveData<String>("...")
    }

}


/**
 * 我的界面
 */
class MeActivity : AppCompatActivity() {

    private val viewModel: MeActivityUserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me)
    }

    override fun onStart() {
        super.onStart()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_footer_container, SFooterFragment())
            .commit()
    }

    override fun onResume() {
        super.onResume()

        refreshActivityUI()
    }

    private fun refreshActivityUI() {

        val fragment = if (AppUtils.checkUserLogin(this)) {
            MeFragmentUser()
        } else {
            MeFragmentDefault()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.slot, fragment)
            .commit()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == AUTH_REQUEST_CODE) {
            TaoBaoLogic.detectTaoBaoBind(this)
            return
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


    /**
     * https://developer.android.com/topic/libraries/architecture/viewmodel
     */
    fun getUserViewModel(): MeActivityUserViewModel {
        return viewModel
    }


    override fun onDestroy() {
        super.onDestroy()

        viewModelStore.clear()
    }


    companion object {
        var AUTH_REQUEST_CODE = 2000
    }
}
