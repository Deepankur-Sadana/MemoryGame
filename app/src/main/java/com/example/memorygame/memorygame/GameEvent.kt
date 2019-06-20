package com.example.memorygame.memorygame

import com.example.memorygame.memorygame.engine.FlipAction
import com.example.memorygame.memorygame.model.Card
import com.example.memorygame.memorygame.model.Points

sealed class GameEvent

object StartGameEvent : GameEvent()

object GameCompletedEvent : GameEvent()

object UnableToFetchResultEvent : GameEvent()

data class CardClickedEvent(val card: Card) : GameEvent()

data class GameWonEvent(
    val level: Int,
    val pointsSoFar: Points
) : GameEvent()

data class FlipCardsEvent(
    val level: Int,
    val finalPoints: Points,
    val flips: List<FlipAction>?,
    val visibleCardId: Int?
) : GameEvent()

data class TimerTickedEvent(val millisUntilFinished: Long) : GameEvent()

object TimerUpEvent : GameEvent()
