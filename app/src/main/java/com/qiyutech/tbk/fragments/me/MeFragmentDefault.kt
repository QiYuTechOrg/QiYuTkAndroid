package com.qiyutech.tbk.fragments.me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qiyutech.tbk.databinding.FragmentMeDefaultBinding
import com.qiyutech.tbk.utils.AppNavUtils


/**
 * 我的默认界面【没有登录】
 */
class MeFragmentDefault : Fragment() {

    var bd: FragmentMeDefaultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val t = FragmentMeDefaultBinding.inflate(inflater, container, false)
        bd = t
        return t.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bd?.let {

            it.gotoSetting.setOnClickListener {
                AppNavUtils.gotoSettings(requireActivity())
            }

            it.meName.setOnClickListener {
                // todo login
            }
        }
    }
}
