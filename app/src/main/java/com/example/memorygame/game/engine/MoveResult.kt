package com.example.memorygame.game.engine

import com.example.memorygame.game.model.Points

data class MoveResult(
    val gameResult: GameResult,
    val finalPoints: Points,
    val flips: List<FlipAction>?,
    val level: Int,
    val visibleCardID: Int?
)