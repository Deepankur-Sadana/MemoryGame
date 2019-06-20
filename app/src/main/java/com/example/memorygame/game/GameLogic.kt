package com.example.memorygame.game

import com.example.memorygame.game.engine.MoveRequest
import com.spotify.mobius.Next
import com.spotify.mobius.Next.next
import com.spotify.mobius.Update

object GameLogic : Update<GameModel, GameEvent, GameEffect> {


    override fun update(
        model: GameModel,
        event: GameEvent
    ): Next<GameModel, GameEffect> {

        return when (event) {
            is StartGameEvent -> next(model.startTickingGame())

            is CardClickedEvent -> {
                next(
                    model,
                    setOf(
                        GetResultEffect(
                            MoveRequest(
                                model.currentPoints,
                                model.currentLevel,
                                event.card,
                                model.selectedCard,
                                model.timeLeft

                            )
                        )
                    )
                )
            }

            is GameWonEvent -> {
                next(
                    model.gameWonEvent(
                        event.level,
                        event.pointsSoFar
                    )
                )
            }

            is FlipCardsEvent -> {
                next(
                    model.renderFlippedCards(
                        event.level,
                        event.finalPoints,
                        event.flips,
                        event.visibleCardId
                    )
                )
            }

            is TimerTickedEvent -> {
                next(
                    model.timerTicked(event.millisUntilFinished)
                )
            }

            is TimerUpEvent -> {
                next(
                    model.timeUp()
                )
            }

            is PauseGameEvent -> {
                next(
                    model.pauseGame()
                )
            }


            else -> TODO()
        }
    }

}
