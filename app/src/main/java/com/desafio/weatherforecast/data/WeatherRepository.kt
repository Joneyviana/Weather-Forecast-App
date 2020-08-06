package com.desafio.weatherforecast.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.desafio.weatherforecast.data.models.Forecast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {
    var weatherService:WeatherService
    var forecastResult: MutableLiveData<Forecast> = MutableLiveData()
    constructor(application: Application){
      weatherService = RetrofitConfig.getWeatherService(application)
    }

    fun forecast7Days(lat:Double,lon:Double):MutableLiveData<Forecast>{
       weatherService.forecast7Days(lat,lon).enqueue(object : Callback<Forecast> {
           override fun onFailure(call: Call<Forecast>?, t: Throwable?) {
               forecastResult.postValue(null)

           }

           override fun onResponse(call: Call<Forecast>, response: Response<Forecast>) {
               forecastResult.postValue(response.body())
           }
           
       })
       return forecastResult
    }
}