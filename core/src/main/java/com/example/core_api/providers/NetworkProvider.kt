package com.example.core_api.providers

import com.example.core.network.service.CompanyService

interface NetworkProvider {

    fun providerCompanyService(): CompanyService
}