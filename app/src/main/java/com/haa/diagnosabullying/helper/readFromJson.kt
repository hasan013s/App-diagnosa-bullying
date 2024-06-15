package com.haa.diagnosabullying.helper

import android.content.Context
import java.io.IOException
import java.io.InputStream

fun readJsonFromRaw(context: Context, resourceId: Int): String? {
    var json: String? = null
    try {
        val inputStream: InputStream = context.resources.openRawResource(resourceId)
        json = inputStream.bufferedReader().use { it.readText() }
    } catch (ex: IOException) {
        ex.printStackTrace()
    }
    return json
}
