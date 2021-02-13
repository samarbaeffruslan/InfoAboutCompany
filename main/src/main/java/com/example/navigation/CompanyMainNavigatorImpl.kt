package com.example.navigation

import androidx.navigation.NavController
import com.example.core.navigation.CompanyMainNavigator
import com.example.main.R
import javax.inject.Inject

class CompanyMainNavigatorImpl @Inject constructor(): CompanyMainNavigator {


    override fun navigateToDetail(navController: NavController) {
        navController.navigate(R.id.action_companyMainFragment_to_detailFragment)
    }
}