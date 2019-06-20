package com.example.memorygame.memorygame.ui

import com.example.memorygame.memorygame.model.Card

interface GameView {

    fun renderStartGame()
    fun renderTiles(
        cardList: List<Card>,
        currentPoints: Int,
        timeLeft: Int
    )
}