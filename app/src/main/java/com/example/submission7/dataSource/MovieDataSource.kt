package com.example.submission7.dataSource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.submission7.model.ResultsItem
import com.example.submission7.network.NetworkConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDataSource () : PageKeyedDataSource<Int, ResultsItem>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ResultsItem>
    ) {
        NetworkConfig.service().getData(1, params.requestedLoadSize, "b64d761def5c00e40e6a36e0032741bf")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.results?.let { it1 -> callback.onResult(it1, null, 5) }
                Log.d("response Data : ", it.toString())
            },{
                Log.d("Response Error", it.toString())
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ResultsItem>) {

        NetworkConfig.service().getData(params.key, params.requestedLoadSize, "b64d761def5c00e40e6a36e0032741bf")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.results?.let { it1 -> callback.onResult(it1, params.key + 1) }
            },{

            })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ResultsItem>) {

    }
}