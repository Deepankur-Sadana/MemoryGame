package com.example.memorygame.memorygame.engine

import com.example.memorygame.memorygame.model.Points

data class MoveResult(
    val gameResult: GameResult,
    val finalPoints: Points,
    val flips: List<FlipAction>?,
    val level: Int,
    val visibleCardID: Int?
)