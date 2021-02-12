package com.example.companymain.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.companymain.di.CompanyMainComponent
import javax.inject.Inject

class CompanyMainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by activityViewModels<CompanyMainFragmentViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        CompanyMainComponent.injectFragment(this)
        super.onAttach(context)
    }



}