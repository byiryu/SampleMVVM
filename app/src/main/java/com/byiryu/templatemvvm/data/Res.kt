package com.byiryu.templatemvvm.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Res<T>(
        @field:SerializedName("body")
        var body: List<T>?,
        @field:SerializedName("statusCode")
        var statusCode : Int,
        @field:SerializedName("msg")
        var msg : String?

): Serializable{
    override fun toString(): String {
        return "Res(entity=$body, code=$statusCode, msg=$msg)"
    }
}



