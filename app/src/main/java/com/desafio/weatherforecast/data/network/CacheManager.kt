package com.desafio.weatherforecast.data.network

import android.content.Context
import okhttp3.Cache

class CacheManager {
    val cacheSize = (5 * 1024 * 1024).toLong()
    var cache :Cache
    val cacheHeaderOnline = "public, max-age=" + 1000
    val cacheHeaderOffline = "public, only-if-cached, max-stale=" + 60 * 60 * 24
    constructor(context: Context){
        cache = Cache(context.cacheDir, cacheSize)
    }
}