package com.byiryu.templatemvvm.ui.coordi

import android.view.View
import com.byiryu.templatemvvm.data.CoodiItem
import com.byiryu.templatemvvm.databinding.ViewCoordiItemBinding
import com.byiryu.templatemvvm.ui.base.BaseViewHolder

class CoordiHolder constructor(itemView : View) : BaseViewHolder<ViewCoordiItemBinding>(itemView){


    fun onBind(viewModel : CoordiViewModel, item : CoodiItem){
        binding.viewModel = viewModel
        binding.textView.text = item.title
        binding.textView.setBackgroundColor(item.color)
    }
}