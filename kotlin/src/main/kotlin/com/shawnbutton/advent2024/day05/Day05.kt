package com.shawnbutton.advent2024.day05

fun parseFile(strings: List<String>): Pair<List<String>, List<String>> {
    val blankIndex = strings.indexOf("")
    return Pair(strings.take(blankIndex), strings.drop(blankIndex + 1))
}


fun doit1(lines: List<String>): Int {
    return 123
}

fun doit2(lines: List<String>): Int {
    return 123
}
