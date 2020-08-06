package com.desafio.weatherforecast.data.models

data class Temp (

	val day : Double,
	val min : Double,
	val max : Double,
	val night : Double,
	val eve : Double,
	val morn : Double
){
	fun getMin():String{
		return "min: ${min}ºC"
	}

	fun getDay():String{
		return "day: ${day}ºC"
	}

	fun getMax():String{
		return "max: ${max}ºC"
	}
}