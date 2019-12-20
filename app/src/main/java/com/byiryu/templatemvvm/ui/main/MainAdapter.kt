package com.byiryu.templatemvvm.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.byiryu.templatemvvm.ui.main.fragment.a.AFragment
import com.byiryu.templatemvvm.ui.main.fragment.b.BFragment
import com.byiryu.templatemvvm.ui.main.fragment.c.CFragment

class MainAdapter(fragmentActivity: FragmentActivity ) : FragmentStateAdapter(fragmentActivity) {

    var tabCount = 0

    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AFragment.newInstance("A")
            1 -> BFragment.newInstance("B")
            else -> CFragment.newInstance("C")
        }
    }
}