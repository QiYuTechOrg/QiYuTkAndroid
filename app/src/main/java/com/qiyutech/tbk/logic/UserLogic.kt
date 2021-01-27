package com.qiyutech.tbk.logic

import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.qiyutech.tbk.SettingsActivity
import com.qiyutech.tbk.UserPasswordActivity
import com.qiyutech.tbk.dt.*
import com.qiyutech.tbk.events.LoginEvent
import com.qiyutech.tbk.events.LogoutEvent
import com.qiyutech.tbk.utils.MyHttpUtils
import com.qiyutech.tbk.utils.TipUtils
import com.qiyutech.tbk.values.AppPreferenceUtils
import com.qiyutech.tbk.values.LogTags
import com.qiyutech.tbk.values.TbkAPIUrls


object UserLogic {

    /**
     * 用户密码尝试登陆
     */
    fun usernamePasswordTryLogin(
        activity: UserPasswordActivity,
        username: String,
        password: String
    ) {

        val form = DtUserNativeAuthForm(username, password)

        ApiUserAuthStub.myPost(activity, form, { ret ->
            if (ret.errno != 0) {
                Toast.makeText(activity, "请求失败(${ret.errno}): ${ret.errmsg}", Toast.LENGTH_LONG)
                    .show()
                return@myPost
            }

            ret.data?.let {
                AppPreferenceUtils.setUserToken(activity, it.token)

                /// 登陆成功
                LoginEvent.callback(activity) // 回调登陆成功
                Toast.makeText(activity, "登陆成功", Toast.LENGTH_LONG).show()

                fetchProfile(activity, { info ->
                    AppPreferenceUtils.setUserInfo(activity, info)
                }) {
                    Toast.makeText(activity, "获取用户信息失败", Toast.LENGTH_LONG).show()
                }

                activity.finish()
                return@myPost
            }

            Toast.makeText(activity, "认证失败: ${ret.errmsg}(${ret.errno})", Toast.LENGTH_LONG).show()
        }) {
            Toast.makeText(activity, "请求服务器失败: $it", Toast.LENGTH_LONG).show()
        }
    }


    /**
     * 获取用户的状态
     */
    fun fetchProfile(
        activity: Activity,
        success: (DtUserProfileDataModel) -> Unit,
        failure: () -> Unit
    ) {
        val form = DtUserTokenForm(token = AppPreferenceUtils.getUserToken(activity))
        ApiUserProfileStub.myPost(activity, form,
            { ret ->
                AppErrnoLogic.genericServerErrnoProcess(ret.errno, activity)
                Log.i("user/profile", "$ret")
                if (ret.errno != 0) {
                    TipUtils.toastShort(activity, "更新状态失败: ${ret.errmsg}")
                    failure()
                } else {
                    ret.data?.let { data ->
                        AppPreferenceUtils.setUserInfo(activity, data)
                        success(data)
                    }
                }
            },
            { error ->
                Log.e("user/profile", "错误信息: ${error.localizedMessage}")
                TipUtils.toastShort(activity, "更新用户状态失败: ${error.localizedMessage}")
                failure()
            })

    }


    /**
     * 用户退出登陆
     */
    fun logout(activity: Context) {
        // 删除 token
        AppPreferenceUtils.setUserToken(activity, "")
        // 删除已经登陆的用户信息
        AppPreferenceUtils.delUserInfo(activity)

        /// 登出之后的事件
        LogoutEvent.callback(activity)
    }

    /**
     * 用户注销账号
     */
    fun cancel(ctx: SettingsActivity) {
        val form = DtUserTokenForm(token = AppPreferenceUtils.getUserToken(ctx))

        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.UserCancel, form,
            { ret: DtUserCancelResponseModel ->
                AppErrnoLogic.genericServerErrnoProcess(ret.errno, ctx)

                if (ret.errno == 0 && ret.data == true) {
                    Toast.makeText(ctx, "注销用户成功", Toast.LENGTH_LONG).show()
                    // 注销成功 自动退出登陆
                    logout(ctx)
                    ctx.setNotLoginView()
                } else {
                    Toast.makeText(ctx, "注销用户失败(${ret.errno}): ${ret.errmsg}", Toast.LENGTH_LONG)
                        .show()
                }
            },
            {
                Toast.makeText(ctx, "请求服务器失败: $it", Toast.LENGTH_LONG).show()
            })

        MyHttpUtils.addToQueue(ctx, LogTags.User, r)
    }
}
