package com.example.creditsimulatorpoc.ui.views

import android.app.Activity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.creditsimulatorpoc.AppDestinations
import com.example.creditsimulatorpoc.R
import com.example.creditsimulatorpoc.data.Cards
import com.example.creditsimulatorpoc.ui.common.PagerTabView
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.michaelKors.android.common.theme.robotoFamily
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    toolBar(navController = navController)
}

@Composable
fun toolBar(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            /*TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = ""
                    )
                },
                backgroundColor = colorResource(id = R.color.light_gray),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp),
                            painter = painterResource(id = R.drawable.applogo),
                            contentDescription = "logo"
                        )
                    }
                },
                contentColor = Color.White,
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp),
                            painter = painterResource(id = R.drawable.bell),
                            contentDescription = "Share",
                            tint = Color.White
                        )
                    }
                }

            )*/
        },
        content = {
            Box(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .background(color = colorResource(id = R.color.light_gray))
            ) {
                homeScreenLayout(navController = navController)
                fabButton()
            }
        }
    )
}

@Composable
fun homeScreenLayout(navController: NavHostController) {

    val numbers: Array<Int> = Array(0) { it }
    Column(
        modifier = Modifier
            .verticalScroll(
                rememberScrollState()
            )
            .fillMaxHeight()

    ) {
        topItems()
        LazyRowExample(numbers)
        YourCreditScore(navController = navController)
        CreditDebtSummary()
        topOffer()
        featuredText()
        LazyRowFeatured(numbers)
       // ReviewScreen()
    }
}

@Composable
fun topItems() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .size(height = 53.dp, width = 53.dp),
            painter = painterResource(id = R.drawable.manlogo), contentDescription = "",
            contentScale = ContentScale.Crop,
        )
        Column() {
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Welcome",
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontStyle = FontStyle.Normal,
                color = colorResource(id = R.color.black),
                fontSize = 16.sp,
                lineHeight = 20.sp
            )
            Text(
                modifier = Modifier,
                text = "Robert Clarke",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                lineHeight = 26.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                color = colorResource(id = R.color.black),
                fontStyle = FontStyle.Normal
            )
        }

        Box(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(10.dp),
            Alignment.CenterEnd
        ) {
            Image(
                modifier = Modifier
                    .padding(top = 5.dp, end = 10.dp)
                    .height(24.dp)
                    .width(24.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.ic_bell), contentDescription = "",
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(colorResource(id = R.color.black))
            )
        }
    }
}

@Composable
fun YourCreditScore(navController: NavHostController) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(top = 20.dp)
            .fillMaxWidth(),
        border = BorderStroke(width = 4.dp, colorResource(id = R.color.white)),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp) ,
        backgroundColor = colorResource(id = R.color.white)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Your Credit Score",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                maxLines = 1
            )
            Image(modifier = Modifier.height(250.dp)
                ,painter = painterResource(id = R.drawable.chart6), contentDescription = "")
            Button(
                modifier = Modifier
                    .padding(top = 10.dp, start = 44.dp, end = 46.dp)
                    .width(300.dp)
                    .height(56.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Red, backgroundColor = colorResource(
                        id = R.color.pink_dark
                    )
                ),
                shape = RoundedCornerShape(8.dp),
                onClick = { }) {

                Text(
                    text = "VIEW CREDIT REPORT",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    maxLines = 1
                )
            }
            Text(
                buildAnnotatedString {
                    append("There are a few things influencing Your Score.")

                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, color = colorResource(
                        id = R.color.button_purple
                    ))) {
                        append("Check Here")
                    }
                },
                modifier = Modifier
                    .padding(start = 73.dp, top = 16.dp, end = 73.dp),
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp,
            )


            Button(
                modifier = Modifier
                    .padding(top = 16.dp, start = 12.dp, end = 12.dp, bottom = 16.dp)
                    .width(300.dp)
                    .height(56.dp),
                border = BorderStroke(1.dp, color = colorResource(id = R.color.pink_dark)),
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
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    maxLines = 1
                )

            }
        }
    }
}


@Composable
fun BottomBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        backgroundColor = Color.White,
    ) {

        BottomNavigationItem(
            icon = {
                Icon(
                    modifier = Modifier
                        .height(18.dp)
                        .width(18.dp),
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = ""
                )
            },
            alwaysShowLabel = true,
            label = { Text(text = "Home",maxLines = 1, fontSize = 10.sp) },
            selected = currentDestination?.hierarchy?.any { it.route == AppDestinations.HOME } == true,
            onClick = {
                navController.navigate(AppDestinations.HOME){
                    popUpTo(AppDestinations.HOME)
                    launchSingleTop = true
                }
            },
            selectedContentColor = colorResource(id = R.color.pink_dark),
            unselectedContentColor = Color.Gray
        )

        BottomNavigationItem(
            icon = {
                Icon(
                    modifier = Modifier
                        .height(18.dp)
                        .width(18.dp),
                    painter = painterResource(id = R.drawable.credit),
                    contentDescription = ""
                )
            },
            alwaysShowLabel = true,
            label = { Text(text = "Credit score",maxLines = 1, fontSize = 10.sp) },
            selected = currentDestination?.hierarchy?.any { it.route == AppDestinations.CreditScreen } == true,
            onClick = {
                navController.navigate(AppDestinations.CreditScreen){
                    popUpTo(AppDestinations.HOME)
                }
            },
            selectedContentColor = colorResource(id = R.color.pink_dark),
            unselectedContentColor = Color.Gray
        )

        BottomNavigationItem(icon = {
            Icon(
                modifier = Modifier
                    .height(18.dp)
                    .width(18.dp),
                painter = painterResource(id = R.drawable.card),
                contentDescription = ""
            )
        },
            label = { Text(text = "Loan & Cards",maxLines = 1, fontSize = 10.sp) },
            selected = currentDestination?.hierarchy?.any { it.route == AppDestinations.LOANS } == true,
            onClick = {

            },
            selectedContentColor = colorResource(id = R.color.pink_dark),
            unselectedContentColor = Color.Gray
        )

        BottomNavigationItem(icon = {
            Icon(
                modifier = Modifier
                    .height(18.dp)
                    .width(18.dp),
                painter = painterResource(id = R.drawable.profile),
                contentDescription = ""
            )
        },
            label = { Text(text = "Profile",maxLines = 1, fontSize = 10.sp) },
            selected = currentDestination?.hierarchy?.any { it.route == AppDestinations.PROFILE } == true,
            onClick = {

            },
            selectedContentColor = colorResource(id = R.color.pink_dark),
            unselectedContentColor = Color.Gray)
    }

}

@Composable
fun RowItem(number: Int) {
    Card(
        modifier = Modifier
            .height(222.dp)
            .width(208.dp)
            .fillMaxHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = colorResource(id = R.color.purple_dark)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    text = "Your Goal",
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
                    text = "742",
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
                    text = "Keep Going",
                    color = colorResource(id = R.color.gray_light),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    fontFamily = robotoFamily,
                    maxLines = 2

                )
            }

            Box() {
                Image(
                    modifier = Modifier
                        .height(226.dp)
                        .width(226.dp),
                    painter = painterResource(id = R.drawable.ellipse_14_right),
                    contentDescription = "",
                    alignment = Alignment.BottomEnd
                )

                Image(
                    modifier = Modifier
                        .height(124.dp)
                        .width(124.dp),
                    painter = painterResource(id = R.drawable.ellipse_15_right),
                    contentDescription = "",
                    alignment = Alignment.BottomEnd
                )

                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 20.dp)
                        .align(Alignment.BottomStart)
                ) {
                    Box(
                        modifier = Modifier
                            .height(54.dp)
                            .width(54.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "62",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = colorResource(id = R.color.purple_dark)
                            )
                        }
                    }
                    Text(
                        modifier = Modifier,
                        text = "Points to go",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }


            }
        }
    }

    Card(
        modifier = Modifier
            .height(222.dp)
            .width(208.dp)
            .padding(start = 16.dp)
            .fillMaxHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = colorResource(id = R.color.button_purple)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    text = "Credit Simulator",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = robotoFamily
                )
            }
            Row() {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 6.dp),
                    text = "Estimate Your Score range\nScore are accurate 90%",
                    color = colorResource(id = R.color.gray_light),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = robotoFamily,
                    maxLines = 2

                )
            }

            Box() {
                Image(
                    modifier = Modifier
                        .height(226.dp)
                        .width(226.dp),
                    painter = painterResource(id = R.drawable.ellipse_14),
                    contentDescription = "",
                    alignment = Alignment.BottomStart
                )
                Image(
                    modifier = Modifier
                        .height(124.dp)
                        .width(124.dp),
                    painter = painterResource(id = R.drawable.ellipse_15),
                    contentDescription = "",
                    alignment = Alignment.BottomStart

                )

                Button(
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, bottom = 10.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    border = BorderStroke(1.dp, Color.White),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        backgroundColor = Color.Transparent
                    ),
                    elevation = null,
                    onClick = { }) {
                    Text(
                        text = "SIMULATE SCORE",
                        color = Color.White,
                        fontSize = 12.sp,
                        maxLines = 1,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.roboto_medium))
                    )
                }
            }


        }
    }

    Card(
        modifier = Modifier
            .height(222.dp)
            .width(208.dp)
            .padding(start = 16.dp)
            .fillMaxHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = colorResource(id = R.color.light_blue)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    text = "Credit Score",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = robotoFamily
                )
                Text(
                    modifier = Modifier.padding(
                        top = 16.dp,
                        end = 16.dp
                    ),
                    text = "680",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Right,
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontFamily = robotoFamily
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    modifier = Modifier.padding( top = 6.dp),
                    text = "Compare Last\n3 months",
                    color = colorResource(id = R.color.gray_light),
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    maxLines = 2

                )
                Row(
                ) {

                    Image(
                        modifier = Modifier
                            .padding(top = 12.dp, start = 5.dp)
                            .height(10.dp),
                        painter = painterResource(id = R.drawable.arrow_up),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),


                    )
                    Text(
                        modifier = Modifier.padding(top = 6.dp, start = 5.dp),
                        text = "12",
                        color = Color.White,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.End,
                        fontSize = 14.sp,
                        lineHeight = 24.sp,
                        fontFamily = robotoFamily
                    )
                }


            }

            Box() {
                Image(
                    modifier = Modifier
                        .height(226.dp)
                        .width(226.dp),
                    painter = painterResource(id = R.drawable.ellipse_14),
                    contentDescription = "",
                    alignment = Alignment.BottomStart
                )
                Image(
                    modifier = Modifier
                        .height(226.dp)
                        .width(226.dp)
                        .padding(bottom = 16.dp),
                    painter = painterResource(id = R.drawable.vector_29),
                    contentDescription = "",
                    alignment = Alignment.BottomStart
                )
                Image(
                    modifier = Modifier
                        .height(110.dp)
                        .width(110.dp),
                    painter = painterResource(id = R.drawable.ellipse_15),
                    contentDescription = "",
                    alignment = Alignment.BottomStart

                )
            }


        }
    }
}

@Composable
fun LazyRowExample(numbers: Array<Int>) {

    LazyRow(
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            RowItem(number = 0)
        }
        items(0) { currentCount ->
            RowItem(number = currentCount)
        }
        items(numbers) { arrayItem ->
            RowItem(number = arrayItem)
        }
        itemsIndexed(numbers) { index: Int, item: Int ->
            RowItem(number = index)
        }
    }
}

@Composable
fun featuredText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = "Featured Articles",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 21.sp,
            color = colorResource(id = R.color.black),
            fontFamily = FontFamily(Font(R.font.roboto_medium))
        )
        Box(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            Alignment.CenterEnd
        ) {
            Image(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.arrow_right), contentDescription = "",
                contentScale = ContentScale.Fit,
            )
        }
    }
}

@Composable
fun RowItemfeatured(number: Int) {

    Card(
        modifier = Modifier
            .height(188.dp)
            .width(206.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.LightGray
    ) {
        Column() {
            Image(
                modifier = Modifier.size(width = 206.dp, height = 130.dp),
                painter = painterResource(id = R.drawable.featured_1),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(colorResource(id = R.color.white))
                    .padding(start = 12.dp, top = 12.dp),
                text = "Looking to improve your\nnumber skills",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                lineHeight = 18.sp
            )
        }
    }

    Card(
        modifier = Modifier
            .height(188.dp)
            .width(206.dp)
            .padding(start = 16.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.LightGray
    ) {
        Column() {
            Image(
                modifier = Modifier.size(width = 206.dp, height = 130.dp),
                painter = painterResource(id = R.drawable.featured_2),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(colorResource(id = R.color.white))
                    .padding(start = 12.dp, top = 12.dp),
                text = "5 ways to improve your\ncredit score and your",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                lineHeight = 18.sp
            )
        }
    }
}

@Composable
fun LazyRowFeatured(numbers: Array<Int>) {
    LazyRow(
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            RowItemfeatured(number = 0)
        }
        items(0) { currentCount ->
            RowItemfeatured(number = currentCount)
        }
        items(numbers) { arrayItem ->
            RowItemfeatured(number = arrayItem)
        }
        itemsIndexed(numbers) { index: Int, item: Int ->
            RowItemfeatured(number = index)
        }
    }
}


@Composable
fun fabButton() {
    Box(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(bottom = 20.dp, end = 18.dp),
        Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = { },
            backgroundColor = colorResource(id = R.color.button_purple),
            modifier = Modifier.size(58.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.chatbot),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CorouselImages(
    cardsData: List<Cards>,
    currentPage: MutableState<Int>,
) {

    val pagerState =
        rememberPagerState(pageCount = cardsData.size, initialPage = currentPage.value)

    Column() {
        Box {
            HorizontalPager(
                state = pagerState,
            ) { index ->
                Column(
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            start = 8.dp,
                            end = 8.dp
                        )
                        .fillMaxHeight()
                        .align(alignment = Alignment.Center)
                        .clearAndSetSemantics { },
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .height(222.dp)
                            .width(208.dp)
                            .fillMaxHeight(),
                        elevation = 4.dp,
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = cardsData[index].backgroundColor
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                                    text = cardsData[index].title,
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
                                    text = cardsData[index].mainNumber,
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
                                    text = cardsData[index].subtitle,
                                    color = colorResource(id = R.color.gray_light),
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    lineHeight = 24.sp,
                                    fontFamily = robotoFamily,
                                    maxLines = 2

                                )
                                Text(
                                    modifier = Modifier.padding(start = 50.dp, top = 6.dp),
                                    text = cardsData[index].subNumber,
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

                }
            }
        }
        if (cardsData.size > 1) {
            currentPage.value = pagerState.currentPage
            val scope = rememberCoroutineScope()
            PagerTabView(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(alignment = Alignment.CenterHorizontally),
                pagerState = pagerState,
                size = cardsData.size,
                contentDescriptionTabName = "",
                onTabClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(page = it)
                    }
                }
            )
        }
    }
}

@Composable
fun CreditDebtSummary() {
    Row(
        modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier,
            text = "Credit Debt Summary",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 21.sp,
            color = colorResource(id = R.color.black),
            fontFamily = FontFamily(Font(R.font.roboto_medium))
        )
        Box(
            Modifier
                .fillMaxWidth(),
            Alignment.CenterEnd
        ) {
            Image(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.arrow_right), contentDescription = "",
                contentScale = ContentScale.Fit,
            )
        }
    }
    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = colorResource(id = R.color.white)
    ) {
        Column(modifier = Modifier.padding(top = 20.dp, bottom = 24.dp)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "4 Credit Cards",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Start,
                    color = colorResource(id = R.color.black),
                )

                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    Alignment.CenterEnd
                ) {
                    Text(
                        modifier = Modifier,
                        text = "16%",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.End,
                        color = colorResource(id = R.color.text_purple),
                    )
                }
            }

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                color = colorResource(id = R.color.text_purple),
                progress = 0.3f,
                backgroundColor = colorResource(id = R.color.text_purple).copy(alpha = 0.2f)
            )

            Row(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(width = 11.dp, height = 16.dp),
                    painter = painterResource(id = R.drawable.arrow_down), contentDescription = "",
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.primary_gray))
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp,bottom = 3.dp),
                    text = "12 percent less than national average",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    color = colorResource(id = R.color.primary_gray),
                )
            }

            Row(modifier = Modifier.padding(start = 16.dp, top = 20.dp)) {
                Text(
                    text = "2 Personal Loans",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = colorResource(id = R.color.black),
                )

                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    Alignment.CenterEnd
                ) {
                    Text(
                        modifier = Modifier,
                        text = "28%",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.End,
                        color = colorResource(id = R.color.dark_Pink),
                    )
                }
            }

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                color = colorResource(id = R.color.dark_Pink),
                progress = 0.3f,
                backgroundColor = colorResource(id = R.color.dark_Pink).copy(alpha = 0.2f)
            )

            Row(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(width = 11.dp, height = 16.dp),
                    painter = painterResource(id = R.drawable.arrow_down), contentDescription = "",
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.primary_gray))
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp,bottom = 3.dp),
                    text = "20 percent less than national average",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    color = colorResource(id = R.color.primary_gray),
                )
            }

            Row(modifier = Modifier.padding(start = 16.dp, top = 20.dp)) {

                Text(
                    text = "1 Housing Loan",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = colorResource(id = R.color.black),
                )

                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    Alignment.CenterEnd
                ) {
                    Text(
                        modifier = Modifier,
                        text = "48%",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.End,
                        color = colorResource(id = R.color.purple_dark),
                    )
                }
            }

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                color = colorResource(id = R.color.purple_dark),
                progress = 0.3f,
                backgroundColor = colorResource(id = R.color.purple_dark).copy(alpha = 0.2f)

            )

            Row(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(width = 11.dp, height = 16.dp),
                    painter = painterResource(id = R.drawable.arrow_up), contentDescription = "",
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.primary_gray))
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp,bottom = 3.dp),
                    text = "12 percent more than national average",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    color = colorResource(id = R.color.primary_gray),
                )
            }

            Row(modifier = Modifier.padding(start = 16.dp, top = 20.dp)) {
                Text(
                    text = "1 Other Loan",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    color = colorResource(id = R.color.black),
                )
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    Alignment.CenterEnd
                ) {
                    Text(
                        modifier = Modifier,
                        text = "8%",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.End,
                        color = colorResource(id = R.color.progressbar_color),
                    )
                }
            }

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                color = colorResource(id = R.color.button_purple),
                progress = 0.3f,
                backgroundColor = colorResource(id = R.color.progressbar_color).copy(alpha = 0.2f)

            )

            Row(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(width = 11.dp, height = 16.dp),
                    painter = painterResource(id = R.drawable.arrow_down), contentDescription = "",
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.primary_gray))
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp,bottom = 3.dp),
                    text = "12 percent less than national average",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    color = colorResource(id = R.color.primary_gray),
                )
            }

        }
    }
}

@Composable
fun topOffer(){

    Row(modifier = Modifier.padding(start = 16.dp, top = 24.dp)) {

        Text(
            text = "Top Offers for you",
            fontSize = 18.sp,
            fontWeight = FontWeight(500),
            fontStyle = FontStyle.Normal,
            color = colorResource(id = R.color.black),
            fontFamily = FontFamily(Font(R.font.roboto_medium))
        )

        Box(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(10.dp),
            Alignment.CenterEnd
        ) {
            Image(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.arrow_right), contentDescription = "",
                contentScale = ContentScale.Fit,
            )
        }
    }

    Card(
        modifier = Modifier
            .padding(16.dp)
            // .height(136.dp)
            .wrapContentHeight()
            .fillMaxWidth()
         //   .width(358.dp)
            ,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White
    ) {

        Column() {
            Text(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "Now you get loan upto",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle.Normal,
                color = colorResource(id = R.color.black),
                fontFamily = FontFamily(Font(R.font.roboto_medium))
            )

            Text(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                text = "£ 72,839",
                fontSize = 29.sp,
                fontWeight = FontWeight(700),
                fontStyle = FontStyle.Normal,
                color = colorResource(id = R.color.black),
                fontFamily = FontFamily(Font(R.font.roboto_bold))
            )

            Row(
                modifier = Modifier.padding(start = 16.dp,top = 8.dp,bottom =16.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Bottom),
                    text = "Get instant access to an\naffordable loans on your terms!",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    fontStyle = FontStyle.Normal,
                    lineHeight = 16.sp,
                    color = colorResource(id = R.color.black),
                    fontFamily = FontFamily(Font(R.font.roboto_medium))
                )

                Button(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .width(150.dp)
                        .height(56.dp),
                    border = BorderStroke(1.dp, color = colorResource(id = R.color.pink_dark)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = colorResource(id = R.color.pink_dark),
                        backgroundColor = colorResource(
                            id = R.color.white
                        )
                    ),
                    onClick = { }) {
                    Text(
                        text = "APPLY NOW",
                        color = colorResource(id = R.color.pink_dark),
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        maxLines = 1
                    )

                }

            }
        }
    }

}


