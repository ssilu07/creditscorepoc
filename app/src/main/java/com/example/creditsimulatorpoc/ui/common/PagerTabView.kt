package com.example.creditsimulatorpoc.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.example.creditsimulatorpoc.R

@ExperimentalPagerApi
@Composable
fun PagerTabView(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    size: Int,
    contentDescriptionTabName: String?,
    onTabClick: (Int) -> Unit,
) {
    Column(modifier = modifier) {
        TabRow(
            modifier = modifier
                .width(((size + 1) * 14).dp)
                .align(alignment = Alignment.CenterHorizontally),
            selectedTabIndex = pagerState.currentPage,
            contentColor = contentColorFor(backgroundColor = Color.Gray),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    height = 0.dp,
                    modifier = Modifier
                        .pagerTabIndicatorOffset(pagerState, tabPositions)
                        .background(color = Color.White)
                )
            },
            divider = {
                TabRowDefaults.Divider(
                    color = Color.White,
                    thickness = 0.dp
                )
            },
            backgroundColor = Color.White
        ) {

            // Add tabs for all of our pages
            for (i in 0 until size) {
                Tab(
                    modifier = Modifier
                        .background(
                            color = Color.White
                        ),
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_brightness_1_24),
                            contentDescription = if (contentDescriptionTabName.equals(""))
                                "Slide ${i + 1} Button"
                            else
                                contentDescriptionTabName
                        )
                    },
                    onClick = { onTabClick(i) },
                    selected = pagerState.currentPage == i,
                    unselectedContentColor = colorResource(id = R.color.gray),
                    selectedContentColor = colorResource(id = R.color.dark_gray)
                )
            }
        }
    }
}