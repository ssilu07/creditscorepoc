package com.example.creditsimulatorpoc.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun CustomRatingBar(modifier: Modifier = Modifier, rating: Float) {
    Row(modifier = modifier) {
        for (i in 1..5) {
            val icon = if (i.toFloat() <= rating) {
                painterResource(id = com.example.creditsimulatorpoc.R.drawable.filledstar)
            } else if (rating > (i - 1).toFloat() && rating < i.toFloat()) {
                painterResource(id = com.example.creditsimulatorpoc.R.drawable.ic_half_star)
            } else
                painterResource(id = com.example.creditsimulatorpoc.R.drawable.outlinedstar)

            Box(
                modifier = Modifier.padding(
                    start = 2.dp,
                    end = 2.dp
                )
            ) {
                Icon(painter = icon,
                    tint = colorResource(id = com.example.creditsimulatorpoc.R.color.yellow),
                    contentDescription = "star",
                    modifier = Modifier
                        .width(12.dp)
                        .height(12.dp)
                        .clickable {
                        }
                )
            }
        }
    }
}