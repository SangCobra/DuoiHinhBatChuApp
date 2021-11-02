package com.sang.duoihunhbatchu.domain

import com.sang.duoihunhbatchu.R

public class AnswerManager {
     lateinit var answers:ArrayList<Answer>

     constructor() {
          this.answers = ArrayList()

          answers.add(Answer("xedapdien", R.drawable.xedapdien))
          answers.add(Answer("xaphong", R.drawable.xaphong))
          answers.add(Answer("xakep", R.drawable.xakep))
          answers.add(Answer("vuonbachthu", R.drawable.vuonbachthu))
          answers.add(Answer("vuaphaluoi", R.drawable.vuaphaluoi))
          answers.add(Answer("tranhthu", R.drawable.tranhthu))
          answers.add(Answer("xaphong", R.drawable.xaphong))
          answers.add(Answer("baocao",R.drawable.baocao))
          answers.add(Answer("canthiep",R.drawable.canthiep))
          answers.add(Answer("cattuong",R.drawable.cattuong))
          answers.add(Answer("chieutre",R.drawable.chieutre))
          answers.add(Answer("danhlua",R.drawable.danhlua))
          answers.add(Answer("danong",R.drawable.danong))
          answers.add(Answer("giandiep",R.drawable.giandiep))
          answers.add(Answer("giangmai",R.drawable.giangmai))
          answers.add(Answer("hongtam",R.drawable.hongtam))
          answers.add(Answer("khoailang",R.drawable.khoailang))
          answers.add(Answer("kiemchuyen",R.drawable.kiemchuyen))
          answers.add(Answer("lancan",R.drawable.lancan))
     }


}