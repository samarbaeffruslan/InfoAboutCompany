package com.example.detail.data

import com.example.core_api.dto.CompanyDetailDTO
import com.example.core_api.dto.CompanyDetailDtoList
import retrofit2.Response

interface DetailRepository {

    suspend fun getDetailInfo(id: Long): Response<CompanyDetailDtoList>
}