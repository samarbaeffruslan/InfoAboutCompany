package com.example.core.network.service

import com.example.core_api.dto.CompanyDTO
import com.example.core_api.dto.CompanyDetailDTO
import com.example.core_api.dto.CompanyDetailDtoList
import com.example.core_api.dto.CompanyDtoList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CompanyService {


    @GET("/test_task/test.php")
    suspend fun getMainInfoCompany(): Response<CompanyDtoList>

    @GET("/test_task/test.php/{id}")
    suspend fun getInfoDetail(
        @Query("id") id: Long
    ): Response<CompanyDetailDtoList>
}