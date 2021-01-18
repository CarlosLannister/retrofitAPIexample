package com.example.retrofit.api

import com.example.retrofit.util.Constants.Companion.BASE_URL
import com.example.retrofit.util.Constants.Companion.BTC_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // lazy read-only property
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BTC_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ExampleAPI by lazy {
        retrofit.create(ExampleAPI::class.java)
    }

}