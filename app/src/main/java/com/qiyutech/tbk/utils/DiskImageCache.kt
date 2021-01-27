package com.qiyutech.tbk.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.bumptech.glide.disklrucache.DiskLruCache
import com.qiyutech.tbk.values.LogTags
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.math.BigInteger
import java.security.MessageDigest

object MyImageDiskCache {

    /// 缓存的大小
    private const val CACHE_SIZE: Long = 1 * 1024 * 1024 * 1024

    fun putImage(ctx: Context, url: String, bitmap: Bitmap) {
        Log.d(LogTags.CACHE_IMAGE, "put $url")
        val cache = DiskLruCache.open(ctx.cacheDir, 1, 1, CACHE_SIZE)
        val key = getCacheKey(url)
        cache.edit(key).let { editor ->
            editor.getFile(0).let { file ->
                val out = BufferedOutputStream(file.outputStream())
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
                out.close()
                editor.commit()
                cache.flush()
            }
        }
    }

    fun getImage(ctx: Context, url: String): Bitmap? {
        val cache = DiskLruCache.open(ctx.cacheDir, 1, 1, CACHE_SIZE)
        val key = getCacheKey(url)
        cache.get(key)?.let { value ->
            value.getFile(0)?.let { file ->
                file.inputStream().let { input ->
                    val buffer = BufferedInputStream(input, 1024 * 1024)
                    Log.d(LogTags.CACHE_IMAGE, "get success: $url")
                    return BitmapFactory.decodeStream(buffer)
                }
            }
        }
        Log.d(LogTags.CACHE_IMAGE, "get failed: $url")
        return null
    }

    private fun getCacheKey(url: String): String {
        val md = MessageDigest.getInstance("MD5")
        val v = md.digest(url.toByteArray(Charsets.UTF_8))
        val b = BigInteger(v)
        return String.format("%032x", b)
    }
}
