package com.corotuinesflowmvvmretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.corotuinesflowmvvmretrofit.model.NewsRespostiory

class ListViewModel : ViewModel() {

    val newsArticles = NewsRespostiory.getNewsArticles().asLiveData()



}