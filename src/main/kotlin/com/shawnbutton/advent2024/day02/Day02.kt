package com.shawnbutton.advent2024.day02

import com.shawnbutton.advent2024.loadFile
import kotlin.text.toInt

fun main() {
    val lines = loadFile("/day02.txt")

    println(doit1(lines))
    println(doit2(lines))
}

fun lineToInts(line: String): List<Int> {
    return line.split(" ").map {
        it -> it.toInt()
    }
}

fun inputToIntegers(lines: List<String>): List<List<Int>> {
    return lines.map(::lineToInts)
}

fun checkSafety(numbers: List<Int>): Boolean {
    for (i in 1 until numbers.size) {
        val diff = Math.abs(numbers[i] - numbers[i - 1])
        if (diff > 3 || diff == 0) {
            return false
        }


    }
    return true
}

fun doit1(lines: List<String>): Int {
    return -999
}

fun doit2(lines: List<String>): Int {
    return -999
}
