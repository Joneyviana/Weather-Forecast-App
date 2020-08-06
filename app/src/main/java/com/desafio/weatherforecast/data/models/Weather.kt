package com.desafio.weatherforecast.data.models

data class Weather (

	val id : Int,
	val main : String,
	val description : String,
	val icon : String
){
	fun getIconUrl():String{
		return "https://openweathermap.org/img/wn/${icon}@2x.png"
	}
}