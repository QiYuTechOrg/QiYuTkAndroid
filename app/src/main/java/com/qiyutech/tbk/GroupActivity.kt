package com.qiyutech.tbk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.qiyutech.tbk.fragments.TextHeaderFragment


/**
 * 微信群 界面
 */
class GroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        supportFragmentManager.beginTransaction()
            .replace(R.id.group_header, TextHeaderFragment("微信群"))
            .commit()
    }
}
