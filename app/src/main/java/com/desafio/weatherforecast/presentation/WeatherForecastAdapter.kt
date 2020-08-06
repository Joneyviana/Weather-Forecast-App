package com.desafio.weatherforecast.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.desafio.weatherforecast.R
import com.desafio.weatherforecast.data.models.Daily
import com.desafio.weatherforecast.data.models.Weather
import kotlinx.android.synthetic.main.card_forecast.view.*

class WeatherForecastAdapter(private val daily: List<Daily>) :
    RecyclerView.Adapter<WeatherForecastAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): WeatherForecastAdapter.MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_forecast, parent, false)
        return MyViewHolder(textView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var day_forecast = daily[position]
        var temp = day_forecast.temp
        var weather = day_forecast.weather[0]
        var view = holder.view
        view.temp_min.text = temp.getMin()
        view.temp_day.text = temp.getDay()
        view.temp_max.text = temp.getMax()
        view.weatherDescription.text = weather.description
        view.weatherMain.text = weather.main
        view.date_format.text = day_forecast.getFormatDate()
        setWeatherIcon(view,weather)
    }

    fun setWeatherIcon(view:View,weather: Weather){
        Log.i("URL DA IMAGEM!","http://openweathermap.org/img/wn/${weather.icon}@2x.png")
        Glide
            .with(view.context)
            .load(weather.getIconUrl())
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(view.weatherIcon);
    }
    override fun getItemCount() = daily.size
}
