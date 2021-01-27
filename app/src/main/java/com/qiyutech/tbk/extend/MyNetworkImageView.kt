package com.qiyutech.tbk.extend

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.qiyutech.tbk.utils.NetworkImageUtils
import com.qiyutech.tbk.utils.TipUtils

/**
 * 编程自动加载图片
 */
class MyManualImageView(ctx: Context) : AppCompatImageView(ctx) {
    /**
     * 自动加载图片
     */
    fun loadImageFromUrl(imageUrl: String) {
        val url = if (imageUrl.startsWith("//")) {
            "http:${imageUrl}"
        } else {
            imageUrl
        }

        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .skipMemoryCache(true)
            .into(this)
    }
}

/**
 * 网络图片 View
 * 自动加载网络图片 如果需要的话
 */
class MyNetworkImageView(ctx: Context, attrSet: AttributeSet) : AppCompatImageView(ctx, attrSet) {
    /**
     * 自动加载图片
     */
    fun loadImageFromUrl(imageUrl: String, displayError: Boolean = false) {
        val url = if (imageUrl.startsWith("//")) {
            "http:${imageUrl}"
        } else {
            imageUrl
        }

        // 使用 glide 加载会导致 slot 图片不展示
        NetworkImageUtils.download(context,
            url,
            this.scaleType,
            { image -> this.setImageBitmap(image) },
            {
                if (displayError) {
                    TipUtils.toastShort(context, "下载图片失败: $it")
                }
            })
    }
}
