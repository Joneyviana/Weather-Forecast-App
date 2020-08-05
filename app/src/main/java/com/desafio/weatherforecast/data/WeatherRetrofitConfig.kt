package com.desafio.weatherforecast.data

import android.content.Context
import com.desafio.weatherforecast.data.network.hasNetwork
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var OPEN_WEATHER_BASE_API = "http://api.openweathermap.org/data/2.5/"


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

    private fun getOkHttpClient(context:Context):OkHttpClient{
        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir, cacheSize)
        return OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (hasNetwork(context)!!)
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                chain.proceed(request)
            }
            .build()
    }
}