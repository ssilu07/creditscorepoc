package com.example.creditsimulatorpoc.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.creditsimulatorpoc.R
import com.example.creditsimulatorpoc.model.Month
import com.example.creditsimulatorpoc.model.PaymentModel
import com.example.creditsimulatorpoc.model.YearWiseStatus

@Composable
fun ExpandedCreditList(
    creditList: Month,
    navController: NavHostController,
    yearWiseStatus: YearWiseStatus,
    paymentModel: PaymentModel

) {
    Column(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Text(
            modifier = Modifier.padding(top = 5.dp, start = 15.dp),
            text = "Credit limit utilization 19.41%",
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            fontStyle = FontStyle.Normal,
            color = Color.Black,
            lineHeight = 18.sp,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
        )
        Image(
            modifier = Modifier
                .padding(top = 10.dp, start = 15.dp)
                .height(6.dp)
                .width(350.dp),
            painter = painterResource(id = R.drawable.bar), contentDescription = ""
        )
        Row(modifier = Modifier.padding(top = 15.dp, start = 15.dp)) {
            Column() {
                Text(
                    text = "Payment History",
                    modifier = Modifier.padding(end = 2.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    fontStyle = FontStyle.Normal,
                    lineHeight = 21.sp,
                    color = colorResource(id = R.color.black),
                    fontFamily = FontFamily(Font(R.font.roboto_black)),

                    )
                Text(
                    text = "last three years\n",
                    modifier = Modifier.padding(end = 2.dp, top = 2.dp),
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    fontStyle = FontStyle.Normal,
                    color = colorResource(id = R.color.textgreay),
                    fontFamily = FontFamily(
                        Font(R.font.roboto_black)
                    )

                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp),
                Alignment.TopEnd
            ) {
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "${paymentModel.paymentPercent}%"?:"" ,
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                        fontStyle = FontStyle.Normal,
                        color = colorResource(id = R.color.lightgreen),
                        textAlign = TextAlign.Right,
                        fontFamily = FontFamily(Font(R.font.roboto_black)),

                        )
                    Text(
                        text = "on time payments",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        fontStyle = FontStyle.Normal,
                        color = colorResource(id = R.color.lightgreen),
                        lineHeight = 16.sp,
                        textAlign = TextAlign.End,
                        fontFamily = FontFamily(Font(R.font.roboto_black))
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            /* Text(
                text = "\t\t\t\t\t\t\t\t",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(500),
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.roboto_black)),
                modifier = Modifier.padding(start = 5.dp),

                )*/
            LazyRow(
                modifier = Modifier.height(14.5.dp),
                //  horizontalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                itemsIndexed(Month().getMonthList()) { index, item ->
                    Text(

                        text = item.monthValue,
                        fontSize = 10.sp,
                        lineHeight = 12.sp,
                        fontWeight = FontWeight(500),
                        fontStyle = FontStyle.Normal,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        modifier = Modifier
                            .padding(start = 4.5.dp)
                            .width(23.dp)

                    )

                }
            }
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp, top = 6.dp)
                .height(50.dp)
        ) {
            Row(modifier = Modifier.padding(1.dp))
            {
                Text(
                    text = "2020" + "\t",
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                    fontWeight = FontWeight(500),
                    fontStyle = FontStyle.Normal,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    modifier = Modifier.padding(start = 5.dp),
                )
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    itemsIndexed(paymentModel.twentyItem ?: arrayListOf()) { index, item ->
                        Box(
                            modifier = Modifier
                                .width(23.dp)
                                .padding(start = 5.dp)
                        ) {


                            Icon(
                                painter = if (item.equals(true)) {
                                    painterResource(id = R.drawable.right)

                                } else {
                                    painterResource(id = R.drawable.cross)
                                },
                                contentDescription = "",
                                modifier = Modifier
                                    .size(12.dp),
                                tint = if (item.equals(false)) {
                                    colorResource(id = R.color.redcross)
                                } else {
                                    colorResource(id = R.color.lightgreen)
                                }

                            )
                        }
                    }

                }
            }
            Row(modifier = Modifier.padding(1.dp))
            {
                Text(
                    text = "2021" + "\t",
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                    fontWeight = FontWeight(500),
                    fontStyle = FontStyle.Normal,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    modifier = Modifier.padding(start = 5.dp),
                )
                LazyRow( modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    itemsIndexed(paymentModel.twentyOneItem ?: arrayListOf()) { index, item ->
                        Box(
                            modifier = Modifier
                                .width(23.dp)
                                .padding(start = 5.dp)
                        ) {
                            Icon(
                                painter = if (item.equals(true)) {
                                    painterResource(id = R.drawable.right)

                                } else {
                                    painterResource(id = R.drawable.cross)
                                },
                                contentDescription = "",
                                modifier = Modifier
                                    .size(12.dp),
                                tint = if (item.equals(false)) {
                                    colorResource(id = R.color.redcross)
                                } else {
                                    colorResource(id = R.color.lightgreen)
                                }


                            )
                        }
                    }

                }
            }
            Row(modifier = Modifier.padding(1.dp))
            {
                Text(
                    text = "2022" + "\t",
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                    fontWeight = FontWeight(500),
                    fontStyle = FontStyle.Normal,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    modifier = Modifier.padding(start = 5.dp),
                )
                LazyRow( modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    itemsIndexed(paymentModel.twentyTwoItem ?: arrayListOf()) { index, item ->
                        Box(
                            modifier = Modifier
                                .width(23.dp)
                                .padding(start = 5.dp)
                        ) {
                            Icon(
                                painter = if (item.equals(true)) {
                                    painterResource(id = R.drawable.right)

                                } else {
                                    painterResource(id = R.drawable.cross)
                                },
                                contentDescription = "",
                                modifier = Modifier
                                    .size(12.dp),
                                tint = if (item.equals(false)) {
                                    colorResource(id = R.color.redcross)
                                } else {
                                    colorResource(id = R.color.lightgreen)
                                }


                            )
                        }
                    }

                }
            }
        }
        /*LazyColumn(
    modifier = Modifier
        .padding(start = 8.dp, top = 6.dp)
        .height(50.dp)
) {
    itemsIndexed(YearWiseStatus().getYear()) { index, item ->
        Row(modifier = Modifier.padding(1.dp))
        {
            Text(
                text = item.yearValue + "\t",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(500),
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                modifier = Modifier.padding(start = 5.dp),

                )
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(start = 27.dp)
            ) {
                Icon(
                    painter = if (item.one.equals(true)) {
                        painterResource(id = R.drawable.right)

                    } else {
                        painterResource(id = R.drawable.cross)
                    },
                    contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.one.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }


                )
                Icon(
                    painter = if (item.two.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.two.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
                Icon(
                    painter = if (item.three.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.three.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
                Icon(
                    painter = if (item.four.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.four.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
                Icon(
                    painter = if (item.five.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.five.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
                Icon(
                    painter = if (item.six.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.six.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
                Icon(
                    painter = if (item.seven.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.seven.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
                Icon(
                    painter = if (item.eight.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.eight.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
                Icon(
                    painter = if (item.nine) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.nine) {
                        colorResource(id = R.color.lightgreen)
                    } else {
                        colorResource(id = R.color.redcross)
                    }

                )
                Icon(
                    painter = if (item.ten.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.ten.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
                Icon(
                    painter = if (item.eleven.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.eleven.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
                Icon(
                    painter = if (item.tweleve.equals(true)) {
                        painterResource(id = R.drawable.right)
                    } else {
                        painterResource(id = R.drawable.cross)

                    }, contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                    tint = if (item.tweleve.equals(false)) {
                        colorResource(id =R.color.redcross )
                    } else {
                        colorResource(id = R.color.lightgreen)
                    }

                )
            }
        }
    }
}*/
        Row(
            modifier = Modifier.padding(top = 15.dp, start = 15.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "\t\t\t\t\t\t",
                fontSize = 10.sp,
                lineHeight = 12.sp,
                fontWeight = FontWeight(500),
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.roboto_black)),
                modifier = Modifier.padding(start = 5.dp),

                )
            Icon(
                painter =
                painterResource(id = R.drawable.right),
                contentDescription = "",
                modifier = Modifier
                    .size(14.dp)
                    .align(CenterVertically),
                tint = colorResource(id = R.color.lightgreen)


            )
            Text(
                text = "On Time Payment",
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                modifier = Modifier.padding(start = 5.dp, end = 8.dp),

                )
            Icon(
                painter =
                painterResource(id = R.drawable.cross),
                contentDescription = "",
                modifier = Modifier
                    .size(14.dp)
                    .align(CenterVertically)
                    .padding(start = 4.dp),
                tint = colorResource(id = R.color.redcross)


            )
            Text(
                text = "Delayed",
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                modifier = Modifier.padding(start = 5.dp, end = 8.dp),

                )
            Icon(
                painter =
                painterResource(id = R.drawable.overdue),
                contentDescription = "",
                modifier = Modifier
                    .size(12.dp)
                    .align(CenterVertically)
                    .padding(start = 4.dp),
                tint = colorResource(id = R.color.redcross)


            )
            Text(
                text = "Overdue",
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                modifier = Modifier.padding(start = 5.dp),

                )
        }
        Row(
            modifier = Modifier
                .padding(top = 15.dp, end = 15.dp, bottom = 15.dp, start = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            Text(
                text = "Last updated on 22 Nov",
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(500),
                fontStyle = FontStyle.Normal,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.roboto_black)),
                modifier = Modifier.padding(start = 5.dp),

                )
        }
    }
}



