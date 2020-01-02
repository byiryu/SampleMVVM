package com.byiryu.templatemvvm.ui.main.fragment.b

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.byiryu.templatemvvm.api.ApiService
import com.byiryu.templatemvvm.api.OnResultListener
import com.byiryu.templatemvvm.api.call
import com.byiryu.templatemvvm.data.Contents
import com.byiryu.templatemvvm.data.Res
import com.byiryu.templatemvvm.ui.base.BaseViewModel
import pyxis.uzuki.live.nyancat.NyanCat
import retrofit2.Call
import retrofit2.Response
import java.util.*


class BViewModel constructor(private var context: Context, private var apiService: ApiService) : BaseViewModel(){

    private val _items = MutableLiveData<List<Contents>>().apply { value = Collections.emptyList() }
    val items : LiveData<List<Contents>> = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading : LiveData<Boolean> = _dataLoading

    init {
        loadData()
    }

    private fun loadData(){
        _dataLoading.value = true

        var call : Call<Res<Contents>> = apiService.getContents()

        call.call(true, context, object : OnResultListener<Res<Contents>> {
            override fun onResult(
                isResult: Boolean,
                call: Call<Res<Contents>>?,
                response: Response<Res<Contents>>?,
                data: Res<Contents>?
            ) {
                if(!isResult) {
                    _items.value = Collections.emptyList()
                    return
                }else{
                    if (data != null){
                        _items.value = data.body
                        NyanCat.e(items.value.toString())
                        _dataLoading.value = false
                    }
                }
            }
        })
    }

}