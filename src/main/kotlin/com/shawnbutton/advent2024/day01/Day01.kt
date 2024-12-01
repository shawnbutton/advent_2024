package com.shawnbutton.advent2024.day01

import com.shawnbutton.advent2024.loadFile

fun Int?.isLessThan(other: Int?) =
    this != null && other != null && this < other



fun main() {
    val lines = loadFile("/day01.txt")

    print("\n")
}

