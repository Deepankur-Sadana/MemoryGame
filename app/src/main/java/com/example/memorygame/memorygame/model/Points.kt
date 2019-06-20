package com.example.memorygame.memorygame.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Points(val points: Int) : Parcelable{
    companion object{
        const val DEFAULT_POINTS = 0
    }
}