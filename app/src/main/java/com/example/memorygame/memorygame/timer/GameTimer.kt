package com.example.memorygame.memorygame.timer

import android.os.CountDownTimer

class GameTimer(val listener: TimerListener) {
    lateinit var countDownTimer: CountDownTimer
    fun start() {
        countDownTimer = object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                listener.onTick(millisUntilFinished)
            }

            override fun onFinish() {
                listener.onFinish()
            }

        }.start()
    }

    fun stop() {
        countDownTimer.cancel()
    }
}