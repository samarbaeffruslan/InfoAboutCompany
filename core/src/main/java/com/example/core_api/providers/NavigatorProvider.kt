package com.example.core_api.providers

import com.example.core.navigation.CompanyMainNavigator

interface NavigatorProvider {

    fun providerMainNavigator(): CompanyMainNavigator
}