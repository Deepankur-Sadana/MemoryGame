package com.example.memorygame.memorygame.gametimer

interface TimerListener {

    fun onTick(millisUntilFinished: Long)
    fun onFinish()

}