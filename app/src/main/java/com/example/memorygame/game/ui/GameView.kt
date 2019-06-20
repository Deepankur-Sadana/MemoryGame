package com.example.memorygame.game.ui

import com.example.memorygame.game.model.Card

interface GameView {

    fun renderStartGame()
    fun renderTiles(
        cardList: List<Card>,
        currentPoints: Int,
        timeLeft: Int
    )
}