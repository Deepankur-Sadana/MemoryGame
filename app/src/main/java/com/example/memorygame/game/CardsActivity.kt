package com.example.memorygame.game

import android.view.View
import com.example.memorygame.R
import com.example.cards.architechture.BaseActivity
import com.example.memorygame.architechture.threading.DefaultSchedulersProvider
import com.example.memorygame.game.effecthandlers.GameEffectHandler
import com.example.memorygame.game.engine.LocalGameEngine
import com.example.memorygame.game.model.Card
import com.example.memorygame.game.model.CardState
import com.example.memorygame.game.ui.GameView
import com.example.memorygame.game.ui.GameViewRenderer
import com.example.memorygame.game.ui.OnCardClickedListener
import com.example.memorygame.game.ui.adapters.CardsAdapter
import com.spotify.mobius.Next
import io.reactivex.ObservableTransformer
import kotlinx.android.synthetic.main.activity_cards.*

class CardsActivity : BaseActivity<GameModel, GameEvent, GameEffect>(), GameView {

    private lateinit var adapter: CardsAdapter
    private lateinit var uiController: GameUiController


    private val viewRenderer by lazy(LazyThreadSafetyMode.NONE) {
        GameViewRenderer(this)
    }

    override fun layoutResId(): Int {
        return R.layout.activity_cards
    }

    override fun setup() {
        startTextView.setOnClickListener {
            eventSource.notifyEvent(StartGameEvent)
            uiController.notifyGameStarted()
        }
        adapter = CardsAdapter(emptyList(), this, object : OnCardClickedListener {
            override fun onCardClicked(cardData: Card) {
                //TODO is this an architechtural leak ????
                // BReaking the "S"
                if (cardData.cardState == CardState.HIDDEN)
                    eventSource.notifyEvent(CardClickedEvent(cardData))
            }
        })
        uiController = GameUiController(eventSource)
        cardsRecyclerView.adapter = adapter
        cardsRecyclerView.layoutManager = uiController.getLayoutManager(this)
    }

    override fun initialModel(): GameModel =
        GameModel.READY_TO_START_GAME_MODEL

    override fun updateFunction(model: GameModel, event: GameEvent): Next<GameModel, GameEffect> =
        GameLogic.update(model, event)

    override fun render(model: GameModel) {
        viewRenderer.render(model)
    }


    override fun effectHandler(): ObservableTransformer<GameEffect, GameEvent> =
        GameEffectHandler.create(LocalGameEngine(), DefaultSchedulersProvider())


    override fun renderStartGame() {
        startTextView.visibility = View.VISIBLE
        points.visibility = View.GONE
        cardsRecyclerView.visibility = View.GONE
    }

    override fun renderTiles(
        cardList: List<Card>,
        currentPoints: Int,
        timeLeft: Int
    ) {
        startTextView.visibility = View.GONE
        points.visibility = View.VISIBLE
        timerTextView.text = timeLeft.toString()
        points.text = currentPoints.toString()

        adapter.updateData(cardList)

        with(cardsRecyclerView) {
            visibility = View.VISIBLE
        }
    }
}