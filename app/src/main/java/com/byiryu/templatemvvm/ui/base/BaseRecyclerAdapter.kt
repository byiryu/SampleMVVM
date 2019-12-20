package com.byiryu.templatemvvm.ui.base

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, VH : RecyclerView.ViewHolder?> constructor(callback: Callback<T>): ListAdapter<T, VH>(callback)
abstract class Callback<T> : DiffUtil.ItemCallback<T>()