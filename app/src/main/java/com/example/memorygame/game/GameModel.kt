package com.example.memorygame.game

import android.os.Parcelable
import com.example.memorygame.game.engine.FlipAction
import com.example.memorygame.game.engine.GameDataProvider
import com.example.memorygame.game.engine.LocalGameDataProvider
import com.example.memorygame.game.model.Card
import com.example.memorygame.game.model.GameState
import com.example.memorygame.game.model.Points
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class GameModel(
    val cardList: List<Card>,
    val currentPoints: Points,
    val currentLevel: Int,
    val selectedCard: Card?,
    val gameDataProvider: @RawValue GameDataProvider,
    val gameState: GameState,
    val timeLeft: Int
) : Parcelable {

    companion object {
        val READY_TO_START_GAME_MODEL = GameModel(
            emptyList(),
            Points(Points.DEFAULT_POINTS),
            1,
            null,
            LocalGameDataProvider(),
            GameState.STOPPED,
            -1
        )
    }

    fun startTickingGame(): GameModel =

        copy(
            currentLevel = currentLevel,
            cardList = gameDataProvider.getCardList(currentLevel),
            gameState = GameState.TICKING,
            selectedCard = null

        )


    fun gameWonEvent(level: Int, points: Points): GameModel =
        copy(
            currentLevel = level,
            currentPoints = points,
            gameState = GameState.STOPPED,
            selectedCard = null
        )


    fun renderFlippedCards(
        level: Int,
        finalPoints: Points,
        flips: List<FlipAction>?,
        visibleCardId: Int?
    ): GameModel {
        if (flips != null)
            return copy(
                currentLevel = level,
                currentPoints = finalPoints,
                cardList = flipCards(flips),
                selectedCard = getSelectedCard(visibleCardId)
            )
        return copy()
    }

    private fun getSelectedCard(cardId: Int?): Card? {
        if (cardId == null) return null
        cardList.forEach { card ->
            if (cardId == card.uId) return card
        }
        return null
    }

    private fun flipCards(flips: List<FlipAction>): List<Card> {

        // TODO (change from (On^2) to O(n)
        cardList.forEach { card ->
            flips.forEach { flip ->
                if (card.uId == flip.cardUid) {
                    card.cardState = flip.cardState
                }
            }

        }
        return cardList
    }

    fun timerTicked(millisUntilFinished: Long): GameModel =
        copy(timeLeft = (millisUntilFinished / 1000).toInt())

    fun timeUp(): GameModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun pauseGame(): GameModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
