package com.example.memorygame.game.engine

import com.example.memorygame.game.model.CardState

data class FlipAction(
    val cardState: CardState,
    val cardUid: Int
)