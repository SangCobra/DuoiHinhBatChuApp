package com.sang.duoihunhbatchu.presentation.viewmodel

import android.widget.FrameLayout
import androidx.lifecycle.ViewModel
import com.sang.duoihunhbatchu.domain.AnswerManager
import kotlin.random.Random

class PlayViewModel : ViewModel() {
        private var answerManager:AnswerManager = AnswerManager()
        public lateinit var trueAnswer: String
        private var drawableID: Int = 0
        public var userAnswer: String = ""
        private lateinit var disorderString: String
        private lateinit var numberArray: ArrayList<Int>
        private var turn: Int = 5
        private var coin: Int = 0

   public fun createAnswer(){
        val random = Random
        var randomValue = random.nextInt(20)
        val answer = answerManager.answers.get(randomValue)
        trueAnswer = answer.getTrueAnswer()
        drawableID = answer.getDrawableID()
    }

    public fun getDrawableID(): Int{
        return drawableID
    }

    public fun createUserAnswer(str: String?){
            userAnswer += str
    }
    public fun isWin():Boolean{
        val str = userAnswer.toLowerCase()
        if(str.equals(trueAnswer)) {
            return true
        }

        return false
    }

    public fun isFail(): Boolean{
        if (userAnswer.length == trueAnswer.length && !isWin()){
            return true
        }
        return false
    }

    public fun refreshUserAnswer(){
        userAnswer = ""
    }

    public fun createDisorderString():ArrayList<String>{
        numberArray = ArrayList()
        var strArray:ArrayList<String> = ArrayList()
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        strArray.add("a")
        var random = Random
        val answerUp = trueAnswer.toUpperCase()


        for (i in 0..15){
                var randomValue = 0
            do {
                randomValue = random.nextInt(16)
            }while (isDuplicated(randomValue))

            if(i < answerUp.length){
                println(answerUp.get(i) + "")
                strArray.set(randomValue, answerUp.get(i) + "")

            }else{
                strArray.set(randomValue, getRandomCh() + "")
            }

        }

        return strArray
    }

    private fun isDuplicated(number: Int):Boolean{
        if(numberArray.contains(number)){
            return true
        }else{
            numberArray.add(number)
            return false
        }
    }

    private fun getRandomCh():Char{
        val str = "ABCDEFGHIKNMUOPVQWZX"
        val r = Random

        return str.get(r.nextInt(str.length-1))
    }

    public fun refreshTurn(){
        turn = 5
    }

    public fun addCoin(){
        coin += 100
    }

    public fun decreateTurn(){
        turn -= 1
    }

    public fun getCoin():Int{
        return coin
    }

    public fun getTurn(): Int{
        return turn
    }
}
