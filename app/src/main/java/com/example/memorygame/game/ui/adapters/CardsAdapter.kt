package com.example.memorygame.game.ui.adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.memorygame.R
import com.example.memorygame.game.model.Card
import com.example.memorygame.game.ui.OnCardClickedListener
import com.example.memorygame.game.ui.viewholders.CardsViewHolder


class CardsAdapter(
    private var myDataset: List<Card>,
    private val context: Context,
    private val onCardClickedListener: OnCardClickedListener
)
    : RecyclerView.Adapter<CardsViewHolder>() {


    override fun getItemCount(): Int {
        return myDataset.size;
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bindModel(myDataset[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false)
        return CardsViewHolder(view, onCardClickedListener)
    }

    fun updateData(newDataSet: List<Card>) {
        myDataset = newDataSet
        notifyDataSetChanged()
    }

}