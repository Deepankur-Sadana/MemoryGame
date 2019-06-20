package com.example.memorygame.game.timer

interface TimerListener {

    fun onTick(millisUntilFinished: Long)
    fun onFinish()

}