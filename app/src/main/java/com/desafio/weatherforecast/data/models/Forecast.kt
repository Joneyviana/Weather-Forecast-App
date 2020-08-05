package com.desafio.weatherforecast.data.models


data class Forecast (

	val lat : Double,
	val lon : Double,
	val timezone : String,
	val timezone_offset : Int,
	val daily : List<Daily>
)