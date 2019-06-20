package com.example.memorygame.game.gametimer

interface TimerListener {

    fun onTick(millisUntilFinished: Long)
    fun onFinish()

}