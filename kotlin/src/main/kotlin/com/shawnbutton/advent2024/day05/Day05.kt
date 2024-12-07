package com.shawnbutton.advent2024.day05

fun parseFile(strings: List<String>): Pair<List<String>, List<String>> {

    var reachedBlank = false
    val (rules, updates) = strings.partition {
        if (it == "") reachedBlank = true
        return@partition !reachedBlank
    }

    return Pair(rules, updates.drop(1))
}


fun doit1(lines: List<String>): Int {
    return 123
}

fun doit2(lines: List<String>): Int {
    return 123
}
