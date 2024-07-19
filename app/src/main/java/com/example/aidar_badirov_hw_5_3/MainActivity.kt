package com.example.aidar_badirov_hw_5_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.aidar_badirov_hw_5_3.databinding.ActivityMainBinding
import com.example.aidar_badirov_hw_5_3.repository.ResultRepository
import com.example.aidar_badirov_hw_5_3.ui.fragments.ResultViewModel
import com.example.aidar_badirov_hw_5_3.ui.fragments.ViewModelProviderFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    lateinit var viewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultRepository = ResultRepository()
        val resultViewModelProviderFactory = ViewModelProviderFactory(resultRepository)
        viewModel = ViewModelProvider(this, resultViewModelProviderFactory).get(ResultViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        setupActionBarWithNavController(navController)
    }
}
