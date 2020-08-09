package com.desafio.weatherforecast

import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desafio.weatherforecast.data.models.Daily
import com.desafio.weatherforecast.data.models.Temp
import com.desafio.weatherforecast.data.models.Weather
import com.desafio.weatherforecast.presentation.WeatherForecastActivity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class WeatherForecasUnitTest{
    private var view: View? = null
    private var recyclerView: RecyclerView? = null
    private var activity: WeatherForecastActivity? = null

    private var daily_forecast:MutableList<Daily> = mutableListOf()

    fun addDailyList(){
        daily_forecast.add(Daily(256777689,34455,46656,
            Temp(23.78,21.78,38.50,46.45,57.8,78.90),66,
            mutableListOf(Weather(433,"Rain","Rain","01n"))))
        daily_forecast.add(Daily(21678897,34455,46656,
            Temp(21.78,35.78,18.50,20.45,57.8,53.90),22,
            mutableListOf(Weather(43,"Rain","Rain","01n"))))
    }

    @Before
    @Throws(Exception::class)
    fun setUp() {
        addDailyList()
        activity = Robolectric.buildActivity(WeatherForecastActivity::class.java)
            .create()
            .resume()
            .get()
        recyclerView = activity!!.findViewById(R.id.forecast_recyclerview)
    }

    fun checkTemp(expectedText:String,idView:Int){
        assertEquals(expectedText,view?.findViewById<TextView>(idView)?.text)
    }

    @Test
    fun listForecast() {
        assertNotNull(activity)
        activity?.setWeatherForecastAdapter(daily_forecast)
        recyclerView?.measure(0,0)
        recyclerView?.layout(0,0,100,1000)
        view = recyclerView?.layoutManager?.findViewByPosition(0)!!
        verifyForecast()
        assertEquals(2,activity?.weatherForecastAdapter?.itemCount)
    }

    fun verifyForecast(){
        checkTemp("max: 38.5ºC",R.id.temp_max)
        checkTemp("min: 21.78ºC",R.id.temp_min)
        checkTemp("day: 23.78ºC",R.id.temp_day)
    }
}
