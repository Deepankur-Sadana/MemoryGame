package com.example.memorygame.memorygame.engine

import com.example.memorygame.memorygame.model.Card
import com.example.memorygame.memorygame.model.Points

data class MoveRequest(
    val pointsSoFar: Points,
    val level: Int,
    val movedCard: Card,
    val visibleCard: Card?
)