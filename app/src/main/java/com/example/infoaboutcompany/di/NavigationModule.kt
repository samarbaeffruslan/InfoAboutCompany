package com.example.infoaboutcompany.di

import com.example.core.navigation.CompanyMainNavigator
import com.example.navigation.CompanyMainNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface NavigationModule {

    @Reusable
    @Binds
    fun companyMainNavigator(navigator: CompanyMainNavigatorImpl): CompanyMainNavigator
}