package com.example.aidar_badirov_hw_5_3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aidar_badirov_hw_5_3.databinding.FragmentResultBinding
import com.example.aidar_badirov_hw_5_3.model.ResultResponse

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultArg = arguments?.getSerializable("RESULT_ARG") as ResultResponse
        binding.result.text = resultArg.result
        binding.percentage.text = resultArg.percentage
    }
}