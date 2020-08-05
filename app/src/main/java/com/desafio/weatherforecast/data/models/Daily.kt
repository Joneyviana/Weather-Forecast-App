package com.desafio.weatherforecast.data.models


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
	val pop : Int,
	val uvi : Double
)