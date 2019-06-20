package com.example.memorygame.game

import com.example.memorygame.game.engine.MoveRequest
import com.example.memorygame.game.engine.MoveResult
import io.reactivex.Single

interface GameEngine {

    fun compareCards(
        moveRequest: MoveRequest
    ): Single<MoveResult>
}