package com.example.creditsimulatorpoc.data

import android.media.Image
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class Cards(
    val title:String,
    val subtitle: String,
    val bottomSubtitle : String,
    val mainNumber: String,
    val subNumber : String,
    val backgroundColor : Color,
    val image : Painter
)
