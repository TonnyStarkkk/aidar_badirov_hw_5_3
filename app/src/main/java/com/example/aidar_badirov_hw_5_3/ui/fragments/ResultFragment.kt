package com.example.aidar_badirov_hw_5_3.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.aidar_badirov_hw_5_3.MainActivity
import com.example.aidar_badirov_hw_5_3.R
import com.example.aidar_badirov_hw_5_3.databinding.FragmentResultBinding

class ResultFragment: Fragment(R.layout.fragment_result) {

    private lateinit var binding: FragmentResultBinding
    lateinit var viewModel: ResultViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultBinding.inflate(layoutInflater)
        viewModel = (activity as MainActivity).viewModel

        viewModel.resultLiveData.observe(viewLifecycleOwner) { response ->
            binding.percentage.text = response.percentage + " %"
            binding.result.text = response.result
        }
    }
}