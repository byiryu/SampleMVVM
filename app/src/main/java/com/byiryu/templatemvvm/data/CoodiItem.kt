package com.byiryu.templatemvvm.data

data class CoodiItem(
    var id : Int,
    var title : String? = null,
    var color : Int
){
    override fun toString(): String {
        return "CoodiItem(id=$id, title=$title, color=$color)"
    }
}

