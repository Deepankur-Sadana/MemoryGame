package com.example.memorygame.memorygame.engine

import com.example.memorygame.memorygame.model.Card

interface GameDataProvider {
    fun getCardList(currentLevel: Int): List<Card>
}