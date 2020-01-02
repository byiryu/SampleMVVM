package com.byiryu.templatemvvm.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import pyxis.uzuki.live.nyancat.NyanCat


abstract class BaseFragment<T : ViewDataBinding> : Fragment(){

    protected lateinit var binding : T
        private set
    abstract val layoutRes : Int

    abstract fun init()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<T>(inflater, layoutRes, container, false).apply {
            binding = this
        }.root

//        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
//        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

}