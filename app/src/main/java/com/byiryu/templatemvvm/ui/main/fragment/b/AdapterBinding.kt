package com.byiryu.templatemvvm.ui.main.fragment.b

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.byiryu.templatemvvm.data.Contents


@BindingAdapter(value = ["app:Items", "app:viewModel"])
fun setItem(recyclerView: RecyclerView, items : List<Contents>, viewModel : BViewModel){
    val adapter = (recyclerView.adapter as BAdapter)
    adapter.submitList(items)
    adapter.setViewModel(viewModel)

}

