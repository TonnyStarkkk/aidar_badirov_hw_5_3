package com.example.aidar_badirov_hw_5_3.network

import com.example.aidar_badirov_hw_5_3.model.ResultResponse
import com.example.aidar_badirov_hw_5_3.util.Constants.Companion.API_KEY
import com.example.aidar_badirov_hw_5_3.util.Constants.Companion.HOST
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface API {

    @Headers("x-rapidapi-key: $API_KEY", "x-rapidapi-host: $HOST")
    @GET("getPercentage")
    fun getResult(
        @Query("fname") yourName: String,
        @Query("sname") partnerName: String
    ): Call<ResultResponse>
}