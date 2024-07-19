package com.example.aidar_badirov_hw_5_3.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aidar_badirov_hw_5_3.repository.ResultRepository

class ViewModelProviderFactory(
    val resultRepository: ResultRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ResultViewModel(resultRepository) as T
    }
}

