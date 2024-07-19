package com.example.aidar_badirov_hw_5_3.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aidar_badirov_hw_5_3.model.ResultResponse
import com.example.aidar_badirov_hw_5_3.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultRepository {
    fun getResult(yourName: String, partnerName: String): LiveData<ResultResponse> {
        val data = MutableLiveData<ResultResponse>()
        RetrofitInstance.api.getResult(yourName, partnerName).enqueue(object : Callback<ResultResponse> {
            override fun onResponse(call: Call<ResultResponse>, response: Response<ResultResponse>) {
                if (response.code() in 200..300 && response.body() != null) {
                    data.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ResultResponse>, t: Throwable) {
                Log.e("requestError", "onFailure: ${t.message}")
            }
        })
        return data
    }
}