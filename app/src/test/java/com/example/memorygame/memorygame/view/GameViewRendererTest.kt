package com.example.memorygame.memorygame.view

import com.example.memorygame.memorygame.GameModel
import com.example.memorygame.memorygame.ui.GameView
import com.example.memorygame.memorygame.ui.GameViewRenderer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Test


class GameViewRendererTest {

    private val view = mock<GameView>()
    private val viewRenderer = GameViewRenderer(view)

    @Test
    fun `it can render ready to start game view`() {
        val gameModel = GameModel.READY_TO_START_GAME_MODEL

        //when
        viewRenderer.render(gameModel)

        //then
        verify(view).renderStartGame()

        verifyNoMoreInteractions(view)
    }
}