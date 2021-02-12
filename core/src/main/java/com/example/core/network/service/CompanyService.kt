package com.example.core.network.service

import com.example.core_api.dto.CompanyDTO
import com.example.core_api.dto.CompanyDetailDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CompanyService {


    @GET("/test_task/test.php")
    suspend fun getMainInfoCompany(): Response<CompanyDTO>

    @GET("/test_task/test.php/{id}")
    suspend fun getInfoDetail(
        @Path("id") id: Long
    ): Response<CompanyDetailDTO>
}