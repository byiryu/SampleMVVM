package com.byiryu.templatemvvm.ui.main

import android.content.Intent
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.viewpager2.widget.ViewPager2
import com.byiryu.templatemvvm.R
import com.byiryu.templatemvvm.databinding.ActivityMainBinding
import com.byiryu.templatemvvm.ui.base.BaseActivity
import com.byiryu.templatemvvm.ui.coordi.CoordiActivity
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.navigation.NavigationView
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

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        binding.bottomNav.setOnNavigationItemSelectedListener {item->
           when(item.itemId){
               R.id.fragment_one -> binding.viewPager.currentItem = 0
               R.id.fragment_two -> binding.viewPager.currentItem = 1
               else -> binding.viewPager.currentItem = 2
           }
            return@setOnNavigationItemSelectedListener true
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
               binding.bottomNav.menu.getItem(position).isChecked = true
            }
        })

        binding.navigationView.setNavigationItemSelectedListener { item ->
            var intent: Intent
            when(item.itemId){
                R.id.drawer_coordi -> {
                    intent = Intent(this, CoordiActivity::class.java)
                    startActivity(intent)
                }
                else -> {

                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            false
        }
        setUpAdapter()

    }

    private fun setUpAdapter(){

        adapter = MainAdapter(this)

        adapter.tabCount = 3
        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = adapter.tabCount
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            isOpen = if(isOpen) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
                true
            }else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                false
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
