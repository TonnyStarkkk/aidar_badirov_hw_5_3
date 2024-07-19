package com.example.aidar_badirov_hw_5_3.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aidar_badirov_hw_5_3.model.ResultResponse
import com.example.aidar_badirov_hw_5_3.repository.ResultRepository

class ResultViewModel : ViewModel() {

    private val resultRepository = ResultRepository()

    val resultLiveData = MutableLiveData<ResultResponse>()

    fun getResult(yourName: String, partnerName: String) {
        resultRepository.getResult(yourName, partnerName).observeForever { result ->
            resultLiveData.postValue(result)
        }
    }
}