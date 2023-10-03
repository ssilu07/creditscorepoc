package com.example.creditsimulatorpoc.ui
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.creditsimulatorpoc.AppDestinations
import com.example.creditsimulatorpoc.R
import com.michaelKors.android.common.theme.robotoFamily

@Composable
fun CreditScoreScreen(navController: NavHostController) {
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
                        text = "Your Credit Score",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                        fontStyle = FontStyle.Normal,
                        color = colorResource(id = R.color.black),
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_black))
                    )
                },
                backgroundColor = colorResource(id = R.color.light_gray),
            /*    navigationIcon = {
                    IconButton(onClick = {navController.popBackStack(AppDestinations.HOME, false)}) {
                        Icon(
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp),
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "logo"
                        )
                    }
                },*/
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
        content = {
            Box(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .background(color = colorResource(id = R.color.light_gray))
            ) {
                CreditScreenLayout(navController = navController)
            }
        }
    )
}

@Composable
fun CreditScreenLayout(navController: NavHostController) {
    Column(
        modifier = Modifier
            .verticalScroll(
                rememberScrollState()
            )
            .fillMaxHeight()
    ) {
        yourCreditScore()
        Cards()
        CreditScoreHistory()
        Insights(navController = navController)
        creditScoreSimulator()
    }
}

@Composable
fun yourCreditScore() {
    Column {
        /* Text(
             modifier = Modifier.padding(start = 20.dp, top = 20.dp),
             text = stringResource(id = R.string.your_credit_score),
             fontSize = 16.sp,
             lineHeight = 19.sp,
             fontWeight = FontWeight.Medium
         )*/

        Card(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            border = BorderStroke(width = 4.dp, colorResource(id = R.color.white)),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = colorResource(id = R.color.white),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp)
                        .align(Alignment.Start),
                    text = "Your Experian Score",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    maxLines = 1
                )
                Image(
                    modifier = Modifier.height(250.dp),
                    painter = painterResource(id = R.drawable.chart6),
                    contentDescription = ""
                )

                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    text = "You're in a good shape. Better Score\ncan help you get credit at attractive\ninterest rates.",
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 16.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily(Font(R.font.roboto_medium))
                )

                Button(
                    modifier = Modifier
                        .padding(top = 20.dp, start = 12.dp, end = 12.dp)
                        .width(300.dp)
                        .height(56.dp),
                    border = BorderStroke(
                        1.dp, colorResource(
                            id = R.color.pink_dark
                        )
                    ),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Red, backgroundColor = colorResource(
                            id = R.color.pink_dark
                        )
                    ),
                    onClick = { }) {
                    Text(
                        text = "VIEW CREDIT REPORT",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = robotoFamily,
                        maxLines = 1
                    )
                }

                Button(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 12.dp, end = 12.dp, bottom = 16.dp)
                        .width(300.dp)
                        .height(56.dp),
                    border = BorderStroke(1.dp, color = colorResource(id = R.color.pink_dark)),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = colorResource(id = R.color.pink_dark),
                        backgroundColor = colorResource(
                            id = R.color.white
                        )
                    ),
                    onClick = { }) {
                    Text(
                        text = "BOOST MY SCORE",
                        color = colorResource(id = R.color.pink_dark),
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Composable
fun Cards() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Card(
            modifier = Modifier
                .size(height = 167.dp, width = 170.dp)
                .background(
                    color = colorResource(
                        id = R.color.gray_light_few
                    )
                ),
            backgroundColor = colorResource(id = R.color.white),
        ) {
            Column {

                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 6.dp),
                    text = "TransUnion",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 18.sp,
                )

                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp),
                    text = "Score",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 18.sp,
                )

                Row(modifier = Modifier.padding(start = 10.dp, top = 16.dp)) {
                    Text(
                        text = "670",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Medium,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start,
                        lineHeight = 24.sp,
                    )

                    Row(modifier = Modifier.padding(start = 6.dp, top = 16.dp)) {

                        Image(
                            modifier = Modifier.size(width = 9.dp, height = 9.dp),
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(color = colorResource(id = R.color.dark_gray))
                        )
                        Text(
                            text = "9",
                            color = colorResource(id = R.color.dark_gray),
                            fontWeight = FontWeight.Medium,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Start,
                            lineHeight = 9.sp,
                        )
                    }
                }

                Image(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 11.dp),
                    painter = painterResource(id = R.drawable.ic_dashed_line),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 11.dp, bottom = 4.dp),
                    text = "Last updated on\n20 Nov",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 18.sp,
                )

            }
        }

        Card(
            modifier = Modifier
                .size(height = 165.dp, width = 170.dp)
                .background(
                    color = colorResource(
                        id = R.color.white
                    )
                ),
            backgroundColor = colorResource(id = R.color.white),
        ) {
            Column(

            ) {

                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 6.dp),
                    text = "Equifax",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 18.sp,
                )

                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 6.dp),
                    text = "Score",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 18.sp,
                )

                Row(modifier = Modifier.padding(start = 10.dp, top = 16.dp)) {
                    Text(
                        text = "692",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Medium,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start,
                        lineHeight = 24.sp,
                    )

                    Row(modifier = Modifier.padding(start = 6.dp, top = 16.dp)) {

                        Image(
                            modifier = Modifier.size(width = 9.dp, height = 9.dp),
                            painter = painterResource(id = R.drawable.arrow_up),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(color = colorResource(id = R.color.dark_gray))

                        )
                        Text(
                            text = "14",
                            color = colorResource(id = R.color.dark_gray),
                            fontWeight = FontWeight.Medium,
                            fontSize = 9.sp,
                            textAlign = TextAlign.Start,
                            lineHeight = 9.sp,
                        )
                    }
                }

                Image(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 11.dp),
                    painter = painterResource(id = R.drawable.ic_dashed_line),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 11.dp, bottom = 4.dp),
                    text = "Last updated on\n21 Nov",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 18.sp,
                )

            }
        }
    }


}

@Composable
fun CreditScoreHistory() {

    Text(
        modifier = Modifier.padding(start = 16.dp, top = 24.dp),
        text = "Credit Score History",
        color = colorResource(id = R.color.black),
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        textAlign = TextAlign.Start,
        lineHeight = 21.sp,
        fontFamily = FontFamily(Font(R.font.roboto_medium))
    )

        Column() {
            Image(
                modifier = Modifier.padding(18.dp),
                painter = painterResource(id = R.drawable.chart8),
                contentDescription = "",
            )
    }
}

@Composable
fun Insights(navController: NavHostController) {
    Text(
        modifier = Modifier.padding(start = 20.dp, top = 20.dp),
        text = "Insights",
        fontSize = 16.sp,
        lineHeight = 19.sp,
        fontWeight = FontWeight.Medium
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                modifier = Modifier
                    .width(170.dp)
                    .wrapContentHeight()
                    .padding(top = 20.dp)
                    .background(
                        color = colorResource(
                            id = R.color.gray_light_few
                        )
                    ),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = colorResource(id = R.color.white),
            ) {
                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                modifier = Modifier,
                                text = "Overall\nPayment\nHistory",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 18.sp,
                            )

                            Text(
                                modifier = Modifier.padding(top = 2.dp),
                                text = "Fair",
                                color = colorResource(id = R.color.primary_gray),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 16.sp,
                            )
                        }

                        Column(modifier = Modifier.padding(end = 10.dp, top = 6.dp)) {
                            Text(
                                modifier = Modifier,
                                text = "High",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 16.sp,
                            )

                            Text(
                                modifier = Modifier,
                                text = "Impact",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 18.sp,
                            )
                        }
                    }

                    Row(modifier = Modifier.padding(start = 10.dp, top = 23.dp)) {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .width(106.dp)
                                .height(12.dp)
                                .shadow(shape = RoundedCornerShape(20.dp), elevation = 2.dp),
                            color = colorResource(id = R.color.purple_dark),
                            progress = 0.9f,
                            backgroundColor = colorResource(id = R.color.purple_dark).copy(alpha = 0.2f)
                        )
                        Text(
                            modifier = Modifier.padding(start = 11.dp),
                            text = "90%",
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Start,
                            lineHeight = 16.sp,
                        )
                    }

                    Text(
                        modifier = Modifier.padding(start = 10.dp, top = 8.dp),
                        text = "60 On time Payments",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium))
                    )

                    Row(modifier = Modifier.padding(start = 10.dp, top = 15.dp)) {
                        LinearProgressIndicator(
                            modifier = Modifier
                                .width(106.dp)
                                .height(12.dp)
                                .shadow(shape = RoundedCornerShape(20.dp), elevation = 2.dp),
                            color = colorResource(id = R.color.button_purple),
                            progress = 0.1f,
                            backgroundColor = colorResource(id = R.color.button_purple).copy(alpha = 0.2f)
                        )
                        Text(
                            modifier = Modifier.padding(start = 11.dp),
                            text = "10%",
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Start,
                            lineHeight = 16.sp,
                        )
                    }
                    Text(
                        modifier = Modifier.padding(start = 10.dp, top = 8.dp),
                        text = "6 Late Payments",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium))
                    )

                    Button(
                        modifier = Modifier
                            .padding(top = 24.dp, start = 10.dp, end = 10.dp, bottom = 16.dp)
                            .width(137.dp)
                            .height(42.dp)
                            .align(Alignment.CenterHorizontally),
                        border = BorderStroke(1.dp, colorResource(id = R.color.button_purple)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = colorResource(id = R.color.button_purple),
                            backgroundColor = colorResource(
                                id = R.color.white
                            )
                        ),
                        onClick = { navController.navigate(AppDestinations.ACTIVITYSTATUS) }) {
                        Text(
                            text = "GET INFO",
                            color = colorResource(id = R.color.button_purple),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            maxLines = 1
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .width(170.dp)
                    .wrapContentHeight()
                    .padding(top = 20.dp)
                    .background(
                        color = colorResource(
                            id = R.color.gray_light_few
                        )
                    ),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = colorResource(id = R.color.white),
            ) {
                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column() {
                            Text(
                                modifier = Modifier,
                                text = "Credit\nCard\nUtilization",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 18.sp,
                            )

                            Text(
                                modifier = Modifier.padding(top = 2.dp),
                                text = "Good",
                                color = colorResource(id = R.color.primary_gray),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 16.sp,
                            )
                        }

                        Column(modifier = Modifier.padding(end = 10.dp)) {
                            Text(
                                modifier = Modifier,
                                text = "High",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 16.sp,
                            )

                            Text(
                                modifier = Modifier,
                                text = "Impact",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 16.sp,
                            )
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(start = 10.dp, top = 14.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            CircularProgressIndicator(
                                modifier = Modifier
                                    .width(46.dp)
                                    .height(46.dp),
                                strokeWidth = 6.dp,
                                color = colorResource(id = R.color.text_purple),
                                progress = 0.3f
                            )
                            Text(
                                modifier = Modifier,
                                text = "30%",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Medium,
                                fontSize = 11.sp,
                                textAlign = TextAlign.Center,
                                lineHeight = 16.sp,
                            )
                        }

                        Column(modifier = Modifier.padding(start = 10.dp, top = 6.dp)) {
                            Text(
                                modifier = Modifier,
                                text = "Credit Card Debt",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Font(R.font.inter_medium))
                            )

                            Text(
                                modifier = Modifier,
                                text = "£ 21,851",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Normal,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Font(R.font.inter_medium))
                            )
                        }

                    }

                    Text(
                        modifier = Modifier.padding(start = 10.dp, top = 16.dp),
                        text = "Total Credit Card Limit",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium))
                    )

                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "£ 72,839",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium))
                    )

                    Button(
                        modifier = Modifier
                            .padding(top = 19.dp, start = 10.dp, end = 10.dp, bottom = 16.dp)
                            .width(137.dp)
                            .height(42.dp)
                            .align(Alignment.CenterHorizontally),
                        border = BorderStroke(1.dp, colorResource(id = R.color.button_purple)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = colorResource(id = R.color.button_purple),
                            backgroundColor = colorResource(
                                id = R.color.white
                            )
                        ),
                        onClick = { }) {
                        Text(
                            text = "GET INFO",
                            color = colorResource(id = R.color.button_purple),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                modifier = Modifier
                    .width(170.dp)
                    .wrapContentHeight()
                    .padding(top = 20.dp)
                    .background(
                        color = colorResource(
                            id = R.color.gray_light_few
                        )
                    ),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = colorResource(id = R.color.white),
            ) {
                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column() {
                            Text(
                                modifier = Modifier,
                                text = "Length\nOf Credit\nHistory",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 18.sp,
                            )

                            Text(
                                modifier = Modifier.padding(top = 2.dp),
                                text = "Excellent",
                                color = colorResource(id = R.color.primary_gray),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 16.sp,
                            )
                        }

                        Column(modifier = Modifier.padding(end = 10.dp, top = 6.dp)) {
                            Text(
                                modifier = Modifier,
                                text = "Medium",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 16.sp,
                            )

                            Text(
                                modifier = Modifier,
                                text = "Impact",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 18.sp,
                            )
                        }
                    }

                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(top = 40.dp),
                        painter = painterResource(id = R.drawable.chart3),
                        contentDescription = ""
                    )


                    Button(
                        modifier = Modifier
                            .padding(top = 32.dp, start = 10.dp, end = 10.dp, bottom = 16.dp)
                            .width(137.dp)
                            .height(42.dp)
                            .align(Alignment.CenterHorizontally),
                        border = BorderStroke(1.dp, colorResource(id = R.color.button_purple)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = colorResource(id = R.color.button_purple),
                            backgroundColor = colorResource(
                                id = R.color.white
                            )
                        ),
                        onClick = { }) {
                        Text(
                            text = "GET INFO",
                            color = colorResource(id = R.color.button_purple),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            maxLines = 1
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    //  .size(height = 248.dp, width = 150.dp)
                    .width(170.dp)
                    .wrapContentHeight()
                    .padding(top = 20.dp)
                    .background(
                        color = colorResource(
                            id = R.color.gray_light_few
                        )
                    ),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = colorResource(id = R.color.white),
            ) {
                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, top = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column() {
                            Text(
                                modifier = Modifier,
                                text = "New\nCredit",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 18.sp,
                            )

                            Text(
                                modifier = Modifier.padding(top = 2.dp),
                                text = "Poor",
                                color = colorResource(id = R.color.primary_gray),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 16.sp,
                            )
                        }

                        Column(modifier = Modifier.padding(end = 10.dp, top = 6.dp)) {
                            Text(
                                modifier = Modifier,
                                text = "Low",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 16.sp,
                            )

                            Text(
                                modifier = Modifier,
                                text = "Impact",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 18.sp,
                            )
                        }
                    }

                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(top = 20.dp),
                        painter = painterResource(id = R.drawable.chart9),
                        contentDescription = ""
                    )


                    Button(
                        modifier = Modifier
                            .padding(top = 28.dp, start = 10.dp, end = 10.dp, bottom = 16.dp)
                            .width(137.dp)
                            .height(42.dp)
                            .align(Alignment.CenterHorizontally),
                        border = BorderStroke(1.dp, colorResource(id = R.color.button_purple)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = colorResource(id = R.color.button_purple),
                            backgroundColor = colorResource(
                                id = R.color.white
                            )
                        ),
                        onClick = { }) {
                        Text(
                            text = "GET INFO",
                            color = colorResource(id = R.color.button_purple),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp)
        ) {

            Card(
                modifier = Modifier
                    //  .size(height = 248.dp, width = 150.dp)
                    .width(170.dp)
                    .wrapContentHeight()
                    .padding(top = 20.dp)
                    .background(
                        color = colorResource(
                            id = R.color.gray_light_few
                        )
                    ),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = colorResource(id = R.color.white),
            ) {
                Column(modifier = Modifier.padding(start = 10.dp)) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column() {
                            Text(
                                modifier = Modifier,
                                text = "Credit\nMix",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 18.sp,
                            )

                            Text(
                                modifier = Modifier.padding(top = 2.dp),
                                text = "Fair",
                                color = colorResource(id = R.color.primary_gray),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.Start,
                                lineHeight = 16.sp,
                            )
                        }

                        Column(modifier = Modifier.padding(end = 10.dp, top = 6.dp)) {
                            Text(
                                modifier = Modifier,
                                text = "Low",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 16.sp,
                            )

                            Text(
                                modifier = Modifier,
                                text = "Impact",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                lineHeight = 18.sp,
                            )
                        }
                    }

                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(top = 34.dp),
                        painter = painterResource(id = R.drawable.chart5),
                        contentDescription = ""
                    )

                    Button(
                        modifier = Modifier
                            .padding(top = 20.dp, /*start = 10.dp, end = 10.dp,*/ bottom = 16.dp)
                            .width(137.dp)
                            .height(42.dp)
                            .align(Alignment.CenterHorizontally),
                        border = BorderStroke(1.dp, colorResource(id = R.color.button_purple)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = colorResource(id = R.color.button_purple),
                            backgroundColor = colorResource(
                                id = R.color.white
                            )
                        ),
                        onClick = { }) {
                        Text(
                            text = "GET INFO",
                            color = colorResource(id = R.color.button_purple),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        )

                    }
                }
            }
        }

    }
}

@Composable
fun creditScoreSimulator(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                //  .size(height = 196.dp, width = 320.dp)
                //  .width(358.dp)
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(top = 20.dp, bottom = 12.dp, start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = colorResource(id = R.color.white),
        ) {

            Column() {

                Row() {
                    Column() {

                        Text(
                            modifier = Modifier.padding(start = 16.dp, top = 34.dp),
                            text = "Introduce",
                            color = colorResource(id = R.color.primaryGray),
                            fontWeight = FontWeight.Normal,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start,
                            lineHeight = 21.sp,
                        )
                        Text(
                            modifier = Modifier.padding(start = 16.dp, top = 5.dp),
                            text = "Credit Score\nSimulator",
                            color = colorResource(id = R.color.light_blue),
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            lineHeight = 29.sp,
                        )

                        Button(
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                                .padding(top = 15.dp, start = 16.dp)
                            ,
                            border = BorderStroke(1.dp, colorResource(id = R.color.button_purple)),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = colorResource(id = R.color.button_purple),
                                backgroundColor = colorResource(
                                    id = R.color.button_purple
                                )
                            ),
                            onClick = { }) {
                            Text(
                                text = "SIMULATE SCORE",
                                color = colorResource(id = R.color.white),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 18.sp,
                                fontStyle = FontStyle.Normal,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            )
                        }
                    }
                    Image(
                        modifier = Modifier
                            .padding(top = 23.dp)
                            .size(width = 203.dp, height = 178.dp),
                        painter = painterResource(id = R.drawable.creditscoreimg),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}
