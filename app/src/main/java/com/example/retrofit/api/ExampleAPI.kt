package com.example.retrofit.api

import com.example.retrofit.model.BTC
import retrofit2.Response
import retrofit2.http.GET

interface ExampleAPI {

    // suspend means coroutine can be suspended for later execution
    @GET("ticker")
    suspend fun getPrice(): Response<BTC>

}