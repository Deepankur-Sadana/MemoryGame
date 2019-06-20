package com.example.memorygame.memorygame.ui

import com.example.memorygame.memorygame.GameModel
import com.example.memorygame.memorygame.model.GameState

class GameViewRenderer(
    private val gameView: GameView
) {

    fun render(model: GameModel) {
        when {
            model.gameState == GameState.STOPPED -> {
                gameView.renderStartGame()
            }

            model.gameState == GameState.TICKING -> {
                gameView.renderTiles(model.cardList, model.currentPoints.points, model.timeLeft)
            }
        }
    }
}