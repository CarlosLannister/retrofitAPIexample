package com.example.retrofit.repository

import com.example.retrofit.api.RetrofitInstance
import com.example.retrofit.model.BTC
import retrofit2.Response

class Repository {

    suspend fun getPrice(): Response<BTC> {
        return RetrofitInstance.api.getPrice()
    }

}