package com.shawnbutton.advent2024.day01

import com.shawnbutton.advent2024.loadFile
import kotlin.math.abs

fun Int?.isLessThan(other: Int?) =
    this != null && other != null && this < other


fun main() {
    val lines = loadFile("/day01.txt")

    println(doit(lines))
}

fun inputToIntegers(input: String): Pair<Int, Int> {
    val (first, second) = input.split("   ")
    return Pair(first.toInt(), second.toInt())
}

fun linesToLists(lines: List<String>): Pair<List<Int>, List<Int>> {
    return lines
        .map(::inputToIntegers)
        .unzip()
}

fun doit(lines: List<String>): Int {
    val (first, second) = linesToLists(lines)
    val firstSorted = first.sorted()
    val secondSorted = second.sorted()

    return firstSorted
        .zip(secondSorted)
        .sumOf { (first, second) ->
            abs(first - second)
        }
}
