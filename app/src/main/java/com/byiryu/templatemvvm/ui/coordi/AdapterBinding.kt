package com.byiryu.templatemvvm.ui.coordi

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.byiryu.templatemvvm.data.Contents
import com.byiryu.templatemvvm.data.CoodiItem


@BindingAdapter("app:Items")
fun setItem(recyclerView: RecyclerView, items : List<CoodiItem>){
    (recyclerView.adapter as CoordiAdapter).submitList(items)
}