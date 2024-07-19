package com.example.aidar_badirov_hw_5_3.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aidar_badirov_hw_5_3.model.ResultResponse
import com.example.aidar_badirov_hw_5_3.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultViewModel : ViewModel() {

    val resultLiveData = MutableLiveData<ResultResponse>()
    val errorData = MutableLiveData<String>()

    fun getResult(yourName: String, partnerName: String) {
        RetrofitInstance.api.getResult(yourName, partnerName).enqueue(object : Callback<ResultResponse> {
            override fun onResponse(call: Call<ResultResponse>, response: Response<ResultResponse>) {
                if (response.body() != null && response.isSuccessful) {
                    resultLiveData.postValue(response.body())
                } else {
                    errorData.postValue(response.message())
                }
            }

            override fun onFailure(call: Call<ResultResponse>, t: Throwable) {
                errorData.postValue(t.localizedMessage)
            }
        })
    }
}