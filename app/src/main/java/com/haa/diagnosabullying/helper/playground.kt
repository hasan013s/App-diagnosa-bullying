package com.haa.diagnosabullying.helper

fun main() {
    val listString = listOf("Hasan", "Fauzan", "Mardana")
    val string = listString.joinToString { it }
    println(string)
}