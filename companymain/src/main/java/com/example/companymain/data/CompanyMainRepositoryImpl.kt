package com.example.companymain.data

import com.example.core.network.service.CompanyService
import javax.inject.Inject

class CompanyMainRepositoryImpl @Inject constructor(
    private val service: CompanyService
): CompanyMainRepository {
}