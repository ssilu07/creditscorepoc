package com.example.creditsimulatorpoc.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.creditsimulatorpoc.AppDestinations
import com.example.creditsimulatorpoc.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreenLayout(navController: NavHostController) {
    LaunchedEffect(true) {
        delay(3000)
        navController.popBackStack()
        navController.navigate(AppDestinations.LOGIN)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.logo), contentDescription = "",
            modifier = Modifier
                .height(92.dp)
                .width(272.dp)
        )
        Text(
            text = "Make your credit score excellent!",
            fontSize = 24.sp,
            fontWeight = FontWeight(500),
            fontStyle = FontStyle.Normal,
            color = colorResource(id = R.color.text_purple)
        )
    }
}

/*
@Preview
@Composable
fun DebugPreview() {
    SplashScreenLayout(th)
}*/
