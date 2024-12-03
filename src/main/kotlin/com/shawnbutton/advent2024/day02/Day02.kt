package com.shawnbutton.advent2024.day02

import com.shawnbutton.advent2024.loadFile
import kotlin.text.toInt

fun main() {
    val lines = loadFile("/day02.txt")

    println(doit1(lines))
    println(doit2(lines))
}

fun lineToInts(line: String): List<Int> {
    return line.split(" ").map(String::toInt)
}

fun inputToIntegers(lines: List<String>): List<List<Int>> {
    return lines.map(::lineToInts)
}

fun checkSafety(numbers: List<Int>): Boolean {
    var lastDirection = 0

    for (i in 1 until numbers.size) {
        val diff = numbers[i] - numbers[i - 1]

        if (diff > 0 && lastDirection < 0) {
            return false
        }

        if (diff < 0 && lastDirection > 0) {
            return false
        }

        if (diff != 0) {
            lastDirection = diff
        }

        val diffAbs = Math.abs(diff)
        if (diffAbs > 3 || diffAbs == 0) {
            return false
        }

    }
    return true
}

fun doit1(lines: List<String>): Int {
    return inputToIntegers(lines).count(::checkSafety)
}

fun doit2(lines: List<String>): Int {
    return -999
}
