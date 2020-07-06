package com.example.qiita2020

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_article_item.view.*

class ArticleListRecyclerViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
    val titleView: TextView = mView.title
    val dateView: TextView = mView.date
    val userNameView: TextView = mView.name
    val iconView: ImageView = mView.icon
    val articleRow: ConstraintLayout = mView.ArticleRow
}