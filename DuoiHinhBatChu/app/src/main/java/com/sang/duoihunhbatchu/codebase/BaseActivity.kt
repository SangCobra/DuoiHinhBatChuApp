package com.sang.duoihunhbatchu.codebase

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

 abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(), BaseView , View.OnClickListener{
     protected lateinit var binding: VB

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         onPostOnCreate()

         binding = getViewBinding()
         setContentView(binding.root)

         initializeData()
         initializeEvents()
//         initializeComponent()
//         initializeView()
     }



     protected open fun setOnClickListeners(view : View?){
         if (view != null) {
          view.setOnClickListener(this)
         }
     }

     override fun onClick(v: View?) {
         TODO("Not yet implemented")
     }

     protected abstract fun getViewBinding():VB

     protected abstract fun onPostOnCreate()

     abstract override fun initializeData()

     override abstract fun initializeComponent()


     override abstract fun initializeEvents()


     override abstract fun initializeView()




 }