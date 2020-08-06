package com.desafio.weatherforecast.data

import com.desafio.weatherforecast.data.models.Forecast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {
    @GET("onecall?exclude=hourly,minutely,current&units=metric")
    fun forecast7Days(@Query("lat") lat:Double, @Query("lon") lon:Double): Call<Forecast>
}