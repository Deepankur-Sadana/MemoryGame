package com.example.memorygame.game.effecthandlers

import com.example.memorygame.architechture.threading.SchedulersProvider
import com.example.memorygame.game.engine.GameResult
import com.example.memorygame.game.engine.MoveResult
import com.example.memorygame.game.*
import com.spotify.mobius.rx2.RxMobius
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import timber.log.Timber

object GameEffectHandler {
    fun create(
        gameApi: GameEngine,
        schedulersProvider: SchedulersProvider
    ): ObservableTransformer<GameEffect, GameEvent> {
        return RxMobius
            .subtypeEffectHandler<GameEffect, GameEvent>()
            .addTransformer(
                GetResultEffect::class.java,
                getMoveResult(gameApi, schedulersProvider)
            )
            .build()
    }


    private fun getMoveResult(
        gitHubApi: GameEngine,
        schedulersProvider: SchedulersProvider
    ): ObservableTransformer<GetResultEffect, GameEvent> {
        return ObservableTransformer<GetResultEffect, GameEvent> { getResultEffect ->
            getResultEffect
                .flatMapSingle { effect ->
                    gitHubApi
                        .compareCards(effect.moveRequest)
                        .map(GameEffectHandler::mapToGameResultEvent)
                        .doOnError(Timber::e)
                        .onErrorReturn { mapToErrorEvent(it) }
                }
                .subscribeOn(schedulersProvider.io)
        }
    }

    private fun mapToGameResultEvent(result: MoveResult): GameEvent {
        when {
            result.gameResult == GameResult.WON -> {
                return GameWonEvent(result.level, result.finalPoints)
            }
            result.gameResult == GameResult.ONGOING -> {
                return FlipCardsEvent(
                    result.level,
                    result.finalPoints,
                    result.flips,
                    result.visibleCardID
                )
            }
        }
        return GameCompletedEvent
    }

    private fun mapToErrorEvent(throwable: Throwable): GameEvent =
        UnableToFetchResultEvent
}