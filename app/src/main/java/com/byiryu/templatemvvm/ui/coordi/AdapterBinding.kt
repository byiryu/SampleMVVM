package com.byiryu.templatemvvm.ui.coordi

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.byiryu.templatemvvm.data.Contents
import com.byiryu.templatemvvm.data.CoodiItem


@BindingAdapter(value = ["app:Items", "app:viewModel"])
fun setItem(recyclerView: RecyclerView, items : List<CoodiItem>, viewModel : CoordiViewModel){
    val adapter = (recyclerView.adapter as CoordiAdapter)
    adapter.submitList(items)
    adapter.setViewModel(viewModel)
}