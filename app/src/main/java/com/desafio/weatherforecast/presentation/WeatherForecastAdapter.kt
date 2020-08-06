package com.desafio.weatherforecast.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desafio.weatherforecast.R
import com.desafio.weatherforecast.data.models.Daily
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
        var temp = daily[position].temp
        holder.view.temp_min.text = temp.min.toString()
        holder.view.temp_day.text = temp.day.toString()
        holder.view.temp_max.text = temp.max.toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = daily.size
}
