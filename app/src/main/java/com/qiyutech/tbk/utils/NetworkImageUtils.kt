package com.qiyutech.tbk.utils

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.android.volley.VolleyError
import com.android.volley.toolbox.ImageRequest
import com.qiyutech.tbk.values.HttpTags


/**
 * 网络图片加载辅助工具
 */
object NetworkImageUtils {
    /**
     * 下载图片
     */
    fun download(
        ctx: Context,
        url: String,
        scale: ImageView.ScaleType,
        success: (Bitmap) -> Unit,
        failure: (VolleyError) -> Unit
    ) {
        val cacheImg = MyImageDiskCache.getImage(ctx, url)
        if (cacheImg == null) {
            val r = ImageRequest(
                url, { img ->
                    MyImageDiskCache.putImage(ctx, url, img)
                    success(img)
                }, 0, 0, scale, null
            ) { failure(it) }
            MyHttpUtils.addToQueue(ctx, HttpTags.IMAGE, r)
        } else {
            success(cacheImg)
        }
    }

    /**
     * 取消当前所有的下载
     */
    fun cancelAll(ctx: Context) {
        MyHttpUtils.cancelAllRequest(ctx, HttpTags.IMAGE)
    }
}
