package com.qiyutech.tbk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qiyutech.tbk.*
import com.qiyutech.tbk.databinding.SFooterBinding
import com.qiyutech.tbk.utils.AppNavUtils


/**
 * 导航依赖
 */
class SFooterFragment : Fragment(R.layout.fragment_s_footer) {
    /// 绑定视图到 Fragment
    /// https://developer.android.com/topic/libraries/view-binding
    private var _binding: SFooterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SFooterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menu = binding.homeFooter.menu

        val index = menu.getItem(0)
        if (activity is HomeActivity) {
            index.isChecked = true
        } else {
            index.setOnMenuItemClickListener {
                AppNavUtils.gotoHome(requireActivity())
                true
            }
        }

        val group = menu.getItem(1)
        if (activity is GroupActivity) {
            group.isChecked = true
        } else {
            group.setOnMenuItemClickListener {
                AppNavUtils.gotoGroup(requireActivity())
                true
            }
        }


        val coupon = menu.getItem(2)
        if (activity is CouponActivity) {
            coupon.isChecked = true
        } else {
            coupon.setOnMenuItemClickListener {
                AppNavUtils.gotoCoupon(requireActivity())
                true
            }
        }

        val me = menu.getItem(3)
        if (activity is MeActivity) {
            me.isChecked = true
        } else {
            me.setOnMenuItemClickListener {
                AppNavUtils.gotoMe(requireActivity())
                true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
