package com.example.memorygame.game.engine

import com.example.memorygame.game.model.Card
import com.example.memorygame.game.model.Points

data class MoveRequest(
    val pointsSoFar: Points,
    val level: Int,
    val movedCard: Card,
    val visibleCard: Card?,
    val timeRemaining: Int
)