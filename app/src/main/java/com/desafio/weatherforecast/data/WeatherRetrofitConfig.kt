package com.desafio.weatherforecast.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var OPEN_WEATHER_BASE_API = "http://api.openweathermap.org/data/2.5/"

object RetrofitConfig {
    val retrofit :Retrofit
    init {
        retrofit = Retrofit.Builder()
            .baseUrl(OPEN_WEATHER_BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}