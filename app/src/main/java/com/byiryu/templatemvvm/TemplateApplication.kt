package com.byiryu.templatemvvm

import android.app.Application
import com.byiryu.templatemvvm.di.activityModule
import com.byiryu.templatemvvm.di.appModule
import com.byiryu.templatemvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pyxis.uzuki.live.nyancat.NyanCatGlobal
import pyxis.uzuki.live.nyancat.config.LoggerConfig
import pyxis.uzuki.live.nyancat.config.TriggerTiming

class TemplateApplication : Application(){

    lateinit var loggerConfig: LoggerConfig

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TemplateApplication)
            modules( listOf(appModule, viewModelModule,activityModule))
        }

        loggerConfig = LoggerConfig(packageName, true, TriggerTiming.ALL)
        NyanCatGlobal.breed(loggerConfig)
    }
}