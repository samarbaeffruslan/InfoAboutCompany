package com.example.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.utils.Resource
import com.example.core_api.dto.CompanyDetailDTO
import com.example.core_api.dto.CompanyDetailDtoList
import com.example.detail.data.DetailRepository
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

class DetailFragmentViewModel @Inject constructor(
    private val repository: DetailRepository
) : ViewModel() {

    private val _getDetailInfo: MutableLiveData<Resource<CompanyDetailDtoList>> = MutableLiveData()

    val getDetailInfo: LiveData<Resource<CompanyDetailDtoList>> = _getDetailInfo

    fun getDetailInfoCompany(id: Long){
        _getDetailInfo.postValue(Resource.Loading())
        viewModelScope.launch {
            try {
                val response = repository.getDetailInfo(id)
                if(response.isSuccessful){
                    response.body()?.let {
                        _getDetailInfo.postValue(Resource.Success(it))
                    }
                } else {
                    _getDetailInfo.postValue(Resource.Error(response.message()))
                }
            } catch (e: Exception){
                when(e){
                    is UnknownHostException -> _getDetailInfo.postValue(Resource.Error("No internet connection:("))
                }
            }
        }
    }
}