/*
package com.example.creditsimulatorpoc.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creditsimulatorpoc.R
import com.michaelKors.android.common.theme.robotoFamily

@Composable
fun Screencard(){

    Card(
        modifier = Modifier
            .height(222.dp)
            .width(208.dp)
            .fillMaxHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = colorResource(id = R.color.light_blue)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    text = "",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = robotoFamily
                )
                Text(
                    modifier = Modifier.padding(
                        top = 16.dp,
                        start = 50.dp,
                        end = 16.dp
                    ),
                    text = "cardsData[index].mainNumber",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Right,
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontFamily = robotoFamily
                )
            }
            Row() {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 6.dp),
                    text = "",
                    color = colorResource(id = R.color.gray_light),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontFamily = robotoFamily,
                    maxLines = 2

                )
                Text(
                    modifier = Modifier.padding(start = 50.dp, top = 6.dp),
                    text = "",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Right,
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontFamily = robotoFamily
                )
            }

            Column() {
                Image(
                    modifier = Modifier
                        .height(226.dp)
                        .width(226.dp),
                    painter = cardsData[index].image,
                    contentDescription = "",
                    alignment = Alignment.BottomStart
                )
                Image(
                    modifier = Modifier
                        .height(226.dp)
                        .width(226.dp),
                    painter = painterResource(id = R.drawable.vector_29),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
                Image(
                    modifier = Modifier
                        .height(124.dp)
                        .width(124.dp),
                    painter = painterResource(id = R.drawable.ellipse_15),
                    contentDescription = "",
                    alignment = Alignment.BottomStart

                )
                Text(
                    modifier = Modifier.padding(start = 50.dp, top = 6.dp),
                    text = cardsData[index].bottomSubtitle,
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Left,
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontFamily = robotoFamily
                )
            }


        }
    }
}*/
