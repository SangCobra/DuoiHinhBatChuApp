package com.sang.duoihunhbatchu.domain

public class Answer {
    private lateinit var trueAnswer:String
    private var drawableID: Int
    private lateinit var disorderStr: String

    constructor(trueAnswer: String, drawableID: Int) {
        this.trueAnswer = trueAnswer
        this.drawableID = drawableID
    }

    fun getTrueAnswer():String{
        return trueAnswer
    }

    fun getDrawableID():Int{
        return drawableID
    }
}