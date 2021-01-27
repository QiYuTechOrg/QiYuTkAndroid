package com.qiyutech.tbk.logic

import android.app.Activity
import android.content.Context
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.alibaba.baichuan.android.trade.AlibcTrade
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback
import com.alibaba.baichuan.android.trade.model.AlibcShowParams
import com.alibaba.baichuan.android.trade.model.OpenType
import com.alibaba.baichuan.trade.biz.context.AlibcResultType
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams
import com.qiyutech.tbk.BuildConfig
import com.qiyutech.tbk.TaoBaoActivity
import com.qiyutech.tbk.dt.*
import com.qiyutech.tbk.utils.TipUtils
import com.qiyutech.tbk.values.AppPreferenceUtils
import com.qiyutech.tbk.values.LogTags

/**
 * 淘宝的逻辑
 */
class TaoBaoLogic(private val activity: Activity) {
    /**
     * 尝试淘宝授权
     */
    fun tryAuth() {
        val form = DtAuthUrlForm(token = AppPreferenceUtils.getUserToken(activity))

        ApiTaobaoAuthUrlStub.myPost(activity, form,
            { resp ->
                AppErrnoLogic.genericServerErrnoProcess(resp.errno, activity)
                if (resp.errno == 0) {
                    resp.data?.let {
                        Log.i(LogTags.TaoBao, it.url)
                        openAliBCAuthPage(it.url)
                    }
                } else {
                    Log.e(LogTags.TaoBao, resp.errmsg)
                }
            },
            { error ->
                TipUtils.toastShort(activity, "获取授权地址失败: ${error.localizedMessage}")
            })
    }

    /**
     * 打开 阿里百川授权页面
     * showPageByUrl
     */
    private fun openAliBCAuthPage(url: String) {

        TaoBaoActivity.openAuthPage(activity, url)

    }

    /**
     * 购买一个商品
     *  拉起淘宝去购买
     */
    fun buyItem(itemId: String) {
        val token = AppPreferenceUtils.getUserToken(activity)
        if (token == "") {
            TipUtils.toastLong(activity, "请登陆后购买 [我的-登陆]")
            return
        }
        val bind = AppPreferenceUtils.getBindTaoBao(activity)
        if (!bind) {
            TipUtils.toastLong(activity, "请先进行淘宝授权 [我的-淘宝授权]")
            return
        }

        val form = DtGaoYongForm(item_id = itemId, token = token)
        ApiZtkGaoYongStub.myPost(activity, form,
            { ret ->
                AppErrnoLogic.genericServerErrnoProcess(ret.errno, activity)
                if (ret.errno == 0) {
                    ret.data?.let { data ->
                        openByUrl(data.coupon_click_url)
                    }
                } else {
                    Log.e(LogTags.AliBuy, "请求服务器失败: ${ret.errmsg}")
                    TipUtils.toastLong(activity, "请求服务器失败，请稍后再试 ~_~!")
                }
            }, {
                Log.e(LogTags.AliBuy, "请求失败: ${it.localizedMessage}")
            })
    }


    /**
     * 打开商品信息
     */
    private fun openByUrl(url: String) {
        val show = AlibcShowParams()

        show.openType = OpenType.Auto
        show.clientType = "taobao"

        val taoke = AlibcTaokeParams("", "", "")

        taoke.setPid(BuildConfig.ALI_PID)
        // taoke.setUnionId("")
        taoke.setAdzoneid(BuildConfig.ALI_ADZONE_ID)

        AlibcTrade.openByUrl(activity,
            "",
            url,
            null,
            WebViewClient(),
            WebChromeClient(),
            show,
            taoke,
            null,
            object : AlibcTradeCallback {
                override fun onTradeSuccess(p0: AlibcTradeResult?) {
                    if (p0 == null) {
                        return
                    }

                    Log.i(LogTags.AliBuy, "购买成功")
                    when (p0.resultType) {
                        AlibcResultType.TYPECART -> {
                        }
                        AlibcResultType.TYPEPAY -> {
                        }
                        else -> {
                        }
                    }
                }

                override fun onFailure(p0: Int, p1: String?) {
                    Log.e(LogTags.AliBuy, "错误码: $p0")
                    Log.e(LogTags.AliBuy, "错误信息: $p1")
                }
            })
    }

    companion object {
        /**
         * 检测淘宝是否已经绑定
         */
        fun detectTaoBaoBind(ctx: Context) {
            val form = DtUserTokenForm(token = AppPreferenceUtils.getUserToken(ctx))

            ApiUserTbStub.myPost(ctx, form, { ret ->
                AppErrnoLogic.genericServerErrnoProcess(ret.errno, ctx)
                if (ret.errno != 0) {
                    Log.e(LogTags.AliBC, "授权失败!")
                    return@myPost
                }

                if (ret.data == true) { // 已经经过淘宝认证
                    val form2 = DtUserTokenForm(token = AppPreferenceUtils.getUserToken(ctx))
                    ApiUserProfileStub.myPost(
                        ctx, form2,
                        { ret2 ->
                            ret2.data?.let { data ->
                                AppPreferenceUtils.setUserInfo(ctx, data)
                            }
                            Log.i("user/profile", "$ret")
                        },
                        { error ->
                            Log.e("user/profile", "错误信息: ${error.localizedMessage}")
                            TipUtils.toastShort(ctx, "更新用户状态失败: ${error.localizedMessage}")
                        })
                }
            }, {
                Log.e(LogTags.AliBC, "请求获取淘宝认证失败: $it")
            })
        }
    }
}
