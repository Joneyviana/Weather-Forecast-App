package com.desafio.weatherforecast.data

import android.app.Application
import android.content.Context
import com.desafio.weatherforecast.data.network.CacheManager
import com.desafio.weatherforecast.data.network.hasNetwork
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


var OPEN_WEATHER_BASE_API = "https://api.openweathermap.org/data/2.5/"
var WEATHER_API = "c1b96a3e9b454d188ae398b3184aa0f8"
object RetrofitConfig {
    var retrofit :Retrofit? = null
    fun getRetrofit(context: Context):Retrofit{
        if(retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(OPEN_WEATHER_BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient(context))
                .build()
        }
        return retrofit!!
    }

    fun getWeatherService(application: Application):WeatherService{
        return getRetrofit(application).create(WeatherService::class.java)
    }

    private fun getHttpWithApiKey(request: Request):HttpUrl{
        val originalHttpUrl: HttpUrl = request.url()
        return originalHttpUrl.newBuilder()
            .addQueryParameter("appid", WEATHER_API)
            .build()
    }
    private fun getOkHttpClient(context:Context):OkHttpClient{
        var cacheManager = CacheManager(context)
        return OkHttpClient.Builder()
            .cache(cacheManager.cache)
            .addInterceptor { chain ->
                var request = chain.request()
                var url = getHttpWithApiKey(request)
                request = if (hasNetwork(context)!!)
                    request.newBuilder().header("Cache-Control",cacheManager.cacheHeaderOnline)
                        .url(url).build()
                else
                    request.newBuilder().header("Cache-Control",cacheManager.cacheHeaderOffline )
                        .url(url).build()
                chain.proceed(request)
            }
            .build()
    }
}