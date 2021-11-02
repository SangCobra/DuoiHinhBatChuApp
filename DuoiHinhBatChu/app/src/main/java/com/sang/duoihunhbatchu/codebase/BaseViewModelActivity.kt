package com.sang.duoihunhbatchu.codebase

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseViewModelActivity<VB : ViewBinding, VM: ViewModel> : BaseActivity<VB>() {
    protected lateinit var viewModel : VM

    override fun onPostOnCreate() {
        viewModel = createViewModel()
    }

    protected abstract fun createViewModel() : VM

}