package com.byiryu.templatemvvm.ui.main.fragment.b

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.byiryu.templatemvvm.R

import com.byiryu.templatemvvm.databinding.FragmentBBinding
import com.byiryu.templatemvvm.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BFragment : BaseFragment<FragmentBBinding, BViewModel>(){
    override val layoutRes: Int
        get() = R.layout.fragment_b
    override val viewModel: BViewModel by viewModel()

    private val adapter : BAdapter by inject()


    override fun init() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.loadData()

        setAdapter()
    }

    private fun setAdapter(){
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance(title: String): Fragment {
            val fragment = BFragment()
            val args = Bundle()
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }}


}