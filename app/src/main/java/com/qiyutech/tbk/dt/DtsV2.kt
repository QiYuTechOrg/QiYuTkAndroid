// 这个文件由 openapi.json 自动生成
// 请不要手工编辑

package com.qiyutech.tbk.dt

import org.json.JSONObject

typealias DtAppErrno = Int
typealias DtString = String
typealias DtOrderType = Int
typealias DtInteger = Int
typealias DtItemInfo = DtTbkItemInfo


data class DtZtkItemV2(val item_id: String /* 商品ID */)
data class DtZtkSuggest(val content: String /* 搜索关键词 */)

data class DtAuthUrlDataModel(
    val url: String /* 要绑定的 URL */
)

data class DtAuthUrlForm(
    val token: String /* 认证 TOKEN */
)

data class DtBangDanTuiJianForm(
    val page: Int? /* 分页 */,
    val page_size: Int? /* 每页数据条数 */,
    val sort: String? /* 商品排序方式 */,
    val cid: Int? /* 一级商品分类 */
)

data class DtBangDanTuiJianModel(
    val code: String /* 折淘客编号 */,
    val type_one_id: String /* 分类 id, 参见: cid */,
    val tao_id: String /* 淘宝的商品 id */,
    val title: String /* 商品的标题 */,
    val jianjie: String /* 商品的简介 */,
    val pict_url: String /* 商品的主图 */,
    val user_type: String /* 卖家类型 */,
    val seller_id: String /* 商家的 id */,
    val shop_dsr: String /* 店铺 dsr 评分 */,
    val volume: String /* 30天销量 */,
    val size: String /* 折扣价 */,
    val quanhou_jiage: String /* 券后价格 */,
    val date_time_yongjin: String /* 数据更新时间 */,
    val tkrate3: String /* 佣金比例 */,
    val yongjin_type: String /* 佣金类型 */,
    val coupon_id: String /* 优惠券ID */,
    val coupon_start_time: String /* 优惠券开始时间 */,
    val coupon_end_time: String /* 优惠券结束时间 */,
    val coupon_info_money: String /* 优惠券金额 */,
    val coupon_total_count: String /* 优惠券总量 */,
    val coupon_remain_count: String /* 优惠券剩余数量 */,
    val coupon_info: String /* 优惠券信息 */,
    val juhuasuan: String /* 是否为 聚划算 */,
    val taoqianggou: String /* 是否为 淘抢购 */,
    val haitao: String /* 是否为 海淘 */,
    val jiyoujia: String /* 是否极有家 */,
    val jinpaimaijia: String /* 是否为 金牌卖家 */,
    val pinpai: String /* 是否为 品牌 */,
    val pinpai_name: String /* 品牌名称 */,
    val yunfeixian: String /* ??? */,
    val nick: String /* 店铺名称 */,
    val small_images: String /* 商品组图/商品小图列表 */,
    val white_image: String /* 商品白底图 */,
    val tao_title: String /* 商品长标题 */,
    val provcity: String /* 省份 城市 */,
    val shop_title: String /* 商家名称 */,
    val zhibo_url: String /* 直播地址 */,
    val sellCount: String /* 销售数量 */,
    val commentCount: String /* 评论数量 */,
    val favcount: String /* 喜欢数量 */,
    val score1: String /* 宝贝描述分 */,
    val score2: String /* 卖家服务分 */,
    val score3: String /* 物流服务分 */,
    val creditLevel: String /* 店铺等级 */,
    val shopIcon: String /* 商家图标 URL */,
    val pcDescContent: String /* 内容 url */,
    val item_url: String /* 商品地址 */,
    val category_id: String /* 分类 id */,
    val category_name: String /* 分类名称 */,
    val level_one_category_id: String /* ??? */,
    val level_one_category_name: String /* ??? */,
    val volume_shishi: String /* 两小时销量 */,
    val volume_quantian: String /* 全天销量 */,
    val tk_sale_count: String /* 人气值 */,
    val tkfee3: String /* ??? */,
    val biaoqian: String /* 店铺活动 */,
    val tag: String /* 朋友圈文案 */
)

data class DtBangDanTuiJianResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtBangDanTuiJianModel>? /* 详细数据 */
)

data class DtCategoryDdqGoodsListArgs(
    val roundTime: String? /* 默认为当前场次，场次时间输入方式：yyyy-mm-dd hh:mm:ss */
)

data class DtCategoryGetSuperCategoryResp(
    val cid: DtInteger? /* Cid */,
    val cname: String? /* Cname */,
    val cpic: String? /* Cpic */,
    val subcategories: List<DtCategoryGetSuperCategoryRespSubcategories>? /* Subcategories */
)

data class DtCategoryGetSuperCategoryRespSubcategories(
    val subcid: Int? /* Subcid */,
    val subcname: String? /* Subcname */,
    val scpic: String? /* Scpic */
)

data class DtDtkBrandListResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtTbServiceGetBrandListResp>? /* 详细数据 */
)

data class DtDtkGoodsDetailResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: DtGoodsGetGoodsDetailsResp? /* 详细数据 */
)

data class DtDtkGoodsPriceTrendResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: DtGoodsPriceTrendResp? /* 详细数据 */
)

data class DtDtkPrivilegeLinkResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: DtTbServiceGetPrivilegeLinkResp? /* 详细数据 */
)

data class DtDtkSearchSuggestionResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<String>? /* 详细数据 */
)

data class DtDtkSuperCategoryResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtCategoryGetSuperCategoryResp>? /* 详细数据 */
)

data class DtDtkTbServiceResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtTbServiceGetTbServiceResp>? /* 详细数据 */
)

data class DtDtkTop100ResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<String>? /* 详细数据 */
)

data class DtGaoYongForm(
    val item_id: String /* 淘宝的商品 id */, val token: String /* 认证 TOKEN */
)

data class DtGaoYongModel(
    val code: String /* 折淘客编号 */,
    val type_one_id: String /* 分类 id, 参见: cid */,
    val tao_id: String /* 淘宝的商品 id */,
    val title: String /* 商品的标题 */,
    val jianjie: String /* 商品的简介 */,
    val pict_url: String /* 商品的主图 */,
    val user_type: String /* 卖家类型 */,
    val seller_id: String /* 商家的 id */,
    val shop_dsr: String /* 店铺 dsr 评分 */,
    val volume: String /* 30天销量 */,
    val size: String /* 折扣价 */,
    val quanhou_jiage: String /* 券后价格 */,
    val date_time_yongjin: String /* 数据更新时间 */,
    val tkrate3: String /* 佣金比例 */,
    val yongjin_type: String /* 佣金类型 */,
    val coupon_id: String /* 优惠券ID */,
    val coupon_start_time: String /* 优惠券开始时间 */,
    val coupon_end_time: String /* 优惠券结束时间 */,
    val coupon_info_money: String /* 优惠券金额 */,
    val coupon_total_count: String /* 优惠券总量 */,
    val coupon_remain_count: String /* 优惠券剩余数量 */,
    val coupon_info: String /* 优惠券信息 */,
    val juhuasuan: String /* 是否为 聚划算 */,
    val taoqianggou: String /* 是否为 淘抢购 */,
    val haitao: String /* 是否为 海淘 */,
    val jiyoujia: String /* 是否极有家 */,
    val jinpaimaijia: String /* 是否为 金牌卖家 */,
    val pinpai: String /* 是否为 品牌 */,
    val pinpai_name: String /* 品牌名称 */,
    val yunfeixian: String /* ??? */,
    val nick: String /* 店铺名称 */,
    val small_images: String /* 商品组图/商品小图列表 */,
    val white_image: String /* 商品白底图 */,
    val tao_title: String /* 商品长标题 */,
    val provcity: String /* 省份 城市 */,
    val shop_title: String /* 商家名称 */,
    val zhibo_url: String /* 直播地址 */,
    val sellCount: String /* 销售数量 */,
    val commentCount: String /* 评论数量 */,
    val favcount: String /* 喜欢数量 */,
    val score1: String /* 宝贝描述分 */,
    val score2: String /* 卖家服务分 */,
    val score3: String /* 物流服务分 */,
    val creditLevel: String /* 店铺等级 */,
    val shopIcon: String /* 商家图标 URL */,
    val pcDescContent: String /* 内容 url */,
    val taobao_url: String /* 商品URL */,
    val category_id: String /* 分类 id */,
    val category_name: String /* 分类名称 */,
    val level_one_category_id: String /* ??? */,
    val level_one_category_name: String /* ??? */,
    val tkfee3: String /* ??? */,
    val biaoqian: String /* 店铺活动 */,
    val tag: String /* 朋友圈文案 */,
    val date_time: String /* 数据添加时间 */,
    val presale_discount_fee_text: String? /* 预售商品-商品优惠信息 */,
    val presale_tail_end_time: String? /* 预售商品-付定金结束时间（毫秒） */,
    val presale_tail_start_time: String? /* 预售商品-付尾款开始时间（毫秒） */,
    val presale_end_time: String? /* 预售结束时间 */,
    val presale_start_time: String? /* 预售开始时间 */,
    val presale_deposit: String? /* 预售 ??? */,
    val min_commission_rate: String /* Min Commission Rate */,
    val coupon_click_url: String /* 二合一推广链接，已经自动拼接S券 */,
    val item_url: String /* 商品地址 */,
    val shorturl: String /* 淘宝短链接 */,
    val tkl: String /* 淘口令 */
)

data class DtGaoYongResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: DtGaoYongModel? /* 详细数据 */
)

data class DtGenericItemListResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtTbkItemInfo>? /* 详细数据 */
)

data class DtGoodsExplosiveGoodsListArgs(
    val pageId: String /* 分页id：常规分页方式，请直接传入对应页码（比如：1,2,3……） */,
    val pageSize: String /* 每页返回条数，每页条数支持输入10,20，50,100。默认50条 */,
    val PriceCid: String? /* 价格区间，1表示10~20元区；2表示20~40元区；3表示40元以上区；默认为1 */,
    val cids: String? /* 大淘客的一级分类id，如果需要传多个，以英文逗号相隔，如：”1,2,3”。1 -女装，2 -母婴，3 -美妆，4 -居家日用，5 -鞋品，6 -美食，7 -文娱车品，8 -数码家电，9 -男装，10 -内衣，11 -箱包，12 -配饰，13 -户外运动，14 -家装家纺。不填默认全部 */
)

data class DtGoodsGetDtkSearchGoodsArgs(
    val pageId: String /* 分页id，默认为1，支持传统的页码分页方式和scroll_id分页方式，根据用户自身需求传入值。示例1：商品入库，则首次传入1，后续传入接口返回的pageid，接口将持续返回符合条件的完整商品列表，该方式可以避免入口商品重复；示例2：根据pagesize和totalNum计算出总页数，按照需求返回指定页的商品（该方式可能在临近页取到重复商品） */,
    val pageSize: String /* 每页条数，默认为100，最大值200，若小于10，则按10条处理，每页条数仅支持输入10,50,100,200 */,
    val keyWords: String /* 关键词搜索 */,
    val cids: String? /* 大淘客的一级分类id，如果需要传多个，以英文逗号相隔，如：”1,2,3”。当一级类目id和二级类目id同时传入时，会自动忽略二级类目id，一级分类id请求详情：1 -女装，2 -母婴，3 -美妆，4 -居家日用，5 -鞋品，6 -美食，7 -文娱车品，8 -数码家电，9 -男装，10 -内衣，11 -箱包，12 -配饰，13 -户外运动，14 -家装家纺 */,
    val subcid: String? /* 大淘客的二级类目id，通过超级分类API获取。仅允许传一个二级id，当一级类目id和二级类目id同时传入时，会自动忽略二级类目id */,
    val juHuaSuan: String? /* 是否聚划算，1-聚划算商品，0-所有商品，不填默认为0 */,
    val taoQiangGou: String? /* 是否淘抢购，1-淘抢购商品，0-所有商品，不填默认为0 */,
    val tmall: String? /* 是否天猫商品，1-天猫商品，0-非天猫商品，不填默认为所有商品 */,
    val tchaoshi: String? /* 是否天猫超市商品，1-天猫超市商品，0-所有商品，不填默认为0 */,
    val goldSeller: String? /* 是否金牌卖家，1-金牌卖家，0-所有商品，不填默认为0 */,
    val haitao: String? /* 是否海淘商品，1-海淘商品，0-所有商品，不填默认为0 */,
    val brand: String? /* 是否品牌商品，1-品牌商品，0-所有商品，不填默认为0 */,
    val brandIds: String? /* 品牌id，当brand传入0时，再传入brandIds将获取不到结果。品牌id可以传多个，以英文逗号隔开，如：”345,321,323” */,
    val priceLowerLimit: String? /* 价格（券后价）下限 */,
    val priceUpperLimit: String? /* 价格（券后价）上限 */,
    val commissionRateLowerLimit: String? /* 最低佣金比率 */,
    val sort: String? /* 排序字段，默认为0，0-综合排序，1-商品上架时间从新到旧，2-销量从高到低，3-领券量从高到低，4-佣金比例从高到低，5-价格（券后价）从高到低，6-价格（券后价）从低到高 */,
    val freeshipRemoteDistrict: String? /* 偏远地区包邮，1-是，0-非偏远地区，不填默认所有商品 */,
    val couponPriceLowerLimit: String? /* 最低优惠券面额 */,
    val monthSalesLowerLimit: String? /* 最低月销量 */
)

data class DtGoodsGetGoodsDetailsArgs(
    val id: String /* 大淘客商品id，请求时id或goodsId必填其中一个，若均填写，将优先查找当前单品id */,
    val goodsId: String? /* 淘宝商品id，id或goodsId必填其中一个，若均填写，将优先查找当前单品id */
)

data class DtGoodsGetGoodsDetailsResp(
    val id: DtInteger? /* Id */,
    val goodsId: String? /* Goodsid */,
    val title: String? /* Title */,
    val dtitle: String? /* Dtitle */,
    val originalPrice: Float? /* Originalprice */,
    val actualPrice: Float? /* Actualprice */,
    val shopType: DtInteger? /* Shoptype */,
    val goldSellers: DtInteger? /* Goldsellers */,
    val monthSales: DtInteger? /* Monthsales */,
    val twoHoursSales: DtInteger? /* Twohourssales */,
    val dailySales: DtInteger? /* Dailysales */,
    val commissionType: DtInteger? /* Commissiontype */,
    val desc: String? /* Desc */,
    val couponReceiveNum: DtInteger? /* Couponreceivenum */,
    val couponLink: String? /* Couponlink */,
    val couponEndTime: String? /* Couponendtime */,
    val couponStartTime: String? /* Couponstarttime */,
    val couponPrice: Float? /* Couponprice */,
    val couponConditions: String? /* Couponconditions */,
    val activityType: DtInteger? /* Activitytype */,
    val createTime: String? /* Createtime */,
    val mainPic: String? /* Mainpic */,
    val marketingMainPic: String? /* Marketingmainpic */,
    val sellerId: String? /* Sellerid */,
    val brandWenan: String? /* Brandwenan */,
    val cid: DtInteger? /* Cid */,
    val discounts: Float? /* Discounts */,
    val commissionRate: Float? /* Commissionrate */,
    val couponTotalNum: DtInteger? /* Coupontotalnum */,
    val haitao: DtInteger? /* Haitao */,
    val activityStartTime: String? /* Activitystarttime */,
    val activityEndTime: String? /* Activityendtime */,
    val shopName: String? /* Shopname */,
    val shopLevel: DtInteger? /* Shoplevel */,
    val descScore: Float? /* Descscore */,
    val brand: DtInteger? /* Brand */,
    val brandId: DtInteger? /* Brandid */,
    val brandName: String? /* Brandname */,
    val hotPush: DtInteger? /* Hotpush */,
    val teamName: String? /* Teamname */,
    val itemLink: String? /* Itemlink */,
    val tchaoshi: DtInteger? /* Tchaoshi */,
    val dsrScore: Float? /* Dsrscore */,
    val dsrPercent: Float? /* Dsrpercent */,
    val shipScore: Float? /* Shipscore */,
    val shipPercent: Float? /* Shippercent */,
    val serviceScore: Float? /* Servicescore */,
    val servicePercent: Float? /* Servicepercent */,
    val subcid: List<JSONObject>? /* Subcid */,
    val imgs: String? /* Imgs */,
    val reimgs: String? /* Reimgs */,
    val quanMLink: DtInteger? /* Quanmlink */,
    val hzQuanOver: DtInteger? /* Hzquanover */,
    val yunfeixian: DtInteger? /* Yunfeixian */,
    val estimateAmount: DtInteger? /* Estimateamount */,
    val shopLogo: String? /* Shoplogo */,
    val specialText: List<JSONObject>? /* Specialtext */,
    val freeshipRemoteDistrict: DtInteger? /* Freeshipremotedistrict */,
    val video: String? /* Video */,
    val detailPics: String? /* Detailpics */,
    val isSubdivision: DtInteger? /* Issubdivision */,
    val subdivisionId: DtInteger? /* Subdivisionid */,
    val subdivisionName: String? /* Subdivisionname */,
    val subdivisionRank: DtInteger? /* Subdivisionrank */,
    val tbcid: DtInteger? /* Tbcid */
)

data class DtGoodsGetGoodsListArgs(
    val pageId: String /* 默认为1，支持传统的页码分页方式和scroll_id分页方式，根据用户自身需求传入值。示例1：商品入库，则首次传入1，后续传入接口返回的pageid，接口将持续返回符合条件的完整商品列表，该方式可以避免入口商品重复；示例2：根据pagesize和totalNum计算出总页数，按照需求返回指定页的商品（该方式可能在临近页取到重复商品） */,
    val pageSize: String? /* 每页条数，默认为100，最大值200，若小于10，则按10条处理，每页条数仅支持输入10,50,100,200 */,
    val sort: String? /* 排序方式，默认为0，0-综合排序，1-商品上架时间从高到低，2-销量从高到低，3-领券量从高到低，4-佣金比例从高到低，5-价格（券后价）从高到低，6-价格（券后价）从低到高 */,
    val cids: String? /* 大淘客的一级分类id，如果需要传多个，以英文逗号相隔，如：”1,2,3”。当一级类目id和二级类目id同时传入时，会自动忽略二级类目id */,
    val subcid: String? /* 大淘客的二级类目id，通过超级分类API获取。仅允许传一个二级id，当一级类目id和二级类目id同时传入时，会自动忽略二级类目id */,
    val juHuaSuan: String? /* 1-聚划算商品，0-所有商品，不填默认为0 */,
    val taoQiangGou: String? /* 1-淘抢购商品，0-所有商品，不填默认为0 */,
    val tmall: String? /* 1-天猫商品， 0-非天猫商品，不填默认所有商品 */,
    val tchaoshi: String? /* 1-天猫超市商品， 0-所有商品，不填默认为0 */,
    val goldSeller: String? /* 1-金牌卖家商品，0-所有商品，不填默认为0 */,
    val haitao: String? /* 1-海淘商品， 0-所有商品，不填默认为0 */,
    val pre: String? /* 1-预告商品，0-所有商品，不填默认为0 */,
    val brand: String? /* 1-品牌商品，0-所有商品，不填默认为0 */,
    val brandIds: String? /* 当brand传入0时，再传入brandIds可能无法获取结果。品牌id可以传多个，以英文逗号隔开，如：”345,321,323” */,
    val priceLowerLimit: String? /* 价格（券后价）下限 */,
    val priceUpperLimit: String? /* 价格（券后价）上限 */,
    val commissionRateLowerLimit: String? /* 最低佣金比率 */,
    val monthSalesLowerLimit: String? /* 最低月销量 */,
    val specialId: String? /* 商品卖点，1.拍多件活动；2.多买多送；3.限量抢购；4.额外满减；6.买商品礼赠 */,
    val freeshipRemoteDistrict: String? /* 偏远地区包邮，1-是，0-非偏远地区，不填默认所有商品 */,
    val couponPriceLowerLimit: String? /* 最低优惠券面额 */,
    val preSale: String? /* 1-活动预售商品，0-所有商品，不填默认为0。*（10.30新增字段）* */
)

data class DtGoodsGetRankingListArgs(
    val rankType: String /* 榜单类型，1.实时榜 2.全天榜 3.热推榜 4.复购榜 5.热词飙升榜 6.热词排行榜 7.综合热搜榜 */,
    val cid: String? /* 大淘客一级类目id，仅对实时榜单、全天榜单有效 */,
    val pageSize: String? /* 每页条数返回条数（支持10,20.50，默认返回20条） */,
    val pageId: String? /* 分页id：常规分页方式，请直接传入对应页码（比如：1,2,3……）。*超过200条，分页返回为空* */
)

data class DtGoodsListSuperGoodsArgs(
    val pageId: String /* 请求的页码，默认参数1 */,
    val pageSize: String /* 每页条数，默认为20，最大值100 */,
    val keyWords: String /* 关键词搜索 */,
    val type: String /* 搜索类型：0-综合结果，1-大淘客商品，2-联盟商品 */,
    val tmall: String? /* 是否天猫商品：1-天猫商品，0-所有商品，不填默认为0 */,
    val haitao: String? /* 是否海淘商品：1-海淘商品，0-所有商品，不填默认为0 */,
    val sort: String? /* 排序字段信息 销量（total_sales） 价格（price），排序_des（降序），排序_asc（升序），示例：升序查询销量total_sales_asc */,
    val specialId: String? /* 会员运营id */,
    val channelId: String? /* 渠道id将会和传入的pid进行验证，验证通过将正常转链，请确认填入的渠道id是正确的*channelId对应联盟的relationId* */
)

data class DtGoodsNineOpGoodsListArgs(
    val pageId: String /* 分页id：常规分页方式，请直接传入对应页码（比如：1,2,3……） */,
    val pageSize: String /* 每页条数：默认为20，最大值100 */,
    val nineCid: String /* 9.9精选的类目id，分类id请求详情：*-1-精选，1 -5.9元区，2 -9.9元区，3 -19.9元区（调整字段）* */
)

data class DtGoodsPriceTrendArgs(
    val id: String /* 在大淘客的在线商品id（已下架的商品id不支持） */, val goodsId: String? /* 淘宝商品id */
)

data class DtGoodsPriceTrendResp(
    val id: DtInteger? /* Id */,
    val goodsId: String? /* Goodsid */,
    val title: String? /* Title */,
    val dtitle: String? /* Dtitle */,
    val originalPrice: Float? /* Originalprice */,
    val historicalPrice: List<DtGoodsPriceTrendRespHistoricalprice>? /* Historicalprice */,
    val monthSales: DtInteger? /* Monthsales */,
    val twoHoursSales: DtInteger? /* Twohourssales */,
    val dailySales: DtInteger? /* Dailysales */,
    val commissionType: DtInteger? /* Commissiontype */,
    val desc: String? /* Desc */,
    val couponReceiveNum: DtInteger? /* Couponreceivenum */,
    val couponEndTime: String? /* Couponendtime */,
    val couponStartTime: String? /* Couponstarttime */,
    val couponPrice: Float? /* Couponprice */,
    val couponConditions: String? /* Couponconditions */,
    val mainPic: String? /* Mainpic */,
    val marketingMainPic: String? /* Marketingmainpic */,
    val commissionRate: Float? /* Commissionrate */,
    val couponTotalNum: DtInteger? /* Coupontotalnum */,
    val brandId: DtInteger? /* Brandid */,
    val brandName: String? /* Brandname */,
    val itemLink: String? /* Itemlink */
)

data class DtGoodsPriceTrendRespHistoricalprice(
    val actualPrice: Float? /* Actualprice */, val date: String? /* Date */
)

data class DtGoodsSearchSuggestionArgs(
    val keyWords: String /* 关键词 */, val type: String /* 当前搜索API类型：1.大淘客搜索 2.联盟搜索 3.超级搜索 */
)

data class DtGuessYouLikeForm(
    val page: Int? /* 分页 */,
    val page_size: Int? /* 每页数据条数 */,
    val sort: String? /* 商品排序方式 */,
    val device_value: String? /* 设备号 */,
    val device_encrypt: String? /* 设备类型 */,
    val item_id: String? /* 商品ID */
)

data class DtGuessYouLikeModel(
    val code: String /* 折淘客编号 */,
    val type_one_id: String /* 分类 id, 参见: cid */,
    val tao_id: String /* 淘宝的商品 id */,
    val title: String /* 商品的标题 */,
    val jianjie: String /* 商品的简介 */,
    val pict_url: String /* 商品的主图 */,
    val user_type: String /* 卖家类型 */,
    val seller_id: String /* 商家的 id */,
    val shop_dsr: String /* 店铺 dsr 评分 */,
    val volume: String /* 30天销量 */,
    val size: String /* 折扣价 */,
    val quanhou_jiage: String /* 券后价格 */,
    val date_time_yongjin: String /* 数据更新时间 */,
    val tkrate3: String /* 佣金比例 */,
    val yongjin_type: String /* 佣金类型 */,
    val coupon_id: String /* 优惠券ID */,
    val coupon_start_time: String /* 优惠券开始时间 */,
    val coupon_end_time: String /* 优惠券结束时间 */,
    val coupon_info_money: String /* 优惠券金额 */,
    val coupon_total_count: String /* 优惠券总量 */,
    val coupon_remain_count: String /* 优惠券剩余数量 */,
    val coupon_info: String /* 优惠券信息 */,
    val juhuasuan: String /* 是否为 聚划算 */,
    val taoqianggou: String /* 是否为 淘抢购 */,
    val haitao: String /* 是否为 海淘 */,
    val jiyoujia: String /* 是否极有家 */,
    val jinpaimaijia: String /* 是否为 金牌卖家 */,
    val pinpai: String /* 是否为 品牌 */,
    val pinpai_name: String /* 品牌名称 */,
    val yunfeixian: String /* ??? */,
    val nick: String /* 店铺名称 */,
    val small_images: String /* 商品组图/商品小图列表 */,
    val white_image: String /* 商品白底图 */,
    val tao_title: String /* 商品长标题 */,
    val provcity: String /* 省份 城市 */,
    val shop_title: String /* 商家名称 */,
    val zhibo_url: String /* 直播地址 */,
    val sellCount: String /* 销售数量 */,
    val commentCount: String /* 评论数量 */,
    val favcount: String /* 喜欢数量 */,
    val score1: String /* 宝贝描述分 */,
    val score2: String /* 卖家服务分 */,
    val score3: String /* 物流服务分 */,
    val creditLevel: String /* 店铺等级 */,
    val shopIcon: String /* 商家图标 URL */,
    val pcDescContent: String /* 内容 url */,
    val item_url: String /* 商品地址 */,
    val category_id: String /* 分类 id */,
    val category_name: String /* 分类名称 */,
    val level_one_category_id: String /* ??? */,
    val level_one_category_name: String /* ??? */,
    val tkfee3: String /* ??? */
)

data class DtGuessYouLikeResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtGuessYouLikeModel>? /* 返回数据 */
)

data class DtHTTPValidationError(
    val detail: List<DtValidationError>? /* Detail */
)

data class DtItemDetailV2Model(
    val code: String /* 折淘客编号 */,
    val type_one_id: String /* 分类 id, 参见: cid */,
    val tao_id: String /* 淘宝的商品 id */,
    val title: String /* 商品的标题 */,
    val jianjie: String /* 商品的简介 */,
    val pict_url: String /* 商品的主图 */,
    val user_type: String /* 卖家类型 */,
    val seller_id: String /* 商家的 id */,
    val shop_dsr: String /* 店铺 dsr 评分 */,
    val volume: String /* 30天销量 */,
    val size: String /* 折扣价 */,
    val quanhou_jiage: String /* 券后价格 */,
    val date_time_yongjin: String /* 数据更新时间 */,
    val tkrate3: String /* 佣金比例 */,
    val yongjin_type: String /* 佣金类型 */,
    val coupon_id: String /* 优惠券ID */,
    val coupon_start_time: String /* 优惠券开始时间 */,
    val coupon_end_time: String /* 优惠券结束时间 */,
    val coupon_info_money: String /* 优惠券金额 */,
    val coupon_total_count: String /* 优惠券总量 */,
    val coupon_remain_count: String /* 优惠券剩余数量 */,
    val coupon_info: String /* 优惠券信息 */,
    val juhuasuan: String /* 是否为 聚划算 */,
    val taoqianggou: String /* 是否为 淘抢购 */,
    val haitao: String /* 是否为 海淘 */,
    val jiyoujia: String /* 是否极有家 */,
    val jinpaimaijia: String /* 是否为 金牌卖家 */,
    val pinpai: String /* 是否为 品牌 */,
    val pinpai_name: String /* 品牌名称 */,
    val yunfeixian: String /* ??? */,
    val nick: String /* 店铺名称 */,
    val small_images: String /* 商品组图/商品小图列表 */,
    val white_image: String /* 商品白底图 */,
    val tao_title: String /* 商品长标题 */,
    val provcity: String /* 省份 城市 */,
    val shop_title: String /* 商家名称 */,
    val zhibo_url: String /* 直播地址 */,
    val sellCount: String /* 销售数量 */,
    val commentCount: String /* 评论数量 */,
    val favcount: String /* 喜欢数量 */,
    val score1: String /* 宝贝描述分 */,
    val score2: String /* 卖家服务分 */,
    val score3: String /* 物流服务分 */,
    val creditLevel: String /* 店铺等级 */,
    val shopIcon: String /* 商家图标 URL */,
    val pcDescContent: String /* 内容 url */,
    val item_url: String /* 商品地址 */,
    val category_id: String /* 分类 id */,
    val category_name: String /* 分类名称 */,
    val level_one_category_id: String /* ??? */,
    val level_one_category_name: String /* ??? */,
    val tkfee3: String /* ??? */,
    val biaoqian: String /* 店铺活动 */,
    val tag: String /* 朋友圈文案 */,
    val date_time: String /* 数据添加时间 */,
    val presale_discount_fee_text: String? /* 预售商品-商品优惠信息 */,
    val presale_tail_end_time: String? /* 预售商品-付定金结束时间（毫秒） */,
    val presale_tail_start_time: String? /* 预售商品-付尾款开始时间（毫秒） */,
    val presale_end_time: String? /* 预售结束时间 */,
    val presale_start_time: String? /* 预售开始时间 */,
    val presale_deposit: String? /* 预售 ??? */,
    val min_commission_rate: String /* Min Commission Rate */
)

data class DtItemV2ResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtItemDetailV2Model>? /* 详细数据 */
)

data class DtJuHuaSuanForm(
    val page: Int? /* 分页 */,
    val page_size: Int? /* 每页数据条数 */,
    val sort: String? /* 商品排序方式 */,
    val cid: Int? /* 一级商品分类 */
)

data class DtJuHuaSuanModel(
    val code: String /* 折淘客编号 */,
    val type_one_id: String /* 分类 id, 参见: cid */,
    val tao_id: String /* 淘宝的商品 id */,
    val title: String /* 商品的标题 */,
    val jianjie: String /* 商品的简介 */,
    val pict_url: String /* 商品的主图 */,
    val user_type: String /* 卖家类型 */,
    val seller_id: String /* 商家的 id */,
    val shop_dsr: String /* 店铺 dsr 评分 */,
    val volume: String /* 30天销量 */,
    val size: String /* 折扣价 */,
    val quanhou_jiage: String /* 券后价格 */,
    val date_time_yongjin: String /* 数据更新时间 */,
    val tkrate3: String /* 佣金比例 */,
    val yongjin_type: String /* 佣金类型 */,
    val coupon_id: String /* 优惠券ID */,
    val coupon_start_time: String /* 优惠券开始时间 */,
    val coupon_end_time: String /* 优惠券结束时间 */,
    val coupon_info_money: String /* 优惠券金额 */,
    val coupon_total_count: String /* 优惠券总量 */,
    val coupon_remain_count: String /* 优惠券剩余数量 */,
    val coupon_info: String /* 优惠券信息 */,
    val juhuasuan: String /* 是否为 聚划算 */,
    val taoqianggou: String /* 是否为 淘抢购 */,
    val haitao: String /* 是否为 海淘 */,
    val jiyoujia: String /* 是否极有家 */,
    val jinpaimaijia: String /* 是否为 金牌卖家 */,
    val pinpai: String /* 是否为 品牌 */,
    val pinpai_name: String /* 品牌名称 */,
    val yunfeixian: String /* ??? */,
    val nick: String /* 店铺名称 */,
    val small_images: String /* 商品组图/商品小图列表 */,
    val white_image: String /* 商品白底图 */,
    val tao_title: String /* 商品长标题 */,
    val provcity: String /* 省份 城市 */,
    val shop_title: String /* 商家名称 */,
    val zhibo_url: String /* 直播地址 */,
    val sellCount: String /* 销售数量 */,
    val commentCount: String /* 评论数量 */,
    val favcount: String /* 喜欢数量 */,
    val score1: String /* 宝贝描述分 */,
    val score2: String /* 卖家服务分 */,
    val score3: String /* 物流服务分 */,
    val creditLevel: String /* 店铺等级 */,
    val shopIcon: String /* 商家图标 URL */,
    val pcDescContent: String /* 内容 url */,
    val item_url: String /* 商品地址 */,
    val category_id: String /* 分类 id */,
    val category_name: String /* 分类名称 */,
    val level_one_category_id: String /* ??? */,
    val level_one_category_name: String /* ??? */,
    val tkfee3: String /* ??? */,
    val biaoqian: String /* 店铺活动 */,
    val tag: String /* 朋友圈文案 */,
    val presale_discount_fee_text: String? /* 预售商品-商品优惠信息 */,
    val presale_tail_end_time: String? /* 预售商品-付定金结束时间（毫秒） */,
    val presale_tail_start_time: String? /* 预售商品-付尾款开始时间（毫秒） */,
    val presale_end_time: String? /* 预售结束时间 */,
    val presale_start_time: String? /* 预售开始时间 */,
    val presale_deposit: String? /* 预售 ??? */
)

data class DtJuHuanSuanResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtJuHuaSuanModel>? /* 具体信息 */
)

data class DtKeywordResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<String>? /* 热词/关键字 */
)

data class DtNineNineForm(
    val page: Int? /* 分页 */,
    val page_size: Int? /* 每页数据条数 */,
    val sort: String? /* 商品排序方式 */,
    val cid: Int? /* 一级商品分类 */,
    val price: String? /* 商品价格 */
)

data class DtNineNineModel(
    val code: String /* 折淘客编号 */,
    val type_one_id: String /* 分类 id, 参见: cid */,
    val tao_id: String /* 淘宝的商品 id */,
    val title: String /* 商品的标题 */,
    val jianjie: String /* 商品的简介 */,
    val pict_url: String /* 商品的主图 */,
    val user_type: String /* 卖家类型 */,
    val seller_id: String /* 商家的 id */,
    val shop_dsr: String /* 店铺 dsr 评分 */,
    val volume: String /* 30天销量 */,
    val size: String /* 折扣价 */,
    val quanhou_jiage: String /* 券后价格 */,
    val date_time_yongjin: String /* 数据更新时间 */,
    val tkrate3: String /* 佣金比例 */,
    val yongjin_type: String /* 佣金类型 */,
    val coupon_id: String /* 优惠券ID */,
    val coupon_start_time: String /* 优惠券开始时间 */,
    val coupon_end_time: String /* 优惠券结束时间 */,
    val coupon_info_money: String /* 优惠券金额 */,
    val coupon_total_count: String /* 优惠券总量 */,
    val coupon_remain_count: String /* 优惠券剩余数量 */,
    val coupon_info: String /* 优惠券信息 */,
    val juhuasuan: String /* 是否为 聚划算 */,
    val taoqianggou: String /* 是否为 淘抢购 */,
    val haitao: String /* 是否为 海淘 */,
    val jiyoujia: String /* 是否极有家 */,
    val jinpaimaijia: String /* 是否为 金牌卖家 */,
    val pinpai: String /* 是否为 品牌 */,
    val pinpai_name: String /* 品牌名称 */,
    val yunfeixian: String /* ??? */,
    val nick: String /* 店铺名称 */,
    val small_images: String /* 商品组图/商品小图列表 */,
    val white_image: String /* 商品白底图 */,
    val tao_title: String /* 商品长标题 */,
    val provcity: String /* 省份 城市 */,
    val shop_title: String /* 商家名称 */,
    val zhibo_url: String /* 直播地址 */,
    val sellCount: String /* 销售数量 */,
    val commentCount: String /* 评论数量 */,
    val favcount: String /* 喜欢数量 */,
    val score1: String /* 宝贝描述分 */,
    val score2: String /* 卖家服务分 */,
    val score3: String /* 物流服务分 */,
    val creditLevel: String /* 店铺等级 */,
    val shopIcon: String /* 商家图标 URL */,
    val pcDescContent: String /* 内容 url */,
    val item_url: String /* 商品地址 */,
    val category_id: String /* 分类 id */,
    val category_name: String /* 分类名称 */,
    val level_one_category_id: String /* ??? */,
    val level_one_category_name: String /* ??? */,
    val tkfee3: String /* ??? */,
    val biaoqian: String /* 店铺活动 */,
    val tag: String /* 朋友圈文案 */,
    val presale_discount_fee_text: String? /* 预售商品-商品优惠信息 */,
    val presale_tail_end_time: String? /* 预售商品-付定金结束时间（毫秒） */,
    val presale_tail_start_time: String? /* 预售商品-付尾款开始时间（毫秒） */,
    val presale_end_time: String? /* 预售结束时间 */,
    val presale_start_time: String? /* 预售开始时间 */,
    val presale_deposit: String? /* 预售 ??? */
)

data class DtNineNineResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtNineNineModel>? /* 具体数据 */
)

data class DtOrderListDataModel(
    val order_platform: String /* 订单平台 */,
    val order_no: String /* 订单号 */,
    val order_parent_no: String /* 订单组号 */,
    val order_num: Int? /* 购买数量 */,
    val order_ctime: String /* 订单创建时间 */,
    val order_status: String /* 订单状态 */,
    val pay_price: Float /* 付款价格 */,
    val pay_time: String /* 支付时间 */,
    val end_time: String /* 结束时间 */,
    val item_id: String /* 商品ID */,
    val item_title: String /* 商品名称 */,
    val item_pic: String /* 商品主图 */,
    val item_price: Float /* 商品价格 */,
    val item_category: String /* 商品分类 */,
    val shop_title: String /* 商家名称 */,
    val income: Float /* 收入 */,
    val score: Int? /* 积分 */,
    val status: String /* 状态 */,
    val ctime: String /* 创建时间 */,
    val mtime: String /* 最近修改时间 */
)

data class DtOrderListForm(
    val token: String /* 认证 TOKEN */, val page: Int? /* 分页 */, val typ: DtOrderType /* 订单类型 */
)

data class DtOrderListResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtOrderListDataModel>? /* 详细数据 */
)

data class DtSearchForm(
    val q: String /* 商品标题 */,
    val page: Int? /* 分页 */,
    val page_size: Int? /* 每页数据条数 */,
    val sort: String? /* 商品排序方式 */,
    val youquan: Int? /* 是否有券 */
)

data class DtSearchModel(
    val code: String /* 折淘客编号 */,
    val type_one_id: String /* 分类 id, 参见: cid */,
    val tao_id: String /* 淘宝的商品 id */,
    val title: String /* 商品的标题 */,
    val jianjie: String /* 商品的简介 */,
    val pict_url: String /* 商品的主图 */,
    val user_type: String /* 卖家类型 */,
    val seller_id: String /* 商家的 id */,
    val shop_dsr: String /* 店铺 dsr 评分 */,
    val volume: String /* 30天销量 */,
    val size: String /* 折扣价 */,
    val quanhou_jiage: String /* 券后价格 */,
    val date_time_yongjin: String /* 数据更新时间 */,
    val tkrate3: String /* 佣金比例 */,
    val yongjin_type: String /* 佣金类型 */,
    val coupon_id: String /* 优惠券ID */,
    val coupon_start_time: String /* 优惠券开始时间 */,
    val coupon_end_time: String /* 优惠券结束时间 */,
    val coupon_info_money: String /* 优惠券金额 */,
    val coupon_total_count: String /* 优惠券总量 */,
    val coupon_remain_count: String /* 优惠券剩余数量 */,
    val coupon_info: String /* 优惠券信息 */,
    val juhuasuan: String /* 是否为 聚划算 */,
    val taoqianggou: String /* 是否为 淘抢购 */,
    val haitao: String /* 是否为 海淘 */,
    val jiyoujia: String /* 是否极有家 */,
    val jinpaimaijia: String /* 是否为 金牌卖家 */,
    val pinpai: String /* 是否为 品牌 */,
    val pinpai_name: String /* 品牌名称 */,
    val yunfeixian: String /* ??? */,
    val nick: String /* 店铺名称 */,
    val small_images: String /* 商品组图/商品小图列表 */,
    val white_image: String /* 商品白底图 */,
    val tao_title: String /* 商品长标题 */,
    val provcity: String /* 省份 城市 */,
    val shop_title: String /* 商家名称 */,
    val zhibo_url: String /* 直播地址 */,
    val sellCount: String /* 销售数量 */,
    val commentCount: String /* 评论数量 */,
    val favcount: String /* 喜欢数量 */,
    val score1: String /* 宝贝描述分 */,
    val score2: String /* 卖家服务分 */,
    val score3: String /* 物流服务分 */,
    val creditLevel: String /* 店铺等级 */,
    val shopIcon: String /* 商家图标 URL */,
    val pcDescContent: String /* 内容 url */,
    val item_url: String /* 商品地址 */,
    val category_id: String /* 分类 id */,
    val category_name: String /* 分类名称 */,
    val level_one_category_id: String /* ??? */,
    val level_one_category_name: String /* ??? */,
    val tkfee3: String /* ??? */,
    val biaoqian: String /* 店铺活动 */,
    val tag: String /* 朋友圈文案 */,
    val presale_discount_fee_text: String? /* 预售商品-商品优惠信息 */,
    val presale_tail_end_time: String? /* 预售商品-付定金结束时间（毫秒） */,
    val presale_tail_start_time: String? /* 预售商品-付尾款开始时间（毫秒） */,
    val presale_end_time: String? /* 预售结束时间 */,
    val presale_start_time: String? /* 预售开始时间 */,
    val presale_deposit: String? /* 预售 ??? */
)

data class DtSearchResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtSearchModel>? /* 详细数据 */
)

data class DtShareItemTklForm(
    val item_id: String /* 淘宝的商品 id */, val token: String /* 认证令牌 */
)

data class DtShareItemTklResponseModel(
    val errno: DtAppErrno /* 错误码 */, val errmsg: String /* 错误信息 */, val data: String? /* 淘口令 */
)

data class DtSuggestResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<String>? /* 推荐词 */
)

data class DtSysConfigDataModel(
    val pid: String /* 淘宝 PID 配置 */
)

data class DtSysConfigResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: DtSysConfigDataModel? /* 详细数据 */
)

data class DtTMallChaoShiForm(
    val page: Int? /* 分页 */,
    val page_size: Int? /* 每页数据条数 */,
    val sort: String? /* 商品排序方式 */,
    val cid: Int? /* 一级商品分类 */,
    val price: String? /* 商品价格 */
)

data class DtTMallChaoShiResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtTmallChaoShiModel>? /* 返回数据 */
)

data class DtTMallShangPinForm(
    val page: Int? /* 分页 */,
    val page_size: Int? /* 每页数据条数 */,
    val sort: String? /* 商品排序方式 */,
    val cid: Int? /* 一级商品分类 */,
    val price: String? /* 商品价格 */
)

data class DtTMallShangPinResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtTmallShangPinModel>? /* 详细数据 */
)

data class DtTaoBaoAuthUrlResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: DtAuthUrlDataModel? /* 详细数据 */
)

data class DtTbBindForm(
    val code: String /* 授权的 access code */, val token: String /* 认证 TOKEN */
)

data class DtTbBindResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: Boolean? /* 是否绑定了渠道 ID */
)

data class DtTbServiceGetBrandListArgs(
    val pageId: String /* 页码 */, val pageSize: String? /* 每页条数，默认为20，最大值100 */
)

data class DtTbServiceGetBrandListResp(
    val cid: DtInteger? /* Cid */,
    val brandId: DtInteger? /* Brandid */,
    val brandName: String? /* Brandname */,
    val brandLogo: String? /* Brandlogo */,
    val brandEnglish: String? /* Brandenglish */,
    val shop: List<DtTbServiceGetBrandListRespShop>? /* Shop */,
    val brandScore: DtInteger? /* Brandscore */,
    val location: String? /* Location */,
    val establishTime: String? /* Establishtime */,
    val belongTo: String? /* Belongto */,
    val position: String? /* Position */,
    val consumer: String? /* Consumer */,
    val label: String? /* Label */,
    val simpleLabel: String? /* Simplelabel */,
    val cids: String? /* Cids */,
    val sales2h: DtInteger? /* Sales2H */,
    val fansNum: DtInteger? /* Fansnum */,
    val brandDesc: String? /* Branddesc */
)

data class DtTbServiceGetBrandListRespShop(
    val name: String? /* Name */, val sellerId: String? /* Sellerid */
)

data class DtTbServiceGetPrivilegeLinkArgs(
    val goodsId: String /* 淘宝商品id */,
    val couponId: String? /* 商品的优惠券ID，一个商品在联盟可能有多个优惠券，可通过填写该参数的方式选择使用的优惠券，请确认优惠券ID正确，否则无法正常跳转 */,
    val pid: String? /* 推广位ID，用户可自由填写当前大淘客账号下已授权淘宝账号的任一pid，若未填写，则默认使用创建应用时绑定的pid */,
    val channelId: String? /* 渠道id将会和传入的pid进行验证，验证通过将正常转链，请确认填入的渠道id是正确的 *channelId对应联盟的relationId* */,
    val specialId: String? /* 会员运营id */,
    val externalId: String? /* 淘宝客外部用户标记，如自身系统账户ID；微信ID等 */,
    val rebateType: String? /* 付定返红包，0.不使用付定返红包，1.参与付定返红包 */
)

data class DtTbServiceGetPrivilegeLinkResp(
    val couponClickUrl: String? /* Couponclickurl */,
    val couponEndTime: String? /* Couponendtime */,
    val couponInfo: String? /* Couponinfo */,
    val couponStartTime: String? /* Couponstarttime */,
    val itemId: String? /* Itemid */,
    val couponTotalCount: String? /* Coupontotalcount */,
    val couponRemainCount: String? /* Couponremaincount */,
    val itemUrl: String? /* Itemurl */,
    val tpwd: String? /* Tpwd */,
    val maxCommissionRate: String? /* Maxcommissionrate */,
    val shortUrl: String? /* Shorturl */,
    val minCommissionRate: String? /* Mincommissionrate */,
    val longTpwd: String? /* Longtpwd */
)

data class DtTbServiceGetTbServiceArgs(
    val pageNo: String /* 第几页，默认1 */,
    val pageSize: String /* 每页条数， 默认20，范围值1~100 */,
    val keyWords: String /* 查询词 */,
    val sort: String? /* 排序指标：销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi），价格（price）,排序方式：排序_des（降序），排序_asc（升序）,示例：升序查询销量：total_sales_asc */,
    val source: String? /* 是否商城商品，设置为1表示该商品是属于淘宝商城商品，设置为非1或不设置表示不判断这个属性（和overseas字段冲突，若已请求source，请勿再请求overseas） */,
    val overseas: String? /* 是否海外商品，设置为1表示该商品是属于海外商品，设置为非1或不设置表示不判断这个属性（和source字段冲突，若已请求overseas，请勿再请求source） */,
    val endPrice: String? /* 折扣价范围上限，单位：元 */,
    val startPrice: String? /* 折扣价范围下限，单位：元 */,
    val startTkRate: String? /* 媒体淘客佣金比率下限，如：1234表示12.34% */,
    val endTkRate: String? /* 商品筛选-淘客佣金比率上限，如：1234表示12.34% */,
    val hasCoupon: String? /* 是否有优惠券，设置为true表示该商品有优惠券，设置为false或不设置表示不判断这个属性 */,
    val specialId: String? /* 会员运营id */,
    val channelId: String? /* 渠道id将会和传入的pid进行验证，验证通过将正常转链，请确认填入的渠道id是正确的*channelId对应联盟的relationId* */
)

data class DtTbServiceGetTbServiceResp(
    val title: String? /* Title */,
    val volume: DtInteger? /* Volume */,
    val nick: String? /* Nick */,
    val coupon_start_time: String? /* Coupon Start Time */,
    val coupon_end_time: String? /* Coupon End Time */,
    val tk_total_sales: String? /* Tk Total Sales */,
    val coupon_id: String? /* Coupon Id */,
    val pict_url: String? /* Pict Url */,
    val small_images: DtTbServiceGetTbServiceRespSmallImages? /*  */,
    val reserve_price: String? /* Reserve Price */,
    val zk_final_price: String? /* Zk Final Price */,
    val user_type: DtInteger? /* User Type */,
    val commission_rate: String? /* Commission Rate */,
    val seller_id: DtInteger? /* Seller Id */,
    val coupon_total_count: DtInteger? /* Coupon Total Count */,
    val coupon_remain_count: DtInteger? /* Coupon Remain Count */,
    val coupon_info: String? /* Coupon Info */,
    val shop_title: String? /* Shop Title */,
    val shop_dsr: DtInteger? /* Shop Dsr */,
    val level_one_category_name: String? /* Level One Category Name */,
    val level_one_category_id: DtInteger? /* Level One Category Id */,
    val category_name: String? /* Category Name */,
    val category_id: DtInteger? /* Category Id */,
    val short_title: String? /* Short Title */,
    val white_image: String? /* White Image */,
    val coupon_start_fee: String? /* Coupon Start Fee */,
    val coupon_amount: String? /* Coupon Amount */,
    val item_description: String? /* Item Description */,
    val item_id: DtInteger? /* Item Id */,
    val ysyl_tlj_face: DtInteger? /* Ysyl Tlj Face */,
    val presale_deposit: DtInteger? /* Presale Deposit */,
    val presale_discount_fee_text: String? /* Presale Discount Fee Text */
)

data class DtTbServiceGetTbServiceRespSmallImages(
    val string: List<String>? /* String */
)

data class DtTbkBrandGoodsForm(
    val brand_id: String /* 品牌ID */, val page_id: Int? /* 获取第几页数据 */
)

data class DtTbkBrandInfo(
    val brand_id: String /* 品牌ID */,
    val brand_name: String /* 品牌名称 */,
    val brand_logo: String /* 品牌logo */,
    val brand_desc: String? /* 品牌介绍 */,
    val sales_2h: Int? /* 近期销量 */
)

data class DtTbkBrandListForm(
    val page_id: Int? /* 获取第几页数据 */
)

data class DtTbkBrandListResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: List<DtTbkBrandInfo>? /* 详细数据 */
)

data class DtTbkGoodsDetailResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: DtTbkItemInfo? /* 详细数据 */
)

data class DtTbkItemDetailForm(
    val tao_id: String /* 淘宝商品ID */
)

data class DtTbkItemInfo(
    val tao_id: String /* 商品ID */,
    val tao_img: String /* 商品主图 */,
    val tao_link: String? /* 商品链接 */,
    val tao_details: List<String>? /* 商品详情图 */,
    val title_long: String /* 淘宝标题 */,
    val title_short: String /* 短标题 */,
    val price_origin: Float /* 商品原价 */,
    val price_actual: Float /* 券后价 */,
    val price_coupon: Float? /* 优惠券金额 */,
    val seller_id: String? /* 卖家ID */,
    val seller_name: String? /* 卖家名称 */,
    val seller_logo: String? /* 卖家图标 */,
    val seller_level: Int? /* 淘宝店铺等级 */,
    val score_dsr: Float? /* 描述评级 */,
    val score_ship: Float? /* 物流服务 */,
    val score_service: Float? /* 卖家服务评级 */,
    val percent_dsr: Float? /* 卖家描述同行比 */,
    val percent_ship: Float? /* 物流同行比 */,
    val percent_service: Float? /* 卖家服务同行比 */,
    val commission_rate: Float? /* 佣金比例 */,
    val commission_money: Float? /* 预估佣金 */,
    val sale_month: Int? /* 月销量 */,
    val sale_day: Int? /* 日销量 */,
    val sale_two_hours: Int? /* 两小时销量 */,
    val coupon_start_time: String? /* 优惠券开始时间 */,
    val coupon_end_time: String? /* 优惠券结束时间 */,
    val coupon_total_num: Int? /* 优惠券总量 */,
    val coupon_recv_num: Int? /* 优惠券领取量 */,
    val coupon_link: String? /* 优惠券链接 */,
    val yun_fei_xian: Boolean? /* 运费险 */
)

data class DtTmallChaoShiModel(
    val code: String /* 折淘客编号 */,
    val type_one_id: String /* 分类 id, 参见: cid */,
    val tao_id: String /* 淘宝的商品 id */,
    val title: String /* 商品的标题 */,
    val jianjie: String /* 商品的简介 */,
    val pict_url: String /* 商品的主图 */,
    val user_type: String /* 卖家类型 */,
    val seller_id: String /* 商家的 id */,
    val shop_dsr: String /* 店铺 dsr 评分 */,
    val volume: String /* 30天销量 */,
    val size: String /* 折扣价 */,
    val quanhou_jiage: String /* 券后价格 */,
    val date_time_yongjin: String /* 数据更新时间 */,
    val tkrate3: String /* 佣金比例 */,
    val yongjin_type: String /* 佣金类型 */,
    val coupon_id: String /* 优惠券ID */,
    val coupon_start_time: String /* 优惠券开始时间 */,
    val coupon_end_time: String /* 优惠券结束时间 */,
    val coupon_info_money: String /* 优惠券金额 */,
    val coupon_total_count: String /* 优惠券总量 */,
    val coupon_remain_count: String /* 优惠券剩余数量 */,
    val coupon_info: String /* 优惠券信息 */,
    val juhuasuan: String /* 是否为 聚划算 */,
    val taoqianggou: String /* 是否为 淘抢购 */,
    val haitao: String /* 是否为 海淘 */,
    val jiyoujia: String /* 是否极有家 */,
    val jinpaimaijia: String /* 是否为 金牌卖家 */,
    val pinpai: String /* 是否为 品牌 */,
    val pinpai_name: String /* 品牌名称 */,
    val yunfeixian: String /* ??? */,
    val nick: String /* 店铺名称 */,
    val small_images: String /* 商品组图/商品小图列表 */,
    val white_image: String /* 商品白底图 */,
    val tao_title: String /* 商品长标题 */,
    val provcity: String /* 省份 城市 */,
    val shop_title: String /* 商家名称 */,
    val zhibo_url: String /* 直播地址 */,
    val sellCount: String /* 销售数量 */,
    val commentCount: String /* 评论数量 */,
    val favcount: String /* 喜欢数量 */,
    val score1: String /* 宝贝描述分 */,
    val score2: String /* 卖家服务分 */,
    val score3: String /* 物流服务分 */,
    val creditLevel: String /* 店铺等级 */,
    val shopIcon: String /* 商家图标 URL */,
    val pcDescContent: String /* 内容 url */,
    val item_url: String /* 商品地址 */,
    val category_id: String /* 分类 id */,
    val category_name: String /* 分类名称 */,
    val level_one_category_id: String /* ??? */,
    val level_one_category_name: String /* ??? */,
    val tkfee3: String /* ??? */,
    val biaoqian: String /* 店铺活动 */,
    val tag: String /* 朋友圈文案 */,
    val presale_discount_fee_text: String? /* 预售商品-商品优惠信息 */,
    val presale_tail_end_time: String? /* 预售商品-付定金结束时间（毫秒） */,
    val presale_tail_start_time: String? /* 预售商品-付尾款开始时间（毫秒） */,
    val presale_end_time: String? /* 预售结束时间 */,
    val presale_start_time: String? /* 预售开始时间 */,
    val presale_deposit: String? /* 预售 ??? */
)

data class DtTmallShangPinModel(
    val code: String /* 折淘客编号 */,
    val type_one_id: String /* 分类 id, 参见: cid */,
    val tao_id: String /* 淘宝的商品 id */,
    val title: String /* 商品的标题 */,
    val jianjie: String /* 商品的简介 */,
    val pict_url: String /* 商品的主图 */,
    val user_type: String /* 卖家类型 */,
    val seller_id: String /* 商家的 id */,
    val shop_dsr: String /* 店铺 dsr 评分 */,
    val volume: String /* 30天销量 */,
    val size: String /* 折扣价 */,
    val quanhou_jiage: String /* 券后价格 */,
    val date_time_yongjin: String /* 数据更新时间 */,
    val tkrate3: String /* 佣金比例 */,
    val yongjin_type: String /* 佣金类型 */,
    val coupon_id: String /* 优惠券ID */,
    val coupon_start_time: String /* 优惠券开始时间 */,
    val coupon_end_time: String /* 优惠券结束时间 */,
    val coupon_info_money: String /* 优惠券金额 */,
    val coupon_total_count: String /* 优惠券总量 */,
    val coupon_remain_count: String /* 优惠券剩余数量 */,
    val coupon_info: String /* 优惠券信息 */,
    val juhuasuan: String /* 是否为 聚划算 */,
    val taoqianggou: String /* 是否为 淘抢购 */,
    val haitao: String /* 是否为 海淘 */,
    val jiyoujia: String /* 是否极有家 */,
    val jinpaimaijia: String /* 是否为 金牌卖家 */,
    val pinpai: String /* 是否为 品牌 */,
    val pinpai_name: String /* 品牌名称 */,
    val yunfeixian: String /* ??? */,
    val nick: String /* 店铺名称 */,
    val small_images: String /* 商品组图/商品小图列表 */,
    val white_image: String /* 商品白底图 */,
    val tao_title: String /* 商品长标题 */,
    val provcity: String /* 省份 城市 */,
    val shop_title: String /* 商家名称 */,
    val zhibo_url: String /* 直播地址 */,
    val sellCount: String /* 销售数量 */,
    val commentCount: String /* 评论数量 */,
    val favcount: String /* 喜欢数量 */,
    val score1: String /* 宝贝描述分 */,
    val score2: String /* 卖家服务分 */,
    val score3: String /* 物流服务分 */,
    val creditLevel: String /* 店铺等级 */,
    val shopIcon: String /* 商家图标 URL */,
    val pcDescContent: String /* 内容 url */,
    val item_url: String /* 商品地址 */,
    val category_id: String /* 分类 id */,
    val category_name: String /* 分类名称 */,
    val level_one_category_id: String /* ??? */,
    val level_one_category_name: String /* ??? */,
    val tkfee3: String /* ??? */,
    val biaoqian: String /* 店铺活动 */,
    val tag: String /* 朋友圈文案 */,
    val presale_discount_fee_text: String? /* 预售商品-商品优惠信息 */,
    val presale_tail_end_time: String? /* 预售商品-付定金结束时间（毫秒） */,
    val presale_tail_start_time: String? /* 预售商品-付尾款开始时间（毫秒） */,
    val presale_end_time: String? /* 预售结束时间 */,
    val presale_start_time: String? /* 预售开始时间 */,
    val presale_deposit: String? /* 预售 ??? */
)

data class DtUserAuthResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: DtUserNativeAuthDataModel? /* 详细数据 */
)

data class DtUserCancelResponseModel(
    val errno: DtAppErrno /* 错误码 */, val errmsg: String /* 错误信息 */, val data: Boolean? /* 是否已经注销 */
)

data class DtUserNativeAuthDataModel(
    val token: String /* 认证令牌(TOKEN) */
)

data class DtUserNativeAuthForm(
    val username: String /* 账号 */, val password: String /* 密码 */
)

data class DtUserProfileDataModel(
    val mobile: String? /* 手机号码 */,
    val tao_id: String? /* 用户绑定的淘宝ID */,
    val wx: String? /* 微信 */,
    val relation_id: String? /* 淘宝渠道ID */,
    val ali_name: String? /* 支付宝姓名 */,
    val ali_account: String? /* 支付宝账号 */
)

data class DtUserProfileResponseModel(
    val errno: DtAppErrno /* 错误码 */,
    val errmsg: String /* 错误信息 */,
    val data: DtUserProfileDataModel? /* 详细数据 */
)

data class DtUserTbResponseModel(
    val errno: DtAppErrno /* 错误码 */, val errmsg: String /* 错误信息 */, val data: Boolean? /* 是否绑定了淘宝 */
)

data class DtUserTokenForm(
    val token: String /* 认证令牌 */
)

data class DtValidationError(
    val loc: List<String> /* Location */,
    val msg: String /* Message */,
    val type: String /* Error Type */
)


