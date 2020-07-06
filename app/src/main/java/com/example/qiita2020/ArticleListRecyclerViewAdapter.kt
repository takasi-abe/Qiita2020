package com.example.qiita2020

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_article_item.*

class ArticleListRecyclerViewAdapter(
    private val mValues: List<Article>,
    private val mListener: ArticleListener
) : RecyclerView.Adapter<ArticleListRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleListRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_article_item, parent, false)
        return  ArticleListRecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mValues.count()
    }

    override fun onBindViewHolder(holder: ArticleListRecyclerViewHolder, position: Int) {

        val iconSize = 60

        val item = mValues[position]
        val transformation = RoundedTransFormation()
        holder.titleView.text = item.title
        holder.dateView.text = item.date
        holder.userNameView.text = item.user.userName
        Picasso.get()
            .load(item.user.icon)
            .resize(iconSize, iconSize)
            .transform(transformation)
            .into(holder.iconView)

        holder.articleRow.setOnClickListener {
            mListener.onClickRow(it, item)
        }
    }


    interface ArticleListener {
        fun onClickRow(tappedView: View, articleItems: Article)
    }

}