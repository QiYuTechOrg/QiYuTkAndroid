// 这个文件由 openapi.json 自动生成
// 请不要手工编辑

package com.qiyutech.tbk.dt

import android.content.Context
import android.net.Uri
import com.android.volley.VolleyError
import com.qiyutech.tbk.utils.MyHttpUtils
import com.qiyutech.tbk.values.TbkAPIUrls


object ApiDtkFastBuyStub {
    /**
     * 快抢商品
     * [大淘客咚咚抢文档](https://www.dataoke.com/pmc/api-d.html?id=23)
     */
    fun myPost(
        ctx: Context,
        form: DtCategoryDdqGoodsListArgs,
        success: (DtGenericItemListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkFastBuy,
            form,
            { data: DtGenericItemListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkFastBuyStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkFastBuyStub")
    }
}


object ApiDtkGoodsDetailStub {
    /**
     * 单品详情
     *
     */
    fun myPost(
        ctx: Context,
        form: DtGoodsGetGoodsDetailsArgs,
        success: (DtDtkGoodsDetailResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkGoodsDetail,
            form,
            { data: DtDtkGoodsDetailResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkGoodsDetailStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkGoodsDetailStub")
    }
}


object ApiDtkGoodsListStub {
    /**
     * 商品列表
     * 实际接口: https://www.dataoke.com/pmc/api-d.html?id=5
     */
    fun myPost(
        ctx: Context,
        form: DtGoodsGetGoodsListArgs,
        success: (DtGenericItemListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkGoodsList,
            form,
            { data: DtGenericItemListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkGoodsListStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkGoodsListStub")
    }
}


object ApiDtkGoodsNineOpGoodsListStub {
    /**
     * 9.9包邮
     * 9.9包邮精选  文档: http://www.dataoke.com/pmc/api-d.html?id=15
     */
    fun myPost(
        ctx: Context,
        form: DtGoodsNineOpGoodsListArgs,
        success: (DtGenericItemListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkGoodsNineOpGoodsList,
            form,
            { data: DtGenericItemListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkGoodsNineOpGoodsListStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkGoodsNineOpGoodsListStub")
    }
}


object ApiDtkGoodsPriceTrendStub {
    /**
     * 商品历史券后价
     *
     */
    fun myPost(
        ctx: Context,
        form: DtGoodsPriceTrendArgs,
        success: (DtDtkGoodsPriceTrendResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkGoodsPriceTrend,
            form,
            { data: DtDtkGoodsPriceTrendResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkGoodsPriceTrendStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkGoodsPriceTrendStub")
    }
}


object ApiDtkGuessYouLikeStub {
    /**
     * 猜你喜欢
     * [每日爆品推荐](https://www.dataoke.com/pmc/api-d.html?id=34)
     */
    fun myPost(
        ctx: Context,
        form: DtGoodsExplosiveGoodsListArgs,
        success: (DtGenericItemListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkGuessYouLike,
            form,
            { data: DtGenericItemListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkGuessYouLikeStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkGuessYouLikeStub")
    }
}


object ApiDtkPrivilegeLinkStub {
    /**
     * 高效转链
     *
     */
    fun myPost(
        ctx: Context,
        form: DtTbServiceGetPrivilegeLinkArgs,
        success: (DtDtkPrivilegeLinkResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkPrivilegeLink,
            form,
            { data: DtDtkPrivilegeLinkResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkPrivilegeLinkStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkPrivilegeLinkStub")
    }
}


object ApiDtkRankingListStub {
    /**
     * 各大榜单
     * [大淘客各大榜单接口](https://www.dataoke.com/pmc/api-d.html?id=6)
     */
    fun myPost(
        ctx: Context,
        form: DtGoodsGetRankingListArgs,
        success: (DtGenericItemListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkRankingList,
            form,
            { data: DtGenericItemListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkRankingListStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkRankingListStub")
    }
}


object ApiDtkSearchGoodsStub {
    /**
     * 大淘客搜索
     *
     */
    fun myPost(
        ctx: Context,
        form: DtGoodsGetDtkSearchGoodsArgs,
        success: (DtGenericItemListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkSearchGoods,
            form,
            { data: DtGenericItemListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkSearchGoodsStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkSearchGoodsStub")
    }
}


object ApiDtkSearchSuggestionStub {
    /**
     * 搜索联想词
     * [搜索联想词文档](https://www.dataoke.com/pmc/api-d.html?id=18)
     */
    fun myPost(
        ctx: Context,
        form: DtGoodsSearchSuggestionArgs,
        success: (DtDtkSearchSuggestionResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkSearchSuggestion,
            form,
            { data: DtDtkSearchSuggestionResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkSearchSuggestionStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkSearchSuggestionStub")
    }
}


object ApiDtkSuperCategoryStub {
    /**
     * 超级分类
     * [大淘客超级分类文档](https://www.dataoke.com/pmc/api-d.html?id=10)
     */
    fun myGet(
        ctx: Context,

        success: (DtDtkSuperCategoryResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val uri = Uri.parse(TbkAPIUrls.DtkSuperCategory).buildUpon()

        val url = uri.build().toString()

        val r = MyHttpUtils.getRequest(
            url,
            { data: DtDtkSuperCategoryResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkSuperCategoryStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkSuperCategoryStub")
    }
}


object ApiDtkSuperSearchStub {
    /**
     * 超级搜索
     * [大淘客超级搜索](https://www.dataoke.com/pmc/api-d.html?id=14)
     */
    fun myPost(
        ctx: Context,
        form: DtGoodsListSuperGoodsArgs,
        success: (DtGenericItemListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkSuperSearch,
            form,
            { data: DtGenericItemListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkSuperSearchStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkSuperSearchStub")
    }
}


object ApiDtkBrandListStub {
    /**
     * 超值大牌
     * [大淘客品牌库文档](https://www.dataoke.com/pmc/api-d.html?id=17)
     */
    fun myPost(
        ctx: Context,
        form: DtTbServiceGetBrandListArgs,
        success: (DtDtkBrandListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkBrandList,
            form,
            { data: DtDtkBrandListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkBrandListStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkBrandListStub")
    }
}


object ApiDtkTbServiceStub {
    /**
     * 联盟搜索
     *
     */
    fun myPost(
        ctx: Context,
        form: DtTbServiceGetTbServiceArgs,
        success: (DtDtkTbServiceResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.DtkTbService,
            form,
            { data: DtDtkTbServiceResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkTbServiceStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkTbServiceStub")
    }
}


object ApiDtkTop100Stub {
    /**
     * 热搜记录
     *
     */
    fun myGet(
        ctx: Context,

        success: (DtDtkTop100ResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val uri = Uri.parse(TbkAPIUrls.DtkTop100).buildUpon()

        val url = uri.build().toString()

        val r = MyHttpUtils.getRequest(
            url,
            { data: DtDtkTop100ResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiDtkTop100Stub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiDtkTop100Stub")
    }
}


object ApiOrderListStub {
    /**
     * 获取订单列表
     * 获取用户的淘宝客订单
     */
    fun myPost(
        ctx: Context,
        form: DtOrderListForm,
        success: (DtOrderListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.OrderList,
            form,
            { data: DtOrderListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiOrderListStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiOrderListStub")
    }
}


object ApiShareAndroidRelationTklStub {
    /**
     * Android 使用淘口令分享商品
     * 用户通过淘口令分享指定的商品
    注意: 这个用户必须绑定渠道ID
     */
    fun myPost(
        ctx: Context,
        form: DtShareItemTklForm,
        success: (DtShareItemTklResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ShareAndroidRelationTkl,
            form,
            { data: DtShareItemTklResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiShareAndroidRelationTklStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiShareAndroidRelationTklStub")
    }
}


object ApiShareIosRelationTklStub {
    /**
     * iOS 使用淘口令分享商品
     * 用户通过淘口令分享指定的商品
    注意: 这个用户必须绑定渠道ID
     */
    fun myPost(
        ctx: Context,
        form: DtShareItemTklForm,
        success: (DtShareItemTklResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ShareIosRelationTkl,
            form,
            { data: DtShareItemTklResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiShareIosRelationTklStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiShareIosRelationTklStub")
    }
}


object ApiShareIosNoRelationTklStub {
    /**
     * iOS 使用淘口令分享商品
     * 用户通过淘口令分享指定的商品
    注意: 这个用户可以没有绑定渠道ID
     */
    fun myPost(
        ctx: Context,
        form: DtShareItemTklForm,
        success: (DtShareItemTklResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ShareIosNoRelationTkl,
            form,
            { data: DtShareItemTklResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiShareIosNoRelationTklStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiShareIosNoRelationTklStub")
    }
}


object ApiSysConfigStub {
    /**
     * 系统配置
     * 返回系统的配置
     */
    fun myGet(
        ctx: Context,

        success: (DtSysConfigResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val uri = Uri.parse(TbkAPIUrls.SysConfig).buildUpon()

        val url = uri.build().toString()

        val r = MyHttpUtils.getRequest(
            url,
            { data: DtSysConfigResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiSysConfigStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiSysConfigStub")
    }
}


object ApiTaobaoAuthUrlStub {
    /**
     * 渠道ID绑定配置
     * 返回绑定的渠道 ID URL, 授权直接用 showUrlPage 打开页面即可
     */
    fun myPost(
        ctx: Context,
        form: DtAuthUrlForm,
        success: (DtTaoBaoAuthUrlResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.TaobaoAuthUrl,
            form,
            { data: DtTaoBaoAuthUrlResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiTaobaoAuthUrlStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiTaobaoAuthUrlStub")
    }
}


object ApiTbkDtkBrandGoodsStub {
    /**
     * 大淘客品牌商品列表
     * 获取淘宝客的单品详情
     */
    fun myPost(
        ctx: Context,
        form: DtTbkBrandGoodsForm,
        success: (DtGenericItemListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.TbkDtkBrandGoods,
            form,
            { data: DtGenericItemListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiTbkDtkBrandGoodsStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiTbkDtkBrandGoodsStub")
    }
}


object ApiTbkDtkBrandListStub {
    /**
     * 大淘客品牌列表
     * 获取淘宝客的单品详情
     */
    fun myPost(
        ctx: Context,
        form: DtTbkBrandListForm,
        success: (DtTbkBrandListResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.TbkDtkBrandList,
            form,
            { data: DtTbkBrandListResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiTbkDtkBrandListStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiTbkDtkBrandListStub")
    }
}


object ApiTbkItemDetailStub {
    /**
     * 单品详情
     * 获取淘宝客的单品详情
     */
    fun myPost(
        ctx: Context,
        form: DtTbkItemDetailForm,
        success: (DtTbkGoodsDetailResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.TbkItemDetail,
            form,
            { data: DtTbkGoodsDetailResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiTbkItemDetailStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiTbkItemDetailStub")
    }
}


object ApiUserAuthStub {
    /**
     * 用户认证息
     * 用户登录
     */
    fun myPost(
        ctx: Context,
        form: DtUserNativeAuthForm,
        success: (DtUserAuthResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.UserAuth,
            form,
            { data: DtUserAuthResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiUserAuthStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiUserAuthStub")
    }
}


object ApiUserCancelStub {
    /**
     * 用户注销
     * 注销自己的用户
     */
    fun myPost(
        ctx: Context,
        form: DtUserTokenForm,
        success: (DtUserCancelResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.UserCancel,
            form,
            { data: DtUserCancelResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiUserCancelStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiUserCancelStub")
    }
}


object ApiUserBindStub {
    /**
     * iOS用户绑定淘宝渠道ID
     * 给指定的用户绑定渠道 ID 信息
     */
    fun myPost(
        ctx: Context,
        form: DtTbBindForm,
        success: (DtTbBindResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.UserBind,
            form,
            { data: DtTbBindResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiUserBindStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiUserBindStub")
    }
}


object ApiUserProfileStub {
    /**
     * 用户信息
     * 获取用户自己的信息
     */
    fun myPost(
        ctx: Context,
        form: DtUserTokenForm,
        success: (DtUserProfileResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.UserProfile,
            form,
            { data: DtUserProfileResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiUserProfileStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiUserProfileStub")
    }
}


object ApiUserTbStub {
    /**
     * 用户是否已经进行淘宝认证
     * 用户是否已经进行淘宝认证
     */
    fun myPost(
        ctx: Context,
        form: DtUserTokenForm,
        success: (DtUserTbResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.UserTb,
            form,
            { data: DtUserTbResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiUserTbStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiUserTbStub")
    }
}


object ApiZtkBangDanTuiJianStub {
    /**
     * 榜单推荐
     *
     */
    fun myPost(
        ctx: Context,
        form: DtBangDanTuiJianForm,
        success: (DtBangDanTuiJianResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ZtkBangDanTuiJian,
            form,
            { data: DtBangDanTuiJianResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkBangDanTuiJianStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkBangDanTuiJianStub")
    }
}


object ApiZtkGuessYouLikeStub {
    /**
     * 猜你喜欢
     * 使用折淘客 猜你喜欢接口
     */
    fun myPost(
        ctx: Context,
        form: DtGuessYouLikeForm,
        success: (DtGuessYouLikeResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ZtkGuessYouLike,
            form,
            { data: DtGuessYouLikeResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkGuessYouLikeStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkGuessYouLikeStub")
    }
}


object ApiZtkItemV2Stub {
    /**
     * 商品详情
     * 获取指定商品的详情
    注意: 当前仅仅支持淘宝的商品
     */
    fun myGet(
        ctx: Context,
        item_id: String,
        success: (DtItemV2ResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val uri = Uri.parse(TbkAPIUrls.ZtkItemV2).buildUpon()
        uri.appendQueryParameter("item_id", item_id.toString())
        val url = uri.build().toString()

        val r = MyHttpUtils.getRequest(
            url,
            { data: DtItemV2ResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkItemV2Stub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkItemV2Stub")
    }
}


object ApiZtkJuHuaSuanStub {
    /**
     * 聚划算
     *
     */
    fun myPost(
        ctx: Context,
        form: DtJuHuaSuanForm,
        success: (DtJuHuanSuanResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ZtkJuHuaSuan,
            form,
            { data: DtJuHuanSuanResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkJuHuaSuanStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkJuHuaSuanStub")
    }
}


object ApiZtkNineNineStub {
    /**
     * 9.9 包邮购
     *
     */
    fun myPost(
        ctx: Context,
        form: DtNineNineForm,
        success: (DtNineNineResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ZtkNineNine,
            form,
            { data: DtNineNineResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkNineNineStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkNineNineStub")
    }
}


object ApiZtkSuggestStub {
    /**
     * 关键词推荐
     *
     */
    fun myGet(
        ctx: Context,
        content: String,
        success: (DtSuggestResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val uri = Uri.parse(TbkAPIUrls.ZtkSuggest).buildUpon()
        uri.appendQueryParameter("content", content.toString())
        val url = uri.build().toString()

        val r = MyHttpUtils.getRequest(
            url,
            { data: DtSuggestResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkSuggestStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkSuggestStub")
    }
}


object ApiZtkTmallChaoShiStub {
    /**
     * 天猫超市
     *
     */
    fun myPost(
        ctx: Context,
        form: DtTMallChaoShiForm,
        success: (DtTMallChaoShiResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ZtkTmallChaoShi,
            form,
            { data: DtTMallChaoShiResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkTmallChaoShiStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkTmallChaoShiStub")
    }
}


object ApiZtkTmallShangPinStub {
    /**
     * 天猫商品
     *
     */
    fun myPost(
        ctx: Context,
        form: DtTMallShangPinForm,
        success: (DtTMallShangPinResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ZtkTmallShangPin,
            form,
            { data: DtTMallShangPinResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkTmallShangPinStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkTmallShangPinStub")
    }
}


object ApiZtkGaoYongStub {
    /**
     * 高佣转链
     *
     */
    fun myPost(
        ctx: Context,
        form: DtGaoYongForm,
        success: (DtGaoYongResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ZtkGaoYong,
            form,
            { data: DtGaoYongResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkGaoYongStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkGaoYongStub")
    }
}


object ApiZtkKeywordStub {
    /**
     * 关键词推荐
     *
     */
    fun myGet(
        ctx: Context,

        success: (DtKeywordResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val uri = Uri.parse(TbkAPIUrls.ZtkKeyword).buildUpon()

        val url = uri.build().toString()

        val r = MyHttpUtils.getRequest(
            url,
            { data: DtKeywordResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkKeywordStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkKeywordStub")
    }
}


object ApiZtkSearchStub {
    /**
     * 全网商品搜索
     *
     */
    fun myPost(
        ctx: Context,
        form: DtSearchForm,
        success: (DtSearchResponseModel) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val r = MyHttpUtils.postRequest(
            TbkAPIUrls.ZtkSearch,
            form,
            { data: DtSearchResponseModel ->
                success(data)
            },
            {
                failure(it)
            })

        MyHttpUtils.addToQueue(ctx, "ApiZtkSearchStub", r)
    }

    fun cancel(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, "ApiZtkSearchStub")
    }
}



