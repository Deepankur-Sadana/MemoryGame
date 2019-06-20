package com.example.memorygame.game.engine

import com.example.memorygame.game.model.CardState
import com.example.memorygame.game.model.Points


object LocalRuleEngine {


    fun getResult(moveRequest: MoveRequest): MoveResult {


        if (moveRequest.visibleCard != null) {// have stored previous card info
            val otherCard = moveRequest.visibleCard
            val movedCard = moveRequest.movedCard

            if (moveRequest.movedCard.uId == moveRequest.visibleCard.uId) {// clicked card is same as open card
                return MoveResult(
                    GameResult.ONGOING,
                    moveRequest.pointsSoFar,
                    null,
                    moveRequest.level,
                    moveRequest.visibleCard.uId
                )
            }

            if (moveRequest.movedCard.name == moveRequest.visibleCard.name) {
                val finalPoints = getPoints(moveRequest.level, moveRequest.pointsSoFar, moveRequest.timeRemaining)
                return if (finalPoints.points >= getWinningPoints(moveRequest.level)) {//won the game
                    MoveResult(
                        GameResult.WON,
                        finalPoints,
                        null,
                        moveRequest.level + 1,
                        null
                    )
                } else {//right result but didn't win the game; so flip the right cards
                    val flip1 = FlipAction(CardState.SOLVED, otherCard.uId)
                    val flip2 = FlipAction(CardState.SOLVED, movedCard.uId)

                    val flipList = listOf(flip1, flip2)
                    return MoveResult(
                        GameResult.ONGOING,
                        finalPoints,
                        flipList,
                        moveRequest.level,
                        null
                    )
                }
            } else {//two cards are flipped ; but they are not same
                val flip1 = FlipAction(CardState.HIDDEN, otherCard.uId)
                val flip2 = FlipAction(CardState.HIDDEN, movedCard.uId)
                return MoveResult(
                    GameResult.ONGOING,
                    moveRequest.pointsSoFar,
                    listOf(flip1, flip2),
                    moveRequest.level,
                    null
                )
            }
        } else {//only one card flipped
            val movedCard = moveRequest.movedCard
            val flipAction = FlipAction(CardState.VISIBLE, movedCard.uId)
            return MoveResult(
                GameResult.ONGOING,
                moveRequest.pointsSoFar,
                listOf(flipAction),
                moveRequest.level,
                moveRequest.movedCard.uId
            )
        }

    }

    private fun getPoints(
        level: Int,
        currentPoints: Points,
        timeRemaining: Int
    ): Points {
        val bonusPoints = getBonusPoints(level, currentPoints, timeRemaining)
        return Points(currentPoints.points + 4)
    }


    private fun getBonusPoints(
        level: Int,
        currentPoints: Points,
        timeRemaining: Int
    ): Int {
        //TODO (currently assigning 0 points for quick move)
        //add quick move logic here

        return 0
    }

    private fun getWinningPoints(level: Int): Int {
        return when (level) {
            1 -> 8
            2 -> 25
            3 -> 50
            else -> TODO()
        }
    }
}