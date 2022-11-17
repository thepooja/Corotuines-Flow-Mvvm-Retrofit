package com.corotuinesflowmvvmretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.corotuinesflowmvvmretrofit.R
import com.corotuinesflowmvvmretrofit.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val newsListAdapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        newsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsListAdapter
        }

        observeViewModel()
    }
    private fun observeViewModel() {
        viewModel.newsArticles.observe(this, Observer { article ->
            loading_view.visibility = View.GONE
            newsList.visibility = View.VISIBLE
            newsListAdapter.onAddNewsItem(article)
            newsList.smoothScrollToPosition(0)
        })
    }
}