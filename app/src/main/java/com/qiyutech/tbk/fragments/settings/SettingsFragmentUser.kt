package com.qiyutech.tbk.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qiyutech.tbk.R
import com.qiyutech.tbk.SettingsActivity
import com.qiyutech.tbk.databinding.FragmentSettingsUserBinding
import com.qiyutech.tbk.fragments.TextHeaderFragment
import com.qiyutech.tbk.utils.AppNavUtils
import com.qiyutech.tbk.utils.AppUtils


/**
 * 用户已经登陆的 fragment
 */
class SettingsFragmentUser : Fragment() {
    var versionClicked: Int = 0

    private var bd: FragmentSettingsUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bd = FragmentSettingsUserBinding.inflate(inflater, container, false)
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
            it.exitLogin.setOnClickListener { view ->
                val activity = this.requireActivity() as SettingsActivity
                activity.settingUserLogout(view)
            }
            it.cancelUser.setOnClickListener { view ->
                val activity = this.requireActivity() as SettingsActivity
                activity.settingUserCancel(view)
            }

            return it.root
        }
        return null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bd?.let {
            val activity = this.requireActivity()

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.setting_header, TextHeaderFragment("设置", true))
                .commit()
        }
    }
}
