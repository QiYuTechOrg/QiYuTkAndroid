package com.qiyutech.tbk.fragments.me

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.qiyutech.tbk.MeActivity
import com.qiyutech.tbk.MeActivityUserViewModel
import com.qiyutech.tbk.databinding.FragmentMeUserBinding
import com.qiyutech.tbk.dt.ApiUserProfileStub
import com.qiyutech.tbk.dt.DtUserTokenForm
import com.qiyutech.tbk.logic.AppErrnoLogic
import com.qiyutech.tbk.logic.DisplayLogic
import com.qiyutech.tbk.logic.TaoBaoLogic
import com.qiyutech.tbk.utils.AppNavUtils
import com.qiyutech.tbk.utils.TipUtils
import com.qiyutech.tbk.values.AppPreferenceUtils


/**
 * 我的已经登陆的界面
 */
class MeFragmentUser : Fragment() {

    var bd: FragmentMeUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val t = FragmentMeUserBinding.inflate(inflater, container, false)
        bd = t
        return t.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bd?.let {
            initButtonEvent(it, view)
        }

        setValueAndInitObserver()
        initSwipeRefresh()
    }

    private fun initButtonEvent(bd: FragmentMeUserBinding, view: View) {
        val activity = this.requireActivity() as MeActivity

        bd.meIcon.setOnClickListener {
            AppNavUtils.gotoUserInfo(activity)
        }


        bd.gotoOrder.setOnClickListener {
            TipUtils.barShort(view, "功能已经移除")
        }



        bd.tryTaobaoAuth.setOnClickListener {
            val bind = AppPreferenceUtils.getBindTaoBao(activity)
            if (bind) {
                Toast.makeText(activity, "淘宝已经授权", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            // 尝试淘宝授权
            val logic = TaoBaoLogic(activity)
            logic.tryAuth()
        }



        bd.gotoSetting.setOnClickListener {
            AppNavUtils.gotoSettings(activity)
        }
    }

    private fun initSwipeRefresh() {
        bd?.let {
            it.swipeRefresh.setOnRefreshListener {
                this.doFetchUserProfile()
            }
        }
    }


    private fun doFetchUserProfile() {
        val activity = this.requireActivity() as MeActivity
        val form = DtUserTokenForm(token = AppPreferenceUtils.getUserToken(activity))
        ApiUserProfileStub.myPost(activity, form,
            { ret ->
                AppErrnoLogic.genericServerErrnoProcess(ret.errno, activity)
                Log.i("user/profile", "$ret")
                try {
                    if (ret.errno != 0) {
                        TipUtils.toastShort(activity, "更新状态失败: ${ret.errmsg}")
                        return@myPost
                    }
                    ret.data?.let { data ->
                        AppPreferenceUtils.setUserInfo(activity, data)
                        val viewModel = this.getUserViewModel()
                        viewModel.displayName.value = DisplayLogic.getDisplayName(activity)
                        viewModel.uuid.value = AppPreferenceUtils.getUserUuid(activity)
                        TipUtils.toastShort(activity, "更新用户状态成功")
                    }
                } finally {
                    bd?.swipeRefresh?.isRefreshing = false
                }
            },
            { error ->
                Log.e("user/profile", "错误信息: ${error.localizedMessage}")
                TipUtils.toastShort(activity, "更新用户状态失败: ${error.localizedMessage}")
                bd?.swipeRefresh?.isRefreshing = false
            })
    }

    private fun setValueAndInitObserver() {
        val activity = this.requireActivity() as MeActivity

        val owner = viewLifecycleOwner
        // Get the ViewModel.
        val model = getUserViewModel()
        // Observe the LiveData, passing in this activity
        // as the LifecycleOwner and the observer.
        model.displayName.removeObservers(owner)
        model.uuid.removeObservers(owner)

        model.displayName.observe(owner, { newMobile ->
            bd!!.meName.text = newMobile
        })

        AppPreferenceUtils.getUserInfo(activity)?.let { userInfo ->
            userInfo.tao_id?.let { taoId ->
                // extract to download image
                val imageUrl =
                    "https://wwc.alicdn.com/avatar/getAvatar.do?userId=${taoId}&width=160&height=160&type=sns"
                bd!!.userIcon.loadImageFromUrl(imageUrl)
            }
        }

        // update UI element
        model.displayName.value = DisplayLogic.getDisplayName(activity)
        model.uuid.value = AppPreferenceUtils.getUserUuid(activity)

    }


    private fun getUserViewModel(): MeActivityUserViewModel {
        val activity = this.requireActivity() as MeActivity

        return activity.getUserViewModel()
    }
}
