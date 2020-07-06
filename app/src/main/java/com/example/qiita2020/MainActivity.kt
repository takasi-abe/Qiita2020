package com.example.qiita2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getArticleButton.setOnClickListener {
            callQiitaList()
        }

    }

    private fun callQiitaList() {
        val fragment = ArticleListRecyclerView()
        val fragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.articleListContainer, fragment)
            .commit()
    }
}
