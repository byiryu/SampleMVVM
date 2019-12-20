package com.byiryu.templatemvvm.ui.main.fragment.c
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.byiryu.templatemvvm.R
import com.byiryu.templatemvvm.databinding.FragmentCBinding
import com.byiryu.templatemvvm.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CFragment : BaseFragment<FragmentCBinding, CViewModel>(){
    override val layoutRes: Int
        get() = R.layout.fragment_c
    override val viewModel: CViewModel by viewModel()


    override fun init() {
        binding.viewModel = viewModel

    }

    companion object {
        fun newInstance(title: String): Fragment {
            val fragment = CFragment()
            val args = Bundle()
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }}


}