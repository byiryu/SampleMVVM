package com.byiryu.templatemvvm.api

import com.byiryu.templatemvvm.data.Contents
import com.byiryu.templatemvvm.data.Res
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/contents.json")
    fun getContents() : Call<Res<Contents>>
}
