package com.example.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.core_api.providers.AppWithFacade
import com.example.di.MainActivityComponent

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        initDI()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return

        findNavController(R.id.nav_host_fragment)
        host.navController
    }

    private fun initDI() {
        MainActivityComponent.create((application as AppWithFacade).getFacade())
            .inject(this)
    }
}