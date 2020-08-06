package com.desafio.weatherforecast.data.models

import com.desafio.weatherforecast.utils.getDate


data class Daily (

	val dt : Int,
	val sunrise : Int,
	val sunset : Int,
	val temp : Temp,
	val feels_like : Feels_like,
	val pressure : Int,
	val humidity : Int,
	val dew_point : Double,
	val wind_speed : Double,
	val wind_deg : Int,
	val weather : List<Weather>,
	val clouds : Int,
	val pop : Double,
	val uvi : Double
){
	fun getFormatDate():String{
		return getDate(dt*1000.toLong(),"dd MMMM yyyy")
	}
}