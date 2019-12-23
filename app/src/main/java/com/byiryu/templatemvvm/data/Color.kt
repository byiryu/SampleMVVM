package com.byiryu.templatemvvm.data

import android.graphics.Color
import java.util.*

@JvmOverloads
fun getColor(): Int{
    val rnd = Random()
    return Color.argb(255, rnd.nextInt(256),  rnd.nextInt(256),  rnd.nextInt(256))
}
