package com.example.creditsimulatorpoc.model

import com.example.creditsimulatorpoc.R

data class Month(
    var monthValue:String = "",
   /* var isText: Boolean = true,
    var textValue: String = "",
    var iconValue: Int = 0*/
) {
    fun getMonthList(): ArrayList<Month> {
        return arrayListOf(
            Month(""),
            Month("Jan"),
            Month("Feb"),
            Month("Mar"),
            Month("Apr"),
            Month("May"),
            Month("June"),
            Month("July"),
            Month("Aug"),
            Month("Sept"),
            Month("Oct"),
            Month("Nov"),
            Month("Dec")

        )
    }

}
