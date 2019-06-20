package com.example.memorygame.memorygame.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Card(
    val uId: Int,
    var cardState: CardState,
    val imageUrl: String,
    val name: String
) : Parcelable