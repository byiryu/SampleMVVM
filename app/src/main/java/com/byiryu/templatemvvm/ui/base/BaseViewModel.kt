package com.byiryu.templatemvvm.ui.base
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel: ViewModel(){

    private val disposable : CompositeDisposable = CompositeDisposable()

    fun addToDisposable(disposable: CompositeDisposable){
        this.disposable.add(disposable)
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}