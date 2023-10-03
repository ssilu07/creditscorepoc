package com.example.creditsimulatorpoc.model

data class YearWiseStatus(
    var yearValue:String = "",
    var one:Boolean = false,
    var two:Boolean = false,
    var three:Boolean = false,
    var four:Boolean = false,
    var five:Boolean = false,
    var six:Boolean = false,
    var seven:Boolean = false,
    var eight:Boolean = false,
    var nine:Boolean = false,
    var ten:Boolean = false,
    var eleven:Boolean = false,
    var tweleve:Boolean = false,
    var overdue : Int = 0

    )
{
    fun getYear():ArrayList<YearWiseStatus> {
        return arrayListOf(
            YearWiseStatus(
                "2020",
                true,
                true,
                true,
                true,
                true,
                true,
                false,
                true,
                true,
                true,
                true,
                true
            ),
            YearWiseStatus(
                "2021",
                true,
                true,
                false,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true
            ),
            YearWiseStatus(
                "2022",
                true,
                true,
                true,
                true,
                true,
                true,
                false,
                true,
                false,
                true,
                true,
                true
            )
        )
    }
}