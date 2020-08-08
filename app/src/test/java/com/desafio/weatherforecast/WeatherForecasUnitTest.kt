package com.desafio.weatherforecast

import android.os.Build
import com.desafio.weatherforecast.data.models.Daily
import com.desafio.weatherforecast.data.models.Temp
import com.desafio.weatherforecast.data.models.Weather
import com.desafio.weatherforecast.presentation.WeatherForecastActivity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class WeatherForecasUnitTest{
    private var activity: WeatherForecastActivity? = null

    private var daily_forecast:MutableList<Daily> = mutableListOf()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        daily_forecast.add(Daily(256777689,34455,46656,
            Temp(23.78,35.78,38.50,46.45,57.8,78.90),66,
            mutableListOf(Weather(433,"Rain","Rain","01n"))))
        daily_forecast.add(Daily(21678897,34455,46656,
            Temp(21.78,35.78,18.50,20.45,57.8,53.90),22,
            mutableListOf(Weather(43,"Rain","Rain","01n"))))
        activity = Robolectric.buildActivity(WeatherForecastActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun listForecast() {
        assertNotNull(activity)
        activity?.setWeatherForecastAdapter(daily_forecast)
        assertEquals(activity?.weatherForecastAdapter?.itemCount,2)
    }
}
