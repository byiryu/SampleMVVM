package com.byiryu.templatemvvm.ui.main.fragment.b

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.byiryu.templatemvvm.R
import com.byiryu.templatemvvm.data.Contents
import pyxis.uzuki.live.nyancat.NyanCat

class BAdapter constructor(private val viewModel : BViewModel, private var requestManager: RequestManager, private var requestOptions: RequestOptions)
    :ListAdapter<Contents, BHolder>(Callback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BHolder {
        return BHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_b_item,parent,false
            ), requestManager, requestOptions
        )
    }

    override fun onBindViewHolder(holder: BHolder, position: Int) {
        var item = getItem(position)
        NyanCat.e(item.toString())
        holder.onBind(viewModel, item )
    }

}

class Callback : DiffUtil.ItemCallback<Contents>(){
    override fun areItemsTheSame(oldItem: Contents, newItem: Contents): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contents, newItem: Contents): Boolean {
        return oldItem == newItem
    }


}