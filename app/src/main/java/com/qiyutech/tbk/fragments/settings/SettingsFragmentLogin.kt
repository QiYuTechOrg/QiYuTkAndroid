package com.qiyutech.tbk.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qiyutech.tbk.R
import com.qiyutech.tbk.SettingsActivity
import com.qiyutech.tbk.databinding.FragmentSettingsLoginBinding
import com.qiyutech.tbk.fragments.TextHeaderFragment
import com.qiyutech.tbk.utils.AppNavUtils
import com.qiyutech.tbk.utils.AppUtils

/**
 * 用户没有登陆的界面
 */
class SettingsFragmentLogin : Fragment() {
    /// 版本点击了多少次
    var versionClicked = 0

    private var bd: FragmentSettingsLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bd = FragmentSettingsLoginBinding.inflate(inflater, container, false)
        bd?.let {
            it.version.text = AppUtils.versionName()

            it.currentVersion.setOnClickListener {
                versionClicked += 1
                if (versionClicked == 6) {
                    AppNavUtils.gotoDevInfo(requireActivity())
                }
            }
            it.checkVersionUpdate.setOnClickListener { view ->
                val activity = this.requireActivity() as SettingsActivity
                activity.checkAppUpgrade(view)
            }
            it.showPrivacy.setOnClickListener {
                AppNavUtils.gotoPrivacy(this.requireActivity())
            }
            it.cleanCache.setOnClickListener { view ->
                val activity = this.requireActivity() as SettingsActivity
                activity.deleteCacheFiles(view)
            }
            it.userLogin.setOnClickListener {
                val activity = this.requireActivity() as SettingsActivity
                AppNavUtils.gotoUserPassword(activity)
            }
            return it.root
        }
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = this.requireActivity()
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.setting_header, TextHeaderFragment("设置", true))
            .commit()
    }
}
