package com.byiryu.templatemvvm.di

import com.byiryu.templatemvvm.api.ApiService
import com.byiryu.templatemvvm.utils.API_BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

var appModule = module {

    single {

        Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
            .create(ApiService::class.java)
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get() as HttpLoggingInterceptor)
            .readTimeout(20000, TimeUnit.MILLISECONDS)
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }


    single {
        GsonBuilder().serializeSpecialFloatingPointValues()
            .serializeNulls()
            .create()
    }


}

