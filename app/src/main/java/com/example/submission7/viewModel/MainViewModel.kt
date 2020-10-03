package com.example.submission7.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.submission7.dataSource.factory.MovieDataFactory
import com.example.submission7.model.ResultsItem
import io.reactivex.rxjava3.core.Flowable
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MainViewModel() : ViewModel() {

    var executor : Executor
    var resultItem : LiveData<PagedList<ResultsItem>>

    init {
        executor =  Executors.newFixedThreadPool(5)
        var movieFactory = MovieDataFactory()
        var pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

         resultItem = LivePagedListBuilder(movieFactory, pageListConfig)
            .setFetchExecutor(executor)
            .build()
    }

    fun getResult() :LiveData<PagedList<ResultsItem>>{
        return resultItem
    }

}