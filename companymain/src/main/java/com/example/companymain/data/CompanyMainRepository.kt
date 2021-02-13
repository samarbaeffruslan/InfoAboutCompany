package com.example.companymain.data


import com.example.core_api.dto.CompanyDtoList
import retrofit2.Response

interface CompanyMainRepository {

    suspend fun getCompanyInfo(): Response<CompanyDtoList>
}