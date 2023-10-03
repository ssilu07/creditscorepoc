package com.example.creditsimulatorpoc.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.creditsimulatorpoc.R

@Composable
fun ReviewScreen() {
    Column(modifier = Modifier.padding(start = 14.dp, top = 24.dp, bottom = 20.dp)) {
        Row() {

            Text(
                text = "Customers Voice",
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
                fontStyle = FontStyle.Normal,
                color = colorResource(id = R.color.black)
            )

            Box(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(top = 8.dp,end = 18.dp),
                Alignment.CenterEnd
            ) {
                Image(
                    modifier = Modifier
                        .height(18.dp)
                        .width(18.dp),
                    alignment = Alignment.CenterEnd,
                    painter = painterResource(id = R.drawable.arrow_right), contentDescription = "",
                    contentScale = ContentScale.Fit,
                )
            }
        }

        Card(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(top = 24.dp, start = 5.dp, end = 16.dp),
            elevation = 1.dp,
            shape = RoundedCornerShape(20.dp),
            backgroundColor = Color.White
        ) {
            Column() {
                val item = 3.5
                Row(modifier = Modifier.padding(start = 18.dp, top = 18.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.imageone),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(70))
                            .size(52.dp)
                    )
                    Column(modifier = Modifier.padding(start = 15.dp)) {
                        Text(
                            text = "Adam Connor",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(500),
                            fontStyle = FontStyle.Normal,
                            color = colorResource(id = R.color.black)
                        )
                        Text(
                            modifier = Modifier
                                .padding(end = 30.dp, top = 4.dp),
                            text = "October 26,2022",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            fontStyle = FontStyle.Normal,
                            color = colorResource(id = R.color.primaryGray),
                            textAlign = TextAlign.Left
                        )
                    }
                }
                Text(
                    text = "I improved my credit score by 200 points in just 1 year using Experian. Love the App, would recommend to everyone.\n",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    fontStyle = FontStyle.Normal,
                    color = colorResource(id = R.color.black),
                    modifier = Modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp)
                )

            }
        }
        Card(
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
                .padding(top = 24.dp, start = 5.dp, end = 16.dp),
            elevation = 1.dp,
            shape = RoundedCornerShape(20.dp),
            backgroundColor = Color.White
        ) {
            Column() {
                val item = 3.5
                Row(modifier = Modifier.padding(start = 18.dp, top = 18.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.imagetwo),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(70))
                            .size(52.dp)
                    )
                    Column(modifier = Modifier.padding(start = 15.dp)) {
                        Text(
                            text = "Rita Ora",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(500),
                            fontStyle = FontStyle.Normal,
                            color = colorResource(id = R.color.black)
                        )
                        Text(
                            modifier = Modifier
                                .padding(end = 30.dp, top = 4.dp),
                            text = "September 12,2022",
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            fontStyle = FontStyle.Normal,
                            color = colorResource(id = R.color.primaryGray),
                            textAlign = TextAlign.Left
                        )
                    }
                }
                Text(
                    text = "Great way to get tips on how you can make your credit score better. Keeping up to date with how your credit score changes and what to do. Recommend this highly to friends and family.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    fontStyle = FontStyle.Normal,
                    color = colorResource(id = R.color.black),
                    modifier = Modifier.padding(start = 15.dp, top = 15.dp, end = 15.dp)
                )

            }
        }
    }
}