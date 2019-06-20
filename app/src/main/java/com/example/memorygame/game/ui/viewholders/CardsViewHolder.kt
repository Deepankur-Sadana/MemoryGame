package com.example.memorygame.game.ui.viewholders


import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.memorygame.R
import com.example.memorygame.game.model.Card
import com.example.memorygame.game.model.CardState
import com.example.memorygame.game.ui.OnCardClickedListener


class CardsViewHolder(itemView: View, private val onCardClickedListener: OnCardClickedListener) :
    RecyclerView.ViewHolder(itemView) {

    private val titleTv: TextView = itemView.findViewById(R.id.displayTextView)
    private val imageIv: ImageView = itemView.findViewById(R.id.displayImageView)

    fun bindModel(cardData: Card?) {

        if (CardState.HIDDEN == cardData?.cardState) {
            titleTv.visibility = VISIBLE
            imageIv.visibility = GONE
        } else {
            titleTv.visibility = GONE
            imageIv.visibility = VISIBLE
            Glide.with(itemView.context).load(cardData?.imageUrl).into(imageIv)
        }


        //for debugging views
        if (CardState.SOLVED == cardData?.cardState) {
            itemView.background = itemView.context.getDrawable(android.R.drawable.alert_dark_frame)
        } else {
            itemView.background = null
        }
        itemView.setOnClickListener { onCardClickedListener.onCardClicked(cardData as Card) }
    }
}