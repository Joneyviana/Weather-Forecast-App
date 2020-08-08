package com.desafio.weatherforecast.presentation

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desafio.weatherforecast.R
import com.desafio.weatherforecast.data.models.Daily


class WeatherForecastActivity : AppCompatActivity() {
    private var weatherForecastViewModel: WeatherForecastViewModel? = null
    var weatherForecastAdapter:WeatherForecastAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_forecast)
        weatherForecastViewModel = ViewModelProvider(this)
            .get(WeatherForecastViewModel::class.java)

        weatherForecastViewModel?.getForeCast(-21.7627, -41.3244)?.observe(this,
            Observer {
                if(it == null){
                    showDialogError("Request Error","Couldn't return to predictions")
                }
                else {
                    setWeatherForecastAdapter(it.daily)
                }
            })
    }

    fun setWeatherForecastAdapter(daily:List<Daily>){
        weatherForecastAdapter = WeatherForecastAdapter(daily)
        var recyclerView =
            findViewById<View>(R.id.forecast_recyclerview) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = weatherForecastAdapter
    }

    fun showDialogError(title:String,message:String){
            var alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
        alertDialog.setPositiveButton(android.R.string.yes) { _,_ ->
            Toast.makeText(applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT).show()

        }
        alertDialog.show();
    }
}