package com.shawnbutton.advent2024.day05

import com.shawnbutton.advent2024.loadFile

fun main() {
    println(doit1())
}

fun parseLines(strings: List<String>): Pair<List<String>, List<String>> {
    val blankIndex = strings.indexOf("")
    return Pair(strings.take(blankIndex), strings.drop(blankIndex + 1))
}


fun isViolation(rules: List<String>, pair: Pair<String, String>): Boolean {
    val backwardFormattedPair = pair.second + "|" + pair.first
    return rules.contains(backwardFormattedPair)
}

fun middle(lines: List<String>): String {
    return lines[lines.size / 2]
}

fun updateViolates(rules: List<String>, update: String): Boolean {
    val pages = update.split(",")

    return pages.withIndex().any { (i, first) ->
        pages.drop(i + 1).any { second ->
            return@any isViolation(rules, first to second)
        }
    }
}

fun doit1(): Int {
    val lines = loadFile("/day05.txt")

    return getAllMiddles(lines)
}

fun getAllMiddles(lines: List<String>): Int {
    val (rules, updates) = parseLines(lines)

    val matches = updates
        .filter { !updateViolates(rules, it) }

    return matches
        .sumOf { middle(it.split(",")).toInt() }
}

fun doit2(lines: List<String>): Int {
    return 123
}

