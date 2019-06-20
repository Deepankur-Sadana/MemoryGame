package com.example.memorygame.game.ui

import com.example.memorygame.game.GameModel
import com.example.memorygame.game.model.GameState

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