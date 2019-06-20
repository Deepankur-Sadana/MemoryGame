package com.example.memorygame.memorygame.timer

interface TimerListener {

    fun onTick(millisUntilFinished: Long)
    fun onFinish()

}