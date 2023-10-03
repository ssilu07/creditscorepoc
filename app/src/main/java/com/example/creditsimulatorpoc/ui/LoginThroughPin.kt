package com.example.creditsimulatorpoc.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.creditsimulatorpoc.AppDestinations
import com.example.creditsimulatorpoc.R

@Composable
fun PinLoginScreen(navController: NavHostController){
   val digitOne = remember { mutableStateOf("") }
   val digitTwo = remember { mutableStateOf("") }
   val digitThree = remember { mutableStateOf("") }
   val digitFour = remember { mutableStateOf("") }
   topBar()
   PinLoginLayout(digitOne,digitTwo,digitThree,digitFour )
   BottomSection(navController = navController)
}



@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PinLoginLayout(digitOne: MutableState<String>, digitTwo: MutableState<String>, digitThree: MutableState<String>, digitFour: MutableState<String>,){
   val (first, second, third, fourth) = FocusRequester.createRefs()
   Column(horizontalAlignment = Alignment.CenterHorizontally,
   modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .padding(top = 120.dp)) {
   Text(
      text = "Enter Pin",
      fontSize = 24.sp,
      fontWeight = FontWeight(400),
      fontStyle = FontStyle.Normal,
      lineHeight = 130.sp,
      fontFamily = FontFamily(Font(R.font.roboto_medium))
      )

   Box(
      modifier = Modifier
         .fillMaxWidth()
         .wrapContentHeight()
         .background(shape = RoundedCornerShape(10.dp), color = Color.White)
         .border(width = 0.dp, color = colorResource(id = R.color.white)),
  )
   {
      Row(horizontalArrangement = Arrangement.spacedBy(9.dp,Alignment.CenterHorizontally),
         modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)){

         TextField(
            modifier = Modifier
               .width(50.dp)
               .height(50.dp)
               .border(width = 1.dp, color = colorResource(id = R.color.dark_gray))
               .focusRequester(first),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = digitOne.value,
            onValueChange = {
               if(it.length<=1) {
                  digitOne.value = it
               }
               if(it.length>=1){
                  second.requestFocus()
               }
            },
            textStyle = TextStyle.Default.copy(fontSize = 18.sp,
            fontWeight = FontWeight(400),
              // textAlign = TextAlign.Center,

            ),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = colorResource(id = R.color.white)),

            shape = RoundedCornerShape(2.dp),
            label = {
            },
            visualTransformation = PasswordVisualTransformation()
         )
         TextField(
            modifier = Modifier
               .width(50.dp)
               .height(50.dp)
               .background(shape = RectangleShape, color = Color.White)
               .border(width = 1.dp, color = colorResource(id = R.color.dark_gray))
               .focusRequester(second),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            value = digitTwo.value,
            onValueChange = {
               if(it.length<=1) {
                  digitTwo.value = it
               }
               if(it.length>=1){
                  third.requestFocus()
               }
            },
            textStyle = TextStyle.Default.copy(fontSize = 18.sp,
               fontWeight = FontWeight(400),
                       //textAlign = TextAlign.Center,
            ),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = colorResource(id = R.color.white)),

            shape = RoundedCornerShape(2.dp),
            label = {
            },
            visualTransformation = PasswordVisualTransformation()
         )
         TextField(
            modifier = Modifier
               .width(50.dp)
               .height(50.dp)
               .background(shape = RectangleShape, color = Color.White)
               .border(width = 1.dp, color = colorResource(id = R.color.dark_gray))
               .focusRequester(third),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            value = digitThree.value,
            onValueChange = {
               if(it.length<=1) {
                  digitThree.value = it
               }
               if(it.length>=1){
                  fourth.requestFocus()
               }
            },
            textStyle = TextStyle.Default.copy(fontSize = 18.sp,
               fontWeight = FontWeight(400),
              // textAlign = TextAlign.Center,
            ),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = colorResource(id = R.color.white)),

            shape = RoundedCornerShape(2.dp),
            label = {
            },
            visualTransformation = PasswordVisualTransformation()
         )
         TextField(
            modifier = Modifier
               .width(50.dp)
               .height(50.dp)
               .background(shape = RectangleShape, color = Color.White)
               .border(width = 1.dp, color = colorResource(id = R.color.dark_gray))
            .focusRequester(fourth),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            value = digitFour.value,
            onValueChange = {
               if(it.length<=1) {
                  digitFour.value = it
               }
            },
            textStyle = TextStyle.Default.copy(fontSize = 18.sp,
               fontWeight = FontWeight(400),
             //  textAlign = TextAlign.Center,
            ),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = colorResource(id = R.color.white)),

            shape = RoundedCornerShape(2.dp),
            label = {
            },
            visualTransformation = PasswordVisualTransformation()
         )
      }

   }
}
}
@Composable
fun BottomSection(navController: NavHostController) {
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
            navController.popBackStack();
                  navController.navigate(AppDestinations.HOME)
         },
         modifier = Modifier
            .padding(
               start = 15.dp,
               end = 15.dp,
            )
            .fillMaxWidth()
            .height(55.dp)
            .width(405.dp),
         shape = RoundedCornerShape(5),
         colors = ButtonDefaults.textButtonColors(
            backgroundColor = colorResource(id = R.color.button_purple)
         )
      )
      {
         Text(
            text = "DONE",
            fontSize = 16.sp,
            lineHeight = 19.sp,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontWeight = FontWeight(700),
            fontStyle = FontStyle.Normal,
            color = colorResource(id = R.color.white)
         )

      }
      Button(
         onClick = {
            navController.popBackStack();
            navController.navigate(AppDestinations.BiometricScreen)
         },
         modifier = Modifier
            .padding(
               start = 15.dp,
               end = 15.dp,
               top = 15.dp,
            )
            .fillMaxWidth()
            .height(55.dp)
            .width(405.dp),
         shape = RoundedCornerShape(5),
         colors = ButtonDefaults.textButtonColors(
            backgroundColor = colorResource(id = R.color.white)
         ),
         border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.button_purple))
      )
      {
         Text(
            text = "BACK",
            fontSize = 16.sp,
            lineHeight = 19.sp,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontWeight = FontWeight(700),
            fontStyle = FontStyle.Normal,
            color = colorResource(id = R.color.button_purple)
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
