package com.example.aidar_badirov_hw_5_3.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aidar_badirov_hw_5_3.model.ResultResponse
import com.example.aidar_badirov_hw_5_3.repository.ResultRepository
import kotlinx.coroutines.launch

class ResultViewModel(
    val resultRepository: ResultRepository
) : ViewModel() {

    val resultLiveData = MutableLiveData<ResultResponse>()

    fun getResult(yourName: String, partnerName: String) = viewModelScope.launch {
        val response = resultRepository.getResult(yourName, partnerName)
        resultLiveData.postValue(response)
    }
}