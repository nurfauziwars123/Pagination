package com.example.submission7.network

import com.example.submission7.model.ResponseData
import com.example.submission7.model.ResultsItem
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @GET("lists")
    fun getData(
        @Query("page") page : Int?,
        @Query("total_result") total_result : Int?,
        @Query("api_key") api : String?,
        @Query("language") language : String =  "en-Us"
    ) : Flowable<ResponseData>

    @GET("search/movie")
    fun searchMovies(@QueryMap options : Map<String, String>) : Flowable<ResultsItem>
}