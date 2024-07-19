package com.example.aidar_badirov_hw_5_3.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aidar_badirov_hw_5_3.MainActivity
import com.example.aidar_badirov_hw_5_3.R
import com.example.aidar_badirov_hw_5_3.databinding.FragmentInputBinding

class InputFragment: Fragment(R.layout.fragment_input) {

    private lateinit var binding: FragmentInputBinding
    private lateinit var viewModel: ResultViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInputBinding.inflate(layoutInflater)
        viewModel = (activity as MainActivity).viewModel


        binding.submit.setOnClickListener {
            viewModel.getResult(binding.edYourName.text.toString(),binding.edPartnerName.text.toString())
            findNavController().navigate(R.id.action_inputFragment_to_resultFragment)
        }
    }
}