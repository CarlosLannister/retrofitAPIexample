package com.example.retrofit.api

import com.example.retrofit.util.Constants.Companion.BTC_URL
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    // lazy read-only property
    private val retrofit by lazy {
        val httpBuilder = OkHttpClient.Builder()
        val certificatePinner = CertificatePinner.Builder()
                .add("blockchain.info", "sha256/Z87j23nY+/WSTtsgE/O4ZcDVhevBohFPgPMU6rV2iSw=")
                .build()

        val okHttpClient : OkHttpClient = httpBuilder
                .certificatePinner(certificatePinner)
                .build()

        Retrofit.Builder()
                .baseUrl(BTC_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient )
                .build()
    }

    val api: ExampleAPI by lazy {
        retrofit.create(ExampleAPI::class.java)
    }

}