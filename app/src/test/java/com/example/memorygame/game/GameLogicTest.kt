package com.example.memorygame.game

import com.spotify.mobius.test.UpdateSpec


import com.google.common.truth.Truth.assertThat
import com.spotify.mobius.test.NextMatchers.*
import com.spotify.mobius.test.UpdateSpec.assertThatNext
import org.junit.Test

class GameLogicTest {

    private val updateSpec = UpdateSpec<GameModel, GameEvent, GameEffect>(GameLogic::update)
    private val startGameModel = GameModel.READY_TO_START_GAME_MODEL


    @Test
    fun `when the game is launched, user can start the game`() {
        val noTileSelectedModel = startGameModel.startTickingGame()

        updateSpec.given(startGameModel)
            .`when`(StartGameEvent)
            .then(
                assertThatNext(
                    hasModel(noTileSelectedModel),
                    hasNoEffects()
                )
            )
        assertThat(noTileSelectedModel.currentLevel).isEqualTo(1)
        assertThat(noTileSelectedModel.selectedCard).isEqualTo(null)
    }
}