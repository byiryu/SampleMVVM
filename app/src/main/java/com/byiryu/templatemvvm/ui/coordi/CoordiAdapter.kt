package com.byiryu.templatemvvm.ui.coordi

import android.view.LayoutInflater
import android.view.ViewGroup
import com.byiryu.templatemvvm.R
import com.byiryu.templatemvvm.data.CoodiItem
import com.byiryu.templatemvvm.ui.base.BaseRecyclerAdapter
import com.byiryu.templatemvvm.ui.base.Callback
import pyxis.uzuki.live.nyancat.NyanCat

class CoordiAdapter :BaseRecyclerAdapter<CoodiItem, CoordiHolder>(object : Callback<CoodiItem>(){
    override fun areItemsTheSame(oldItem: CoodiItem, newItem: CoodiItem): Boolean {
        return oldItem.id == newItem.id
    }

}) {
    private lateinit var viewModel : CoordiViewModel
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordiHolder {
        return CoordiHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_coordi_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CoordiHolder, position: Int) {
        var item = getItem(position)
        NyanCat.e(item.toString())
        holder.onBind(viewModel, item)
    }

    fun setViewModel(viewModel : CoordiViewModel){
        this.viewModel = viewModel
    }
}