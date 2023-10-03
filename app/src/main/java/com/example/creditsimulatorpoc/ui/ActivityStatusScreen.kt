package com.example.creditsimulatorpoc.ui

import android.widget.Toolbar
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.creditsimulatorpoc.AppDestinations
import com.example.creditsimulatorpoc.R
import com.example.creditsimulatorpoc.model.*
import com.example.creditsimulatorpoc.ui.views.BottomBar


@Composable
fun ActivityStatusScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(modifier = Modifier.border(
                width = 0.dp,
                color = colorResource(id = R.color.light_gray)
            ),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Overall Payment History",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                        fontStyle = FontStyle.Normal,
                        color = colorResource(id = R.color.black),
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_black))
                    )
                },
                backgroundColor = colorResource(id = R.color.light_gray),
                navigationIcon = {
                    IconButton(onClick = {navController.navigateUp()}) {
                        Icon(
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp),
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "logo"
                        )
                    }
                },
                contentColor = Color.Black,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp),
                            painter = painterResource(id = R.drawable.ic_bell),
                            contentDescription = "Share",
                            tint = Color.Black
                        )
                    }
                }

            )
        },
   //     drawerContent = { Text(text = "Drawer Menu 1") },
        content = {
            Box(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .background(color = colorResource(id = R.color.light_gray))
            ) {
                overallPaymentHistory(navController = navController)
            }
        },
//        bottomBar = {
//            BottomBar(navController = navController)
//        }
    )
}


@Composable
fun overallPaymentHistory(navController: NavHostController) {
    Column(modifier = Modifier.padding(end = 15.dp, top = 12.dp)
    ) {
        LazyColumn(){
                itemsIndexed(PaymentModel().getList()) { index, item ->
                   if(index == 0){
                       Column(modifier = Modifier.padding(start = 15.dp) ){


                           Box(
                               modifier = Modifier
                                   .wrapContentHeight()
                                   .wrapContentWidth()
                                   .background(shape = RoundedCornerShape(10.dp), color = Color.White)
                                   .border(width = 1.dp, color = Color.White)
                                   .padding(start = 15.dp)


                           ) {


                               Column() {


                                   Row() {
                                       Column() {


                                           Text(
                                               text = "Overall Payment History",
                                               modifier = Modifier.padding(end = 2.dp),
                                               fontSize = 18.sp,
                                               fontWeight = FontWeight(500),
                                               fontStyle = FontStyle.Normal,
                                               lineHeight = 21.sp,
                                               color = colorResource(id = R.color.black),
                                               fontFamily = FontFamily(Font(R.font.roboto_black)),

                                               )
                                           Text(
                                               text = "90% Fair",
                                               modifier = Modifier.padding(end = 2.dp, top = 2.dp),
                                               fontSize = 16.sp,
                                               lineHeight = 16.sp,
                                               fontWeight = FontWeight(700),
                                               fontStyle = FontStyle.Normal,
                                               color = colorResource(id = R.color.primaryGray),
                                               fontFamily = FontFamily(
                                                   Font(R.font.roboto_black)
                                               )

                                           )
                                       }
                                       Icon(
                                           painter = painterResource(id = R.drawable.ic_info), contentDescription = "",
                                           modifier = Modifier
                                               .size(25.dp)
                                               .padding(start = 8.dp)
                                               .align(Top)
                                       )
                                       Box(
                                           modifier = Modifier
                                               .fillMaxWidth()
                                               .padding(end = 15.dp),
                                           Alignment.TopEnd
                                       ) {
                                           Column(horizontalAlignment = Alignment.End) {
                                               Text(
                                                   text = "High",
                                                   fontSize = 14.sp,
                                                   lineHeight = 18.sp,
                                                   fontWeight = FontWeight(700),
                                                   fontStyle = FontStyle.Normal,
                                                   color = colorResource(id = R.color.pink_dark),
                                                   textAlign = TextAlign.End,
                                                   fontFamily = FontFamily(Font(R.font.roboto_black)),

                                                   )
                                               Text(
                                                   text = "Impact",
                                                   fontSize = 14.sp,
                                                   fontWeight = FontWeight(700),
                                                   fontStyle = FontStyle.Normal,
                                                   color = colorResource(id = R.color.primaryGray),
                                                   lineHeight = 16.sp,
                                                   textAlign = TextAlign.End,
                                                   fontFamily = FontFamily(Font(R.font.roboto_black))

                                               )
                                           }

                                       }
                                   }
                                   /*  Text(
                                       text = "90% Fair",
                                       modifier = Modifier.padding(end = 2.dp),
                                       fontSize = 16.sp,
                                       lineHeight = 16.sp,
                                       fontWeight = FontWeight(700),
                                       fontStyle = FontStyle.Normal,
                                       color = colorResource(id = R.color.orange),
                                       fontFamily = FontFamily(Font(R.font.roboto_black))

                                   )*/

                                   Row(modifier = Modifier.padding(top = 12.dp)) {
                                       Card(
                                           modifier = Modifier
                                               .wrapContentHeight()
                                               .padding(10.dp)
                                               .width(158.dp),
                                           elevation = 4.dp,
                                           shape = RoundedCornerShape(10.dp),
                                           backgroundColor = colorResource(id = R.color.boxgrey)
                                       ) {

                                           Column(
                                               modifier = Modifier
                                                   .fillMaxWidth()
                                                   .padding(all = 15.dp),
                                           ) {
                                               Text(
                                                   modifier = Modifier
                                                       .fillMaxWidth()
                                                       .align(alignment = Alignment.CenterHorizontally),
                                                   text = "60",
                                                   fontSize = 28.sp,
                                                   fontWeight = FontWeight(500),
                                                   textAlign = TextAlign.Left,
                                                   lineHeight = 16.sp,
                                                   color = colorResource(id = R.color.black),
                                                   fontFamily = FontFamily(Font(R.font.roboto_medium))
                                               )

                                               Text(
                                                   modifier = Modifier
                                                       .fillMaxWidth()
                                                       .padding(top = 2.dp)
                                                       .align(alignment = Alignment.CenterHorizontally),
                                                   text = "On Time Payment",
                                                   fontSize = 14.sp,
                                                   lineHeight = 16.sp,
                                                   color = colorResource(id = R.color.black),
                                                   fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                                   textAlign = TextAlign.Left,
                                                   fontWeight = FontWeight(400),
                                               )

                                           }
                                       }
                                       Card(
                                           modifier = Modifier
                                               .wrapContentHeight()
                                               .padding(10.dp)
                                               .width(158.dp),
                                           elevation = 4.dp,
                                           shape = RoundedCornerShape(20.dp),
                                           backgroundColor = colorResource(id = R.color.boxgrey)
                                       ) {

                                           Column(
                                               modifier = Modifier
                                                   .fillMaxWidth()
                                                   .padding(all = 15.dp),
                                           ) {
                                               Text(
                                                   modifier = Modifier
                                                       .fillMaxWidth()
                                                       .align(alignment = Alignment.CenterHorizontally),
                                                   text = "66",
                                                   fontSize = 28.sp,
                                                   fontWeight = FontWeight(500),
                                                   textAlign = TextAlign.Left,
                                                   lineHeight = 16.sp,
                                                   color = colorResource(id = R.color.black),
                                                   fontFamily = FontFamily(Font(R.font.roboto_medium))
                                               )

                                               Text(
                                                   modifier = Modifier
                                                       .fillMaxWidth()
                                                       .padding(top = 2.dp)
                                                       .align(alignment = Alignment.CenterHorizontally),
                                                   text = "Total Payment",
                                                   fontSize = 14.sp,
                                                   lineHeight = 16.sp,
                                                   fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                                   textAlign = TextAlign.Left,
                                                   color = colorResource(id = R.color.black),
                                                   fontWeight = FontWeight(400)
                                               )
                                           }
                                       }
                                   }

                                   cardView()
                               }
                           }
                           Text(
                              modifier = Modifier.padding(top = 20.dp, bottom = 15.dp),
                               text = "Your Credit Activity",
                               fontSize = 18.sp,
                               fontWeight = FontWeight(500),
                               fontStyle = FontStyle.Normal,
                               color = Color.Black,
                               lineHeight = 21.sp,
                               fontFamily = FontFamily(Font(R.font.roboto_medium)),

                               )
                       }
                   } else{
                       ListCreditActivity(item, navController = navController)
                   }
                }
        }

        //CreditActivity(navController = navController)
    }
}

@Composable
fun cardView() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(top = 10.dp, bottom = 15.dp, start = 10.dp,end = 18.dp)
            .width(360.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = colorResource(id = R.color.boxgrey)
    ) {
        Row(modifier = Modifier
            .padding(all = 15.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column() {
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = "90% ",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_black)),
                    textAlign = TextAlign.Left,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight(600)
                )
                Text(
                    text = "Payments made on time has \ndecreased at ",
                    textAlign = TextAlign.Left,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight(500)
                )
            }
            Row(
            verticalAlignment = Alignment.CenterVertically) {


                    Box(
                        modifier = Modifier
                            .background(
                                shape = CircleShape,
                                color = colorResource(id = R.color.white)
                            )
                            .size(77.dp),
                        contentAlignment = Center
                    ) {
                        Column(

                        )
                        {

                            Text(modifier = Modifier
                                .align(CenterHorizontally),
                                text = "High",
                                fontSize = 20.sp,
                                fontWeight = FontWeight(700),
                                fontStyle = FontStyle.Normal,
                                lineHeight = 16.sp,
                                color = colorResource(id = R.color.pink_dark),
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),

                                )


                            Text(
                                modifier = Modifier
                                    .align(CenterHorizontally),
                                text = "Impact",
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                fontStyle = FontStyle.Normal,
                                color = colorResource(id = R.color.primaryGray),
                                lineHeight = 18.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),

                                )

                        }

                    }
            }

        }
    }
}


/*@Composable
fun CreditActivity(navController: NavHostController) {
    Column(modifier = Modifier.padding(top = 20.dp, bottom = 15.dp)) {
        LazyColumn(modifier = Modifier.padding(top = 15.dp)) {
            itemsIndexed(PaymentModel().getList()) { index, item ->


            }
        }
    }
}*/

@Composable
fun ListCreditActivity(
    paymentModel: PaymentModel,
    navController: NavHostController
) {
    var visibleHistory: MutableState<Boolean> = remember { mutableStateOf(false) }
    Column() {
        val bottomPading = if(visibleHistory.value){
            dimensionResource(id = R.dimen.space_0dp)
        }else{
            dimensionResource(id = R.dimen.space_15dp)
        }
        Row(
            modifier = Modifier
                .padding(bottom = bottomPading)
                .fillMaxWidth()
                .background(Color.White)
                .height(70.dp)
                .clickable {
                    visibleHistory.value = !visibleHistory.value
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .align(Alignment.CenterVertically)
                    .height(20.dp)
                    .width(35.dp)
                    ,
                painter = painterResource(id = paymentModel.image!!.toInt()), contentDescription = ""
            )
            Column(modifier = Modifier.padding(start = 6.dp)) {
                Text(
                    text = paymentModel.bankName!!,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    fontStyle = FontStyle.Normal,
                    color = Color.Black,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),

                    )

                Text(
                    text = paymentModel.cardType!!,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    fontStyle = FontStyle.Normal,
                    lineHeight = 18.sp,
                    color = colorResource(id = R.color.primaryGray),
                    fontFamily = FontFamily(Font(R.font.roboto_medium))

                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
                    .clickable {                     visibleHistory.value = !visibleHistory.value
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End

            ) {
                val icon = if (visibleHistory.value)
                    painterResource(id = R.drawable.uparrow)
                else
                    painterResource(id = R.drawable.dropdwn)

                if(paymentModel.isDelayed!!.equals(false)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_info), contentDescription = "",
                        modifier = Modifier
                            .size(27.dp)
                            .padding(start = 8.dp, end = 5.dp),
                        tint = colorResource(id = R.color.orange)
                    )

                }else {""}
                Text(

                    text = paymentModel.payment!!,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    fontStyle = FontStyle.Normal,
                )
                IconButton(modifier = Modifier.align(Alignment.CenterVertically), onClick = {

                }
                ) {
                    Icon(
                        modifier = Modifier
                            .size(14.dp)
                            .align(Alignment.CenterVertically)
                            .clickable {
                                visibleHistory.value = !visibleHistory.value
                            },
                        painter =icon,
                        contentDescription = "",
                        tint = colorResource(id = R.color.light_blue),
                    )
                }
            }
        }
        if (visibleHistory.value) {
            ExpandedCreditList(
                creditList = Month(),
                navController = navController,
                yearWiseStatus = YearWiseStatus(),
                paymentModel =  paymentModel
            )
        }
    }
}