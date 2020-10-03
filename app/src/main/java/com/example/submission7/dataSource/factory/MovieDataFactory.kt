package com.example.submission7.dataSource.factory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.submission7.dataSource.MovieDataSource
import com.example.submission7.model.ResultsItem

class MovieDataFactory() : DataSource.Factory<Int, ResultsItem>() {

    var mutableLiveData : MutableLiveData<MovieDataSource>
    var movieDataSource : MovieDataSource

    init {
        mutableLiveData = MutableLiveData()
        movieDataSource = MovieDataSource()
    }

    override fun create(): DataSource<Int, ResultsItem> {
        mutableLiveData.postValue(movieDataSource)
        return movieDataSource
    }
    fun getMoiveDataSource() : MutableLiveData<MovieDataSource>{
        return mutableLiveData
    }
}

