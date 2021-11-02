package com.sang.duoihunhbatchu.presentation.activity

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Layout
import android.text.PrecomputedText
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.sang.duoihunhbatchu.R
import com.sang.duoihunhbatchu.codebase.BaseViewModelActivity
import com.sang.duoihunhbatchu.databinding.ActivityGameplayBinding
import com.sang.duoihunhbatchu.domain.Answer
import com.sang.duoihunhbatchu.presentation.viewmodel.PlayViewModel
import org.w3c.dom.Text

class PlayActivity : BaseViewModelActivity<ActivityGameplayBinding, PlayViewModel>() {
    val TAG: String = "PlayActivity"
    lateinit var frameLayouts: ArrayList<FrameLayout>
    lateinit var textViews: ArrayList<TextView>
    lateinit var flPresentings: ArrayList<FrameLayout>
     var turn:Int = 0

     override fun createViewModel(): PlayViewModel {

        return ViewModelProvider(this).get()
    }

    override fun getViewBinding(): ActivityGameplayBinding {

        return ActivityGameplayBinding.inflate(layoutInflater)
    }

    override fun initializeData() {
        viewModel.createAnswer()
        binding.ivImageGame.setImageResource(viewModel.getDrawableID())
        createAnswerPresenting(viewModel.trueAnswer)

        frameLayouts = ArrayList()
        frameLayouts.add(binding.tile00)
        frameLayouts.add(binding.tile01)
        frameLayouts.add(binding.tile02)
        frameLayouts.add(binding.tile03)
        frameLayouts.add(binding.tile04)
        frameLayouts.add(binding.tile05)
        frameLayouts.add(binding.tile06)
        frameLayouts.add(binding.tile07)
        frameLayouts.add(binding.tile10)
        frameLayouts.add(binding.tile11)
        frameLayouts.add(binding.tile12)
        frameLayouts.add(binding.tile13)
        frameLayouts.add(binding.tile14)
        frameLayouts.add(binding.tile15)
        frameLayouts.add(binding.tile16)
        frameLayouts.add(binding.tile17)

        textViews = ArrayList()
        textViews.add(binding.txt00)
        textViews.add(binding.txt01)
        textViews.add(binding.txt02)
        textViews.add(binding.txt03)
        textViews.add(binding.txt04)
        textViews.add(binding.txt05)
        textViews.add(binding.txt06)
        textViews.add(binding.txt07)
        textViews.add(binding.txt10)
        textViews.add(binding.txt11)
        textViews.add(binding.txt12)
        textViews.add(binding.txt13)
        textViews.add(binding.txt14)
        textViews.add(binding.txt15)
        textViews.add(binding.txt16)
        textViews.add(binding.txt17)

        setInputTile()

        binding.txtCoin.setText(viewModel.getCoin().toString())
        binding.txtTurnNumber.setText(viewModel.getTurn().toString())
    }

    override fun initializeComponent() {
        TODO("Not yet implemented")
    }

    override fun initializeEvents() {
        for (i in 0..15){
            setOnClickListeners(frameLayouts.get(i))
        }

        setOnClickListeners(binding.btnNext)
    }

    override fun initializeView() {
        TODO("Not yet implemented")
    }

    override fun setOnClickListeners(view: View?) {
        super.setOnClickListeners(view)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if(v.id != R.id.btnNext){
                val frameLayout = getTextViewOrFrameLayout(0, v.id) as FrameLayout
                val textView = getTextViewOrFrameLayout(1, v.id) as TextView

                doAfterClick(frameLayout, textView)
            }else{
                doClickBtnNext()
            }

        }
    }

    private fun doAfterClick(frameLayout: FrameLayout, textView: TextView) {
        frameLayout.visibility = View.INVISIBLE
        viewModel.createUserAnswer(textView.text as String?)
        updateFlPresenting(textView.text as String)


        if (viewModel.isWin() || viewModel.isFail()) {
            if (viewModel.isWin()){
                binding.btnNext.visibility = View.VISIBLE
                binding.btnNext.isEnabled = true
                binding.txtReport.setText("Bạn đã tìm ra đáp án!")
                binding.txtReport.visibility = View.VISIBLE
                viewModel.addCoin()
                binding.txtCoin.setText(viewModel.getCoin().toString())
                Log.d(TAG, "doAfterClick: --------------------------------------------------------------------------dung roi")
            }
            if (viewModel.isFail()){
                Log.d(TAG, "doAfterClick:-----------------------------Sai roi")
                binding.btnNext.visibility = View.VISIBLE
                binding.btnNext.isEnabled = true
                binding.txtReport.setText("Bạn đã chon sai đáp án rồi!")
                binding.txtReport.visibility = View.VISIBLE
                viewModel.decreateTurn()
                binding.txtTurnNumber.setText(viewModel.getTurn().toString())
            }

            turnFlBackgroundWithResult(!viewModel.isFail())

        }

        Log.d(TAG, "userAnswer:-------------------------------------------------" + viewModel.userAnswer)
    }

    private fun doClickBtnNext(){
        viewModel.createAnswer()
        binding.ivImageGame.setImageResource(viewModel.getDrawableID())


        for (i in 0..15){
            frameLayouts.get(i).visibility = View.VISIBLE
        }


        binding.trPresenting.removeAllViews()
        setInputTile()
        viewModel.refreshUserAnswer()
        createAnswerPresenting(viewModel.trueAnswer)
        turn = 0
        binding.btnNext.visibility = View.INVISIBLE
        binding.btnNext.isEnabled = false
        binding.txtReport.visibility = View.INVISIBLE
    }
    private fun getTextViewOrFrameLayout(type: Int, id: Int): View {
        lateinit var view: View

        when (id) {
            R.id.tile00 -> {
                if (type == 0) {
                    view = binding.tile00
                } else {
                    view = binding.txt00
                }
            }
            R.id.tile01 -> {
                if (type == 0) {
                    view = binding.tile01
                } else {
                    view = binding.txt01
                }
            }
            R.id.tile02 -> {
                if (type == 0) {
                    view = binding.tile02
                } else {
                    view = binding.txt02
                }
            }
            R.id.tile03 -> {
                if (type == 0) {
                    view = binding.tile03
                } else {
                    view = binding.txt03
                }
            }
            R.id.tile04 -> {
                if (type == 0) {
                    view = binding.tile04
                } else {
                    view = binding.txt04
                }
            }
            R.id.tile05 -> {
                if (type == 0) {
                    view = binding.tile05
                } else {
                    view = binding.txt05
                }
            }
            R.id.tile06 -> {
                if (type == 0) {
                    view = binding.tile06
                } else {
                    view = binding.txt06

                }
            }
            R.id.tile07 -> {
                if (type == 0) {
                    view = binding.tile07
                } else {
                    view = binding.txt07
                }
            }
            R.id.tile10 -> {
                if (type == 0) {
                    view = binding.tile10
                } else {
                    view = binding.txt10
                }
            }
            R.id.tile11 -> {
                if (type == 0) {
                    view = binding.tile11
                } else {
                    view = binding.txt11
                }
            }
            R.id.tile12 -> {
                if (type == 0) {
                    view = binding.tile12
                } else {
                    view = binding.txt12
                }
            }
            R.id.tile13 -> {
                if (type == 0) {
                    view = binding.tile13
                } else {
                    view = binding.txt13
                }
            }
            R.id.tile14 -> {
                if (type == 0) {
                    view = binding.tile14
                } else {
                    view = binding.txt14
                }
            }
            R.id.tile15 -> {
                if (type == 0) {
                    view = binding.tile15
                } else {
                    view = binding.txt15
                }
            }
            R.id.tile16 -> {
                if (type == 0) {
                    view = binding.tile16
                } else {
                    view = binding.txt16
                }
            }
            R.id.tile17 -> {
                if (type == 0) {
                    view = binding.tile17
                } else {
                    view = binding.txt17
                }
            }
        }

        return view
    }

    private fun setInputTile(){
        val strArr = viewModel.createDisorderString()

        for (i in 0..15){
            textViews.get(i).setText(strArr.get(i))
        }
    }


    private fun updateFlPresenting(text:String){
        (flPresentings.get(turn).getChildAt(0) as ImageView).setImageResource(R.drawable.ic_tile_hover)
        (flPresentings.get(turn).getChildAt(1) as TextView).setText(text + "")
        turn++
    }



    private fun createAnswerPresenting(answer: String){
        flPresentings = ArrayList()
        for ( i in 0.. (answer.length - 1) ){
            val imageView = ImageView(this)
            imageView.setImageResource(R.drawable.ic_tile_gray)

            val textView = TextView(this)

            textView.setText("")
            textView.setTextSize(24F)
            textView.gravity = Gravity.CENTER

            val frameLayout = FrameLayout(this)
            frameLayout.addView(imageView)
            frameLayout.addView(textView)

            val params = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1F)
            frameLayout.layoutParams = params

            binding.trPresenting.addView(frameLayout)
            flPresentings.add(frameLayout)
        }
    }

    private fun turnFlBackgroundWithResult(result:Boolean){
        if(result){
            for(i in 0..(viewModel.trueAnswer.length - 1) ){
                (flPresentings.get(i).getChildAt(0) as ImageView).setImageResource(R.drawable.ic_tile_true)
            }
        }else{
            for(i in 0..(viewModel.trueAnswer.length - 1) ){
                (flPresentings.get(i).getChildAt(0) as ImageView).setImageResource(R.drawable.ic_tile_false)
            }
        }
    }
}