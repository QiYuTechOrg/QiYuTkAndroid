package com.qiyutech.tbk.logic

import android.app.SearchManager
import android.database.Cursor
import android.database.MatrixCursor
import android.provider.BaseColumns
import android.util.Log
import androidx.appcompat.widget.SearchView
import com.qiyutech.tbk.CouponActivity
import com.qiyutech.tbk.dt.ApiDtkSearchSuggestionStub
import com.qiyutech.tbk.dt.DtGoodsSearchSuggestionArgs
import com.qiyutech.tbk.utils.MySearchUtils


class CouponSearchSuggestion(private val searchView: SearchView) :
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


class CouponSearchQueryTextListener(
    private val activity: CouponActivity,
    private val searchView: SearchView
) : SearchView.OnQueryTextListener {

    override fun onQueryTextSubmit(query: String?): Boolean {
        // extract to search method
        if (query.isNullOrBlank()) {
            return false
        }
        MySearchUtils.doCouponSearch(activity, query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText.isNullOrBlank()) {
            return true
        }

        val args = DtGoodsSearchSuggestionArgs(keyWords = newText, type = "3")
        ApiDtkSearchSuggestionStub.myPost(activity, args,
            { v ->
                AppErrnoLogic.genericServerErrnoProcess(v.errno, activity)
                if (v.errno != 0) {
                    Log.w("request suggest failed:", v.toString())
                    return@myPost
                }
                Log.i("search", v.toString())
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
