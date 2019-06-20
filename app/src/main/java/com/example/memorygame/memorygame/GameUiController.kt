package com.example.memorygame.memorygame

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import com.example.memorygame.architechture.mobius.DeferredEventSource
import com.example.memorygame.memorygame.timer.GameTimer
import com.example.memorygame.memorygame.timer.TimerListener

class GameUiController(val eventSource: DeferredEventSource<GameEvent>) {
    var gameTimer: GameTimer? = null
    fun notifyGameStarted() {
        if (gameTimer != null) {
            gameTimer?.stop()
        }

        gameTimer = GameTimer(object : TimerListener {
            override fun onTick(millisUntilFinished: Long) {
                System.out.println("TimerToEventMapper $millisUntilFinished")
                eventSource.notifyEvent(TimerTickedEvent(millisUntilFinished))
            }

            override fun onFinish() {
                System.out.println("TimerToEventMapper onFinish")
                eventSource.notifyEvent(TimerUpEvent)
            }
        })

        gameTimer?.start()
    }


    fun getLayoutManager(context: Context): GridLayoutManager {
        return GridLayoutManager(context,3)
    }
}