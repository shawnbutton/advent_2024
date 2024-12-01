package com.shawnbutton.advent2024

fun loadFile(fileName: String): List<String> {
    val contents = Any::class::class.java.getResource(fileName)!!.readText()
    return contents.split("\n").dropLast(1)
}