package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.BTC
import com.example.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<BTC>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPrice()
            myResponse.value = response
        }
    }
}