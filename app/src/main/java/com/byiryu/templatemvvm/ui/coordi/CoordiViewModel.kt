package com.byiryu.templatemvvm.ui.coordi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.byiryu.templatemvvm.data.Contents
import com.byiryu.templatemvvm.data.CoodiItem
import com.byiryu.templatemvvm.data.getColor
import com.byiryu.templatemvvm.ui.base.BaseViewHolder
import com.byiryu.templatemvvm.ui.base.BaseViewModel
import pyxis.uzuki.live.nyancat.NyanCat
import java.util.*
import kotlin.collections.ArrayList

class CoordiViewModel : BaseViewModel(){

    private val _items = MutableLiveData<List<CoodiItem>>().apply { value = Collections.emptyList() }
    val items : LiveData<List<CoodiItem>> = _items

    init {
        loadData()
    }

    private fun loadData(){
        var recycleritems = ArrayList<CoodiItem>()
        for (a in 0..20)
            recycleritems.add(CoodiItem(a, a.toString(), getColor() ))
        _items.value = recycleritems

    }
}