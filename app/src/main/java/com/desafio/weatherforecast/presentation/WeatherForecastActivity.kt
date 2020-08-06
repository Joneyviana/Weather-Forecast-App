package com.desafio.weatherforecast.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desafio.weatherforecast.R


class WeatherForecastActivity : AppCompatActivity() {
    private var weatherForecastViewModel: WeatherForecastViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_forecast)
        weatherForecastViewModel = ViewModelProvider(this)
            .get(WeatherForecastViewModel::class.java)
        weatherForecastViewModel?.getForeCast(21.7627, -41.3244)?.observe(this,
            Observer {
                val weatherForecastAdapter = WeatherForecastAdapter(it.daily)
                var recyclerView = findViewById<View>(R.id.forecast_recyclerview) as RecyclerView
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = weatherForecastAdapter
            })
    }
}