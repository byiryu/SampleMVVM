package com.byiryu.templatemvvm.ui.main.fragment.a

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.byiryu.templatemvvm.R
import com.byiryu.templatemvvm.databinding.FragmentABinding
import com.byiryu.templatemvvm.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import pyxis.uzuki.live.nyancat.NyanCat

class AFragment : BaseFragment<FragmentABinding>(){
    override val layoutRes: Int
        get() = R.layout.fragment_a
//    val viewModel: AViewModel by viewModel()


    override fun init() {

        binding.viewModel = getViewModel()
        binding.lifecycleOwner = this

    }

    companion object {
        fun newInstance(title: String): Fragment {
            val fragment = AFragment()
            val args = Bundle()
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }}


}