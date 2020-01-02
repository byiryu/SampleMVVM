package com.byiryu.templatemvvm.ui.main

import com.byiryu.templatemvvm.ui.base.BaseViewModel
import pyxis.uzuki.live.nyancat.NyanCat

class MainViewModel() : BaseViewModel(){
    init {
        NyanCat.e("MainViewModel")
    }

}