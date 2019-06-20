package com.example.memorygame.memorygame

import com.example.memorygame.memorygame.engine.MoveRequest
import com.example.memorygame.memorygame.engine.MoveResult
import io.reactivex.Single

interface GameEngine {

    fun compareCards(
        moveRequest: MoveRequest
    ): Single<MoveResult>
}