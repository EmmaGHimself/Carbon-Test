package com.emmagcarbontest.restapi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient {

    fun getClient(): Retrofit {

        val httpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
        httpClient.addInterceptor { chain ->
            val original = chain.request();

            val request = original.newBuilder()
                .header("app-id", "601438f53eb3e6fd3d65936f")
                .build()


            chain.proceed(request);
        }

        val client = httpClient.build()

        return Retrofit.Builder()
            .baseUrl(CloudConfig.instance?.baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}