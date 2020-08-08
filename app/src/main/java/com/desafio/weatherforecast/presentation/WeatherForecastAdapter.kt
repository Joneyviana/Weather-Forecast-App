package com.desafio.weatherforecast.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        var view = holder.view
        setTempInfo(view,day_forecast)
        setWeatherInfo(view,day_forecast)
        view.date_format.text = day_forecast.getFormatDate()
        view.city.text = "Campos dos Goytacazes"
    }

    fun setTempInfo(view:View,daily: Daily){
        var temp = daily.temp
        view.temp_min.text = temp.getMin()
        view.temp_day.text = temp.getDay()
        view.temp_max.text = temp.getMax()
    }

    fun setWeatherInfo(view:View,daily: Daily){
        var weather = daily.weather[0]
        view.weatherMain.text = weather.main
        view.weatherDescription.text = weather.description
        setWeatherIcon(view,weather)
    }

    fun setWeatherIcon(view:View,weather: Weather){
        Glide
            .with(view.context)
            .load(weather.getIconUrl())
            .centerCrop()
            .placeholder(R.drawable.ic_placeholder_foreground)
            .into(view.weatherIcon);
    }
    override fun getItemCount() = daily.size
}
