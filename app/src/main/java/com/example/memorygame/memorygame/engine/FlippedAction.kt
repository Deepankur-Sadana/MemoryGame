package com.example.memorygame.memorygame.engine

import com.example.memorygame.memorygame.model.CardState

data class FlipAction(
    val cardState: CardState,
    val cardUid: Int
)