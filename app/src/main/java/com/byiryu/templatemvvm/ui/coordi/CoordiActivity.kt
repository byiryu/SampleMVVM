package com.byiryu.templatemvvm.ui.coordi

import com.byiryu.templatemvvm.R
import com.byiryu.templatemvvm.databinding.ActivityCoordiBinding
import com.byiryu.templatemvvm.ui.base.BaseActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import pyxis.uzuki.live.nyancat.NyanCat

class CoordiActivity : BaseActivity<ActivityCoordiBinding>(){
    override val layoutRes: Int
        get() = R.layout.activity_coordi
    private val adapter : CoordiAdapter by inject()

    override fun init() {
        binding.viewModel = getViewModel()
        binding.lifecycleOwner = this

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        setAdapter()
    }

    private fun setAdapter(){
        binding.recyclerView.adapter = adapter
    }

}