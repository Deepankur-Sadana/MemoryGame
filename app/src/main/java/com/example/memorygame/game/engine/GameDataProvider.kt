package com.example.memorygame.game.engine

import com.example.memorygame.game.model.Card

interface GameDataProvider {
    fun getCardList(currentLevel: Int): List<Card>
}