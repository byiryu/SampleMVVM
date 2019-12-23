package com.byiryu.templatemvvm.ui.main.fragment.b

import android.view.View
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.byiryu.templatemvvm.data.Contents
import com.byiryu.templatemvvm.databinding.ViewBItemBinding
import com.byiryu.templatemvvm.ui.base.BaseViewHolder

class BHolder constructor(itemView : View, var requestManager: RequestManager, var requestOptions: RequestOptions): BaseViewHolder<ViewBItemBinding>(itemView){


    fun onBind(viewModel : BViewModel, contents :Contents){
        binding.viewModel = viewModel
        binding.title.text = contents.title
        binding.desc.text = contents.desc

        requestManager.load(contents.url)
            .apply( requestOptions.transform(
                CenterCrop(),
                RoundedCorners(25)
            ))
            .into(binding.imageURL)

//        binding.executePendingBindings()
    }
}