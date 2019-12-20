package com.byiryu.templatemvvm.data

data class Contents(
    var id : Int = -1,
    var title : String? = null,
    var url : String? = null,
    var desc : String? = null
){

    override fun toString(): String {
        return "Contents(title=$title, url=$url, desc='$desc')"
    }
}

