package com.example.memorygame.game

import com.example.memorygame.game.engine.MoveRequest

sealed class GameEffect

class GetResultEffect(
    val moveRequest: MoveRequest
) : GameEffect()
