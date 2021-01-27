package com.qiyutech.tbk.dt


enum class TbkSortType {
    Common, // 综合排序
    Sales,  // 销量
    Price;  // 价格


    fun getString(): String? {
        return when (this) {
            Common -> null
            Sales -> "total_sales_des"
            Price -> "price_asc"
        }
    }
}
