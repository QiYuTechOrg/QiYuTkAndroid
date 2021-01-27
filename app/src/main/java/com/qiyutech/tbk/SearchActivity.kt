package com.qiyutech.tbk

import android.app.SearchManager
import android.database.Cursor
import android.database.MatrixCursor
import android.graphics.Color
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SearchView
import androidx.cursoradapter.widget.CursorAdapter
import androidx.cursoradapter.widget.SimpleCursorAdapter
import com.google.android.flexbox.FlexboxLayout
import com.qiyutech.tbk.databinding.ActivitySearchBinding
import com.qiyutech.tbk.dt.ApiDtkSearchSuggestionStub
import com.qiyutech.tbk.dt.DtGoodsSearchSuggestionArgs
import com.qiyutech.tbk.logic.AppErrnoLogic
import com.qiyutech.tbk.utils.AppUtils
import com.qiyutech.tbk.utils.LayoutUtils
import com.qiyutech.tbk.utils.LoadKeywordUtils
import com.qiyutech.tbk.utils.MySearchUtils
import com.qiyutech.tbk.values.AppPreferenceUtils


/**
 * 搜索 建议
 */
private class SearchSuggestion(private val searchView: SearchView) :
    SearchView.OnSuggestionListener {

    override fun onSuggestionClick(position: Int): Boolean {
        val cursor = searchView.suggestionsAdapter.getItem(position) as Cursor
        val selection = cursor.getString(cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1))
        searchView.setQuery(selection, false)
        return true
    }

    override fun onSuggestionSelect(position: Int): Boolean {
        return false
    }
}

private class SearchQueryTextListener(
    private val activity: SearchActivity,
    private val searchView: SearchView
) :
    SearchView.OnQueryTextListener {

    override fun onQueryTextSubmit(query: String?): Boolean {
        // extract to search method
        if (query.isNullOrBlank()) {
            return false
        }

        MySearchUtils.doSearch(activity, query)

        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query.isNullOrBlank()) {
            return true
        }

        val args = DtGoodsSearchSuggestionArgs(keyWords = query, type = "3")
        ApiDtkSearchSuggestionStub.myPost(activity, args,
            { v ->
                AppErrnoLogic.genericServerErrnoProcess(v.errno, activity)
                if (v.errno != 0) {
                    Log.w("request suggest failed:", v.toString())
                    return@myPost
                }
                val cursor =
                    MatrixCursor(arrayOf(BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1))

                v.data?.forEachIndexed { index, suggestion ->
                    val item = arrayOf(index, suggestion)
                    cursor.addRow(item)
                }

                this.searchView.suggestionsAdapter.changeCursor(cursor)

            },
            { error -> Log.e("search suggest", "错误: $error") }
        )

        return false
    }
}

/**
 * 商品主搜索界面
 */
class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

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
        val asb = ActivitySearchBinding.bind(view)

        val searchInput = asb.searchSearchInput
        searchInput.suggestionsAdapter = cursorAdapter

        searchInput.setOnQueryTextListener(SearchQueryTextListener(this, searchInput))
        searchInput.setOnSuggestionListener(SearchSuggestion(searchInput))
    }

    override fun onStart() {
        super.onStart()

        val lku = LoadKeywordUtils(this)
        lku.loadKeyword()

        loadSearchHistoryKeyword()
    }


    fun closeSearchActivity(view: View) {
        this.finish()
    }

    /**
     * 搜索商品
     */
    fun doSearchItem(view: View) {
        val root = AppUtils.getRootView(this)
        val sb = ActivitySearchBinding.bind(root)
        val input = sb.searchSearchInput
        val query = input.query.toString()
        if (query.isBlank()) {
            Toast.makeText(this, "查询内容为空", Toast.LENGTH_SHORT).show()
            return
        } else {
            MySearchUtils.doSearch(this, query)
        }
    }

    /**
     * 获取 自定义的 btn
     */
    private fun getBtn(): AppCompatButton {
        val ctx = baseContext

        val btn = AppCompatButton(this)
        btn.layoutParams = FlexboxLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            LayoutUtils.spToInt(ctx, 36)
        )

        val layer2 = btn.layoutParams as ViewGroup.MarginLayoutParams
        layer2.topMargin = LayoutUtils.spToInt(ctx, 4)
        layer2.bottomMargin = LayoutUtils.spToInt(ctx, 4)
        layer2.marginStart = LayoutUtils.spToInt(ctx, 5)
        layer2.marginEnd = LayoutUtils.spToInt(ctx, 5)

        btn.setBackgroundResource(R.drawable.search_button_bg)
        btn.setTextColor(Color.parseColor("#666666"))
        btn.setPadding(30, 0, 30, 0)

        return btn
    }

    /**
     * 加载搜索的历史
     */
    fun loadSearchHistoryKeyword() {
        val view = AppUtils.getRootView(this)
        val asb = ActivitySearchBinding.bind(view)

        val searchFlexBoxLayout = asb.searchHistoryFlexBoxLayoutId
        searchFlexBoxLayout.removeAllViews()

        AppPreferenceUtils.getSearchHistory(this).map {
            val btn = this.getBtn()
            btn.text = it

            btn.setOnClickListener { _ ->
                MySearchUtils.doSearch(this, it)
            }

            btn.requestLayout()
            searchFlexBoxLayout.addView(btn)
        }
        searchFlexBoxLayout.requestLayout()
    }

    /// 把搜索的热词加载到界面中
    fun pushHotSearchKeyword(dataList: List<String>) {
        val view = AppUtils.getRootView(this)
        val asb = ActivitySearchBinding.bind(view)

        val fl = asb.hotSearchFlexBoxLayoutId
        fl.removeAllViews()
        dataList.map {
            val btn = this.getBtn()
            btn.text = it
            btn.setOnClickListener { _ ->
                MySearchUtils.doSearch(this, it)
            }
            btn.requestLayout()
            fl.addView(btn)
        }
        fl.requestLayout()
    }
}
