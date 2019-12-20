package com.byiryu.templatemvvm.ui.main.fragment.b

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.byiryu.templatemvvm.data.Contents


@BindingAdapter("app:Items")
fun setItem(recyclerView: RecyclerView, items : List<Contents>){
    (recyclerView.adapter as BAdapter).submitList(items)
}