package com.example.companymain.presentation

import androidx.lifecycle.ViewModel
import com.example.companymain.data.CompanyMainRepository
import javax.inject.Inject

class CompanyMainFragmentViewModel @Inject constructor(
    private val repository: CompanyMainRepository
) : ViewModel() {
}