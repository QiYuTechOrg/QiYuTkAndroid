package com.qiyutech.tbk.fragments.me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qiyutech.tbk.databinding.FragmentMeSlotBinding


/**
 * 我的已经登陆的界面
 */
class MeFragmentSlot : Fragment() {

    var bd: FragmentMeSlotBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val t = FragmentMeSlotBinding.inflate(inflater, container, false)
        bd = t
        return t.root
    }
}
