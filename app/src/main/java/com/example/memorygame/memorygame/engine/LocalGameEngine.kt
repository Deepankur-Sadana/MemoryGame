package com.example.memorygame.memorygame.engine

import com.example.memorygame.memorygame.GameEngine
import io.reactivex.Single

class LocalGameEngine : GameEngine {

    override fun compareCards(moveRequest: MoveRequest): Single<MoveResult> {
        return Single.just(RuleEngine.getResult(moveRequest))
    }
}
