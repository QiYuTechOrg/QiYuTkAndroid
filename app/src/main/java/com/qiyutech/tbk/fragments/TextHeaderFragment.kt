package com.qiyutech.tbk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qiyutech.tbk.databinding.FragmentTextHeaderBinding


/**
 * 简单的文字 header 界面
 *
 * 也许应该增加是否需要返回按钮
 */
class TextHeaderFragment(
    private val title: String,
    private val displayBack: Boolean = false
) : Fragment() {

    private var bd: FragmentTextHeaderBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bd = FragmentTextHeaderBinding.inflate(inflater, container, false)
        bd?.let {
            it.title.text = title

            this.initBackButton()

            return it.root
        }
        return null
    }

    private fun initBackButton() {
        bd?.let {
            if (!displayBack) {
                it.backBtn.visibility = View.GONE
            }
            it.backBtn.setOnClickListener {
                this.requireActivity().finish()
            }
        }
    }

    /**
     * 设置新的 title
     */
    fun setTitle(title: String) {
        bd?.let {
            it.title.text = title
        }
    }
}
