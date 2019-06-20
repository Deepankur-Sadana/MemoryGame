package com.example.memorygame.game.engine

import com.example.memorygame.game.GameEngine
import io.reactivex.Single

class LocalGameEngine : GameEngine {

    override fun compareCards(moveRequest: MoveRequest): Single<MoveResult> {
        return Single.just(LocalRuleEngine.getResult(moveRequest))
    }
}
