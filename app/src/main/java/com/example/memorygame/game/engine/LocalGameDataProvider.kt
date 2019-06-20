package com.example.memorygame.game.engine

import android.os.Parcelable
import com.example.memorygame.game.model.Card
import com.example.memorygame.game.model.CardState
import kotlinx.android.parcel.Parcelize

@Parcelize
class LocalGameDataProvider : GameDataProvider, Parcelable {

    override fun getCardList(currentLevel: Int): List<Card> {
        val card1 = Card(
            1,
            CardState.HIDDEN,
            "https://res.cloudinary.com/demo/image/upload/w_200/lady.jpg",
            "girl"
        )
        val card2 = Card(
            2,
            CardState.HIDDEN,
            "https://res.cloudinary.com/demo/image/upload/w_200/lady.jpg",
            "girl"
        )
        val card3 = Card(
            3,
            CardState.HIDDEN,
            "https://4r9jw3yzttn13be1ir5eoyqv-wpengine.netdna-ssl.com/wp-content/uploads/2016/04/kitty-1.png",
            "cat"
        )

        val card4 = Card(
            4,
            CardState.HIDDEN,
            "https://4r9jw3yzttn13be1ir5eoyqv-wpengine.netdna-ssl.com/wp-content/uploads/2016/04/kitty-1.png",
            "cat"
        )
        val list = mutableListOf(card1, card2, card3, card4)

        if (currentLevel == 2) {
            val card5 = Card(
                5,
                CardState.HIDDEN,
                "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg",
                "dog"
            )
            val card6 = Card(
                6,
                CardState.HIDDEN,
                "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg",
                "dog"
            )
            list.add(card5)
            list.add(card6)
        }

        if(currentLevel >=3 ){

        }
        return list
    }
}