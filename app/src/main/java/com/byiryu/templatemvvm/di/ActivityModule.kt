package com.byiryu.templatemvvm.di

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.byiryu.templatemvvm.ui.main.MainAdapter
import com.byiryu.templatemvvm.ui.main.fragment.b.BAdapter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

var activityModule = module {
    factory {
        Glide.with(androidContext())
    }

    factory {
        RequestOptions()
    }

    factory {
        BAdapter(get(), get(), get() )
    }


    factory {
        MainAdapter(get())
    }
}