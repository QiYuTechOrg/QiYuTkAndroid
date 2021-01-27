package com.qiyutech.tbk.values

import android.content.Context
import com.google.gson.Gson
import com.qiyutech.tbk.dt.DtUserProfileDataModel
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.utils.MyJsonUtils

object AppSharedPreferencesName {
    const val NAME = "TBKSharedPreference"
}

/**
 * Android Shared Preference keys
 */
object AppSpKeys {
    /// 跟设备管理的 UUID
    const val TBK_UUID = "TBK-uuid"

    /// 用户信息
    const val USER_INFO_BIG_KEY = "user-info-key"

    /// 搜索历史
    const val SEARCH_HISTORY = "search-history"

    /// 获取用户的 token
    const val USER_TOKEN = "user-token"

    /// 用户是否已经同意 隐私政策
    const val PRIVACY_AGREE = "privacy-agree"
}

object AppPreferenceUtils {


    /**
     * 设置 tao ID
     */
    fun setTaoId(ctx: Context, taoId: String) {
        getUserInfo(ctx)?.let {
            val newData = DtUserProfileDataModel(
                mobile = it.mobile,
                tao_id = taoId,
                wx = it.wx,
                relation_id = it.relation_id,
                ali_name = it.ali_name,
                ali_account = it.ali_account
            )
            setUserInfo(ctx, newData)
        }
    }

    /**
     * 获取 是否已经同意隐私政策
     */
    fun getPrivacyAgree(ctx: Context): Boolean {
        val sp = AppUtils.getPreference(ctx)
        return sp.getBoolean(AppSpKeys.PRIVACY_AGREE, false)
    }

    /**
     * 设置为已经同意隐私政策
     */
    fun setPrivacyAgree(ctx: Context) {
        val sp = AppUtils.getPreference(ctx)
        sp.edit().putBoolean(AppSpKeys.PRIVACY_AGREE, true).apply()
    }

    fun getSearchHistory(ctx: Context): Array<String> {
        val sp = AppUtils.getPreference(ctx)
        val history = sp.getString(AppSpKeys.SEARCH_HISTORY, "")
        if (history === "") {
            return arrayOf()
        }

        return try {
            Gson().fromJson(history, Array<String>::class.java)
        } catch (e: Exception) {
            arrayOf()
        }
    }

    /**
     * 设置 搜索历史
     */
    fun setSearchHistory(ctx: Context, history: List<String>) {
        val count = history.count()

        val newHistory = if (count > 10) {
            history.drop(count - 10)
        } else {
            history
        }
        // use set of to delete duplicated item
        val s = Gson().toJson(newHistory.toSet().toList())

        val sp = AppUtils.getPreference(ctx)

        sp.edit().putString(AppSpKeys.SEARCH_HISTORY, s).apply()
    }


    /**
     * 获取是否已经绑定淘宝账号
     */
    fun getBindTaoBao(ctx: Context): Boolean {
        getUserInfo(ctx)?.let {
            it.relation_id?.let { relation ->
                if (relation.isBlank()) {
                    return false
                }
                return true
            }
        }
        return false
    }


    fun setUserToken(ctx: Context, token: String) {
        setKeyValue(ctx, AppSpKeys.USER_TOKEN, token)
    }

    /**
     * 设置用户消息
     */
    fun setUserInfo(ctx: Context, info: DtUserProfileDataModel) {
        val s = MyJsonUtils.toString(info)
        AppUtils.getPreference(ctx)
            .edit()
            .putString(AppSpKeys.USER_INFO_BIG_KEY, s)
            .apply()
    }

    /**
     * 删除用户信息
     */
    fun delUserInfo(ctx: Context) {
        AppUtils.getPreference(ctx)
            .edit()
            .remove(AppSpKeys.USER_INFO_BIG_KEY)
            .apply()
    }

    fun getUserInfo(ctx: Context): DtUserProfileDataModel? {
        val s = AppUtils.getPreference(ctx).getString(AppSpKeys.USER_INFO_BIG_KEY, "")
        if (s.isNullOrBlank()) {
            return null
        }

        return MyJsonUtils.fromString(s, DtUserProfileDataModel::class.java)
    }

    fun getUserToken(ctx: Context): String {
        return getOrDefault(ctx, AppSpKeys.USER_TOKEN, "")
    }


    fun getUserUuid(ctx: Context): String {
        return ""
    }


    private fun getOrDefault(ctx: Context, key: String, default: String): String {
        val sp = AppUtils.getPreference(ctx)
        val ret = sp.getString(key, default)
        return if (ret.isNullOrBlank()) {
            ""
        } else {
            ret
        }
    }

    private fun setKeyValue(ctx: Context, key: String, value: String) {
        val sp = AppUtils.getPreference(ctx)
        sp.edit().putString(key, value).apply()
    }
}

