package com.example.companymain.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.companymain.data.CompanyMainRepository
import com.example.core.utils.Resource
import com.example.core_api.dto.CompanyDetailDTO
import com.example.core_api.dto.CompanyDtoList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import javax.inject.Inject
import kotlin.Exception

class CompanyMainFragmentViewModel @Inject constructor(
    private val repository: CompanyMainRepository
) : ViewModel() {

    private val _getMainInfo: MutableLiveData<Resource<CompanyDtoList>> = MutableLiveData()

    val getMainInfo: LiveData<Resource<CompanyDtoList>> = _getMainInfo




    fun getInfoCompany() {
        _getMainInfo.postValue(Resource.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getCompanyInfo()
                if (response.isSuccessful) {
                    response.body()?.let { resultResponse ->
                        withContext(Dispatchers.Main) {
                            _getMainInfo.postValue(Resource.Success(resultResponse))
                        }
                    }
                } else {
                    _getMainInfo.postValue(Resource.Error(response.message()))
                }
            } catch (e: Exception) {
                when (e) {
                    is UnknownHostException -> _getMainInfo.postValue(Resource.Error("No internet connection:("))
                }
            }
        }

    }


}