package com.desafio.weatherforecast.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.desafio.weatherforecast.R

class WeatherForecastActivity : AppCompatActivity() {
    private var weatherForecastViewModel: WeatherForecastViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_forecast)
        weatherForecastViewModel = ViewModelProvider(this)
            .get(WeatherForecastViewModel::class.java)
        weatherForecastViewModel?.getForeCast(22.3354, 76.4545)?.observe(this,
            Observer {
                Log.i("teste",it.daily.toString())
            })
    }
}