package com.shawnbutton.advent2024

fun loadFile(fileName: String): List<String> {
    val contents = loadFileAsString(fileName)
    return contents.split("\n")
        .dropLast(1)
}

fun loadFileAsString(fileName: String): String {
    return Any::class::class.java.getResource(fileName)!!.readText()
}

