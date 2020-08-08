package com.desafio.weatherforecast.data.models

import com.desafio.weatherforecast.utils.getDate


data class Daily (
	val dt : Int,
	val sunrise : Int,
	val sunset : Int,
	val temp : Temp,
	val pressure : Int,
	val weather : List<Weather>
){
	fun getFormatDate():String{
		return getDate(dt*1000.toLong(),"dd MMMM yyyy")
	}
}