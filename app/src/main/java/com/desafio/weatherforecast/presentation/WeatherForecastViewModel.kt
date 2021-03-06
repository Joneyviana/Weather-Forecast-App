package com.desafio.weatherforecast.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.desafio.weatherforecast.data.WeatherRepository
import com.desafio.weatherforecast.data.models.Forecast

class WeatherForecastViewModel : AndroidViewModel {
    var forecastLiveData: MutableLiveData<Forecast>? = null
    var weatherRepository: WeatherRepository

    constructor(application: Application) : super(application) {
        weatherRepository = WeatherRepository(application)
    }

    fun getForeCast(lat: Double, long: Double): MutableLiveData<Forecast> {
        if (forecastLiveData == null)
            forecastLiveData = weatherRepository.forecast7Days(lat, long)
        return forecastLiveData!!
    }
}