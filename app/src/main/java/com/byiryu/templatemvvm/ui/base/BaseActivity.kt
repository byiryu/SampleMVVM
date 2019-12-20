package com.byiryu.templatemvvm.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity < T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity(), BaseFragment.CallBack{

    abstract val layoutRes : Int
    protected lateinit var binding : T
    abstract val viewModel : V

    abstract fun init()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutRes)

        init()
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }
}