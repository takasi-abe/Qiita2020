package com.example.qiita2020


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_article_list_recycler_view.*

class ArticleListRecyclerView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_list_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //記事情報の取得
        GetArticle().getQiitaArticle {

            Log.d("fragment", "call")
            //RecyclerViewの指定
            val recyclerView = articleList
            val adapter = ArticleListRecyclerViewAdapter(it, object : ArticleListRecyclerViewAdapter.ArticleListener{
                override fun onClickRow(tappedView: View, articleItems: Article) {
                    Log.d("Adapter", "click[${articleItems.url}]")

                    //記事のwebページを表示する
                    callArticlePage(articleItems)

                }
            })

            //取得した記事の表示
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(activity)
        }


    }


    /**
     * Webページを表示する
     * @param articleItems リストからタップした記事の情報
     */
    private fun callArticlePage(articleItems: Article) {

        Log.d("ArticleFragment", "called")
        val fragment = WebView(articleItems)
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()


        fragmentTransaction?.replace(R.id.articleListContainer, fragment)?.commit()
    }

}
