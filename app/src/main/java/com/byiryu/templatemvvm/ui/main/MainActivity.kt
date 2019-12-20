package com.byiryu.templatemvvm.ui.main

import androidx.core.view.GravityCompat
import androidx.viewpager2.widget.ViewPager2
import com.byiryu.templatemvvm.R
import com.byiryu.templatemvvm.databinding.ActivityMainBinding
import com.byiryu.templatemvvm.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    lateinit var adapter: MainAdapter

    private var isOpen = false



    override fun init() {

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.bottomNav.setOnNavigationItemSelectedListener {item->
           when(item.itemId){
               R.id.action_one -> binding.viewPager.currentItem = 0
               R.id.action_two -> binding.viewPager.currentItem = 1
               else -> binding.viewPager.currentItem = 2
           }
            return@setOnNavigationItemSelectedListener true
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
               binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })

        binding.btnDrawer.setOnClickListener {
            isOpen = if(isOpen) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
                true
            }else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                false
            }

        }

        setUpAdapter()

    }

    private fun setUpAdapter(){

        adapter = MainAdapter(this)

        adapter.tabCount = 3
        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = adapter.tabCount
    }


//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//
//        binding.drawerLayout.closeDrawer(GravityCompat.START)
//        return false
//    }

}
