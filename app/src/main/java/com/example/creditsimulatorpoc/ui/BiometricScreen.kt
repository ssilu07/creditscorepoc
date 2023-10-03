package com.example.creditsimulatorpoc.ui


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import com.example.creditsimulatorpoc.AppDestinations
import com.example.creditsimulatorpoc.R
import com.example.creditsimulatorpoc.ui.views.Biometric


@Composable
fun BiometricScreen(navController: NavHostController,activity: FragmentActivity) {

    LaunchedEffect(true){

        Biometric.authenticate(
            activity = activity,
            title = "Biometric Authentication",
            subtitle = "Authenticate to proceed",
            description = "Authentication is must",
            negativeText = "Cancel",
            onSuccess = {activity.runOnUiThread {

            }},
            onError = {errorCode,errorString->
                activity.runOnUiThread {

                }
            },
            onFailed = {
                activity.runOnUiThread {

                }
            },
            navController = navController
        )

    }

    Column (modifier = Modifier
        .fillMaxHeight()
        .verticalScroll(rememberScrollState())){
        topBar()
        loginUi()
        bottomButton(navController = navController)
    }
}


@Composable
fun loginUi() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Login",
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.black),
        )

        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Use biometrics for faster & secure\naccess to your account",
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.primary_gray),
        )

        Box(
            modifier = Modifier.padding(top = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .height(122.dp)
                    .width(122.dp),
                painter = painterResource(id = R.drawable.ic_fingerprintbg),
                contentDescription = "",
                alignment = Alignment.Center
            )

            Image(
                modifier = Modifier
                    .height(73.dp)
                    .width(73.dp),
                painter = painterResource(id = R.drawable.fingerprint),
                contentDescription = "",
                alignment = Alignment.Center
            )
        }

    }
}

@Composable
fun bottomButton(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 150.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .padding(bottom = 16.dp, start = 45.dp, end = 45.dp)
                .width(300.dp)
                .height(56.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Red, backgroundColor = colorResource(
                    id = R.color.pink_dark
                )
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                navController.popBackStack()
                navController.navigate(AppDestinations.PINLOGIN)
            }) {

            Text(
                text = "LOGIN WITH PIN",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                maxLines = 1
            )
        }

        Button(
            modifier = Modifier
                .padding(start = 45.dp, end = 45.dp, bottom = 16.dp)
                .width(300.dp)
                .height(56.dp),
            border = BorderStroke(1.dp, color = colorResource(id = R.color.pink_dark)),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = colorResource(id = R.color.pink_dark),
                backgroundColor = colorResource(
                    id = R.color.white
                )
            ),
            onClick = { navController.popBackStack()
                navController.navigate(AppDestinations.LOGIN) }) {
            Text(
                text = "LOGIN",
                color = colorResource(id = R.color.pink_dark),
                fontSize = 16.sp,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                maxLines = 1
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Copyright © 2022, Experian Ltd. All rights reserved.",
                style = TextStyle(
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                )
            )
        }
    }
}

