package com.example.aidar_badirov_hw_5_3.repository

import com.example.aidar_badirov_hw_5_3.network.RetrofitInstance

class ResultRepository {
    suspend fun getResult(yourName: String, partnerName: String) = RetrofitInstance.api.getResult(yourName, partnerName)
}