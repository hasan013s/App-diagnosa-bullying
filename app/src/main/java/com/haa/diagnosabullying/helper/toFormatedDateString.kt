package com.haa.diagnosabullying.helper

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toFormattedDateString(pattern: String = "EEEE, dd MMMM yyyy - HH:mm"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("id", "ID"))
    return dateFormat.format(Date(this))
}