package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("15m")
    var last15m : Float,
    var last: Float,
    var buy: Float,
    var sell: Float,
    var symbol: String
)

data class BTC(
    @SerializedName("EUR")
    val eurPrice: Price
)



