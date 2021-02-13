package com.example.companymain.data

import com.example.core.network.service.CompanyService
import com.example.core_api.dto.CompanyDtoList
import retrofit2.Response
import javax.inject.Inject

class CompanyMainRepositoryImpl @Inject constructor(
    private val service: CompanyService
): CompanyMainRepository {

    override suspend fun getCompanyInfo(): Response<CompanyDtoList> =
        service.getMainInfoCompany()

}