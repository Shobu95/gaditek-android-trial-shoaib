package com.example.gaditek_android_trial_shoaib.data.remote.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    val retrofit: Retrofit by lazy {
        val BASE_URL = "https://apps-ivacy.s3.amazonaws.com/staging/"

        val logger = HttpLoggingInterceptor()
        logger.level = Level.BASIC

        val loggerClient = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        Retrofit.Builder()
            .client(loggerClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}