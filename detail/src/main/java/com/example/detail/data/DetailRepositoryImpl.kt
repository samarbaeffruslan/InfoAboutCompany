package com.example.detail.data

import com.example.core.network.service.CompanyService
import com.example.core_api.dto.CompanyDetailDTO
import com.example.core_api.dto.CompanyDetailDtoList
import retrofit2.Response
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val service: CompanyService
): DetailRepository {

    override suspend fun getDetailInfo(id: Long): Response<CompanyDetailDtoList> =
        service.getInfoDetail(id)

}