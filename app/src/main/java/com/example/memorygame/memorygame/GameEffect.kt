package com.example.memorygame.memorygame

import com.example.memorygame.memorygame.engine.MoveRequest

sealed class GameEffect

class GetResultEffect(
    val moveRequest: MoveRequest
) : GameEffect()
