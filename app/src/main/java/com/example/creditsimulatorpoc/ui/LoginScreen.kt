package com.example.creditsimulatorpoc.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import com.example.creditsimulatorpoc.AppDestinations
import com.example.creditsimulatorpoc.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginLayout(navController: NavHostController,activity: FragmentActivity) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val usernameError = remember { mutableStateOf("") }
    val passwordError = remember { mutableStateOf("") }
    topBar()
    middleSection(username, usernameError, passwordError, password)
    bottomSection(navController = navController, username, usernameError, passwordError, password,activity)
}


@Composable
private fun middleSection(
    username: MutableState<String>,
    usernameError: MutableState<String>,
    passwordError: MutableState<String>,
    password: MutableState<String>
) {
    Column(
        Modifier.padding(
            start = 10.dp,
            top = 98.dp
        )
    ) {
        Text(
            modifier = Modifier.padding(start = 15.dp, bottom = 18.dp),
            text = "Login",
            fontSize = 28.sp,
            fontWeight = FontWeight(400)
        )
        userNameDetails(username, usernameError)
        passwordDetail(password, passwordError)
    }
}

@Composable
private fun rememberMe() {
    var newsCheckState by remember { mutableStateOf(false) }
    Row(modifier = Modifier.padding(top = 18.dp))
    {
        val icon = if (newsCheckState)
            painterResource(id = com.example.creditsimulatorpoc.R.drawable.checksquare)
        else
            painterResource(id = com.example.creditsimulatorpoc.R.drawable.checksquare)

        Row(
            Modifier.padding(
                start = 15.dp
            )
        ) {
            /*Checkbox(
                checked = newsCheckState,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Transparent,
                    uncheckedColor = Color.Transparent,
                    checkmarkColor = Color.Transparent,
                    disabledColor = Color.Transparent,
                    disabledIndeterminateColor = Color.Transparent
                ),
                onCheckedChange = { newsCheckState = !newsCheckState }
            )*/
            Icon(
                painter = icon,
                contentDescription = null,
                Modifier
                    .size(18.dp)
                    .padding(top = 1.dp),
            )
        }

        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "Remember Me",
            fontSize = 14.sp,
            fontWeight = FontWeight(400)
        )
    }
}

@Composable
private fun passwordDetail(
    password: MutableState<String>,
    passwordError: MutableState<String>
) {
    OutlinedTextField(
        modifier = Modifier
            .padding(start = 15.dp, end = 30.dp)
            .fillMaxWidth()
            .height(60.dp),
        value = password.value,
        onValueChange = {
            password.value = it
        },
        shape = RoundedCornerShape(2.dp),
        label = {
            Text(
                text = "Password",
                color = colorResource(id = com.example.creditsimulatorpoc.R.color.black),

                )
        },
        visualTransformation = PasswordVisualTransformation()
    )
    if (passwordError.value.isNotEmpty()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 2.dp)
                .clickable { },
            textAlign = TextAlign.Left,
            text = passwordError.value,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = colorResource(id = com.example.creditsimulatorpoc.R.color.red)
        )
    }
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 30.dp, top = 2.dp),
        textAlign = TextAlign.Right,
        text = "Forgot password?",
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        color = colorResource(id = com.example.creditsimulatorpoc.R.color.button_purple)
    )
}

@Composable
private fun userNameDetails(
    username: MutableState<String>,
    usernameError: MutableState<String>
) {
    OutlinedTextField(modifier = Modifier
        .padding(start = 15.dp, end = 30.dp)
        .fillMaxWidth()
        .height(60.dp),
        value = username.value,
        onValueChange = {
            username.value = it
        },
        shape = RoundedCornerShape(2.dp),
        label = {
            Text(
                text = "Username",
                color = colorResource(id = com.example.creditsimulatorpoc.R.color.black),

                )
        }
    )
    if (usernameError.value.isNotEmpty()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 2.dp),
            textAlign = TextAlign.Left,
            text = usernameError.value,
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            color = colorResource(id = com.example.creditsimulatorpoc.R.color.red)
        )
    }
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 30.dp, top = 2.dp, bottom = 2.dp),
        textAlign = TextAlign.Right,
        text = "Forgot username?",
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        color = colorResource(id = com.example.creditsimulatorpoc.R.color.button_purple)
    )
}

@Composable

public fun topBar() {

    Row(
        Modifier.padding(
            start = 15.dp,
            top = 15.dp,
        )
    ) {
        Image(
            alignment = Alignment.Center,
            painter = painterResource(id = com.example.creditsimulatorpoc.R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .height(56.dp)
                .width(172.dp)
                .padding(start = 10.dp)
        )
    }
}

@Composable
fun bottomSection(
    navController: NavHostController,
    username: MutableState<String>,
    usernameError: MutableState<String>,
    passwordError: MutableState<String>,
    password: MutableState<String>,
    activity: FragmentActivity
) {
    Column(
        Modifier
            .fillMaxHeight()
            .padding(
                bottom = 48.dp, start = 45.dp,
                end = 45.dp,
            ),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                /* if (!username.value.equals(username)) {
                      usernameError.value = "The username you entered is incorrect"
                  } else {
                      usernameError.value = ""
                  }
                  if (!password.value.equals(password)) {
                      passwordError.value = "The password you entered is incorrect"
                  } else {
                      passwordError.value = ""
                  }
                  if (usernameError.value.equals("") && passwordError.value.equals("")) {
                      navController.navigate(AppDestinations.HOME)
                  }*/
                //navController.navigate(AppDestinations.ACTIVITYSTATUS)
                navController.popBackStack()
               navController.navigate(AppDestinations.HOME)
//navController.navigate(AppDestinations.EXPANDEDSTATUS)
            },
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    end = 15.dp,
                )
                .fillMaxWidth()
                .height(55.dp)
                .width(400.dp),
            shape = RoundedCornerShape(10),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = colorResource(id = com.example.creditsimulatorpoc.R.color.button_purple)
            )
        )
        {
            Text(
                text = "LOGIN",
                fontSize = 21.sp,
                fontWeight = FontWeight(700),
                fontStyle = FontStyle.Normal,
                color = colorResource(id = com.example.creditsimulatorpoc.R.color.white)
            )

        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = "OR",
                color = colorResource(id = R.color.pink_dark),
                fontSize = 16.sp,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                maxLines = 1
            )
        }

        Button(
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 5.dp,
                    top = 20.dp
                )
                .fillMaxWidth()
                .height(55.dp)
                .width(400.dp),
            border = BorderStroke(1.dp, color = colorResource(id = R.color.pink_dark)),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = colorResource(id = R.color.pink_dark),
                backgroundColor = colorResource(
                    id = R.color.white
                )
            ),
            onClick = {navController.popBackStack()
                navController.navigate(AppDestinations.BiometricScreen)
            }) {
            Text(
                text = "USE BIOMETRICS",
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
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Do not have an account?",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle.Normal,
            )

            Text(
                text = AnnotatedString("Sign Up"),
                modifier = Modifier
                    .padding(start = 2.dp)
                    .clickable {
                        navController.navigate(
                            AppDestinations.SIGNUP
                        )
                    },
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline,
                    color = colorResource(id = com.example.creditsimulatorpoc.R.color.button_purple)
                )
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = "Copyright © 2022, Experian Ltd. All rights reserved.",
                modifier = Modifier
                    .padding(start = 2.dp),
                style = TextStyle(
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                )
            )
        }
    }
}
