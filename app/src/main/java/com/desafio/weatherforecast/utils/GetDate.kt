package com.desafio.weatherforecast.utils

import java.text.SimpleDateFormat
import java.util.*

fun getDate(milliSeconds:Long,dateFormat:String):String
{
    var formatter = SimpleDateFormat(dateFormat);
    var calendar:Calendar = Calendar.getInstance();
    calendar.timeInMillis = milliSeconds;
    return formatter.format(calendar.time);
}
