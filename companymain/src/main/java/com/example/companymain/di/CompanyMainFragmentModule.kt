package com.example.companymain.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.companymain.data.CompanyMainRepository
import com.example.companymain.data.CompanyMainRepositoryImpl
import com.example.companymain.presentation.CompanyMainFragmentViewModel
import com.example.core.di.viewmodel.ViewModelKey
import com.example.core.viewmodelfactory.ViewModelFactory
import com.example.detail.data.DetailRepository
import com.example.detail.data.DetailRepositoryImpl
import com.example.detail.presentation.DetailFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CompanyMainFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(CompanyMainFragmentViewModel::class)
    fun bindViewModel(viewModel: CompanyMainFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailFragmentViewModel::class)
    fun bindDetailViewModel(viewModel: DetailFragmentViewModel): ViewModel

    @Binds
    fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun providePopularRepository(repository: CompanyMainRepositoryImpl): CompanyMainRepository

    @Binds
    fun provideDetailRepository(repository: DetailRepositoryImpl): DetailRepository

}