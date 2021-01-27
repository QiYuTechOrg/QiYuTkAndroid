package com.qiyutech.tbk

import android.app.SearchManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cursoradapter.widget.CursorAdapter
import androidx.cursoradapter.widget.SimpleCursorAdapter
import com.qiyutech.tbk.databinding.ActivityCouponBinding
import com.qiyutech.tbk.fragments.home.HomeFragmentGuessYouLike
import com.qiyutech.tbk.logic.CouponSearchQueryTextListener
import com.qiyutech.tbk.logic.CouponSearchSuggestion
import com.qiyutech.tbk.utils.AppUtils

/**
 * 优惠券界面
 */
class CouponActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon)

        this.initItemSearchView()

        supportFragmentManager.beginTransaction()
            .replace(R.id.guess_you_like_fragment, HomeFragmentGuessYouLike())
            .commit()
    }

    /**
     * 初始化商品的搜索 只需要一次就行了
     */
    private fun initItemSearchView() {
        val from = arrayOf(SearchManager.SUGGEST_COLUMN_TEXT_1)
        val to = intArrayOf(R.id.item_label)
        val cursorAdapter = SimpleCursorAdapter(
            this,
            R.layout.search_search_item,
            null,
            from,
            to,
            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        )

        val view = AppUtils.getRootView(this)
        val bd = ActivityCouponBinding.bind(view)

        val searchView = bd.itemSearchView
        searchView.suggestionsAdapter = cursorAdapter
        searchView.setOnQueryTextListener(CouponSearchQueryTextListener(this, searchView))
        searchView.setOnSuggestionListener(CouponSearchSuggestion(searchView))
    }

    override fun onDestroy() {
        super.onDestroy()

        viewModelStore.clear()
    }


}
