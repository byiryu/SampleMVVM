package com.byiryu.templatemvvm.di

import com.byiryu.templatemvvm.ui.main.MainViewModel

import com.byiryu.templatemvvm.ui.main.fragment.a.AViewModel
import com.byiryu.templatemvvm.ui.main.fragment.b.BViewModel
import com.byiryu.templatemvvm.ui.main.fragment.c.CViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel {
        MainViewModel()
    }
    viewModel {
        AViewModel()
    }
    viewModel { BViewModel(get(), get()) }

    viewModel { CViewModel() }
}