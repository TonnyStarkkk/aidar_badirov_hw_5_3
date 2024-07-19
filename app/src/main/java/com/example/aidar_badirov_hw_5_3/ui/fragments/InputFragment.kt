package com.example.aidar_badirov_hw_5_3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aidar_badirov_hw_5_3.R
import com.example.aidar_badirov_hw_5_3.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private var _binding: FragmentInputBinding? = null
    private val binding = _binding!!
    private val viewModel: ResultViewModel by lazy {
        ViewModelProvider(this)[ResultViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submit.setOnClickListener {
            viewModel.getResult(
                binding.edYourName.text.toString(),
                binding.edPartnerName.text.toString()
            )
        }

        viewModel.resultLiveData.observe(viewLifecycleOwner) { data ->
            findNavController().navigate(
                R.id.action_inputFragment_to_resultFragment,
                Bundle().also {
                    it.putSerializable("RESULT_ARG", data)
                }
            )
        }

        viewModel.errorData.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }
}