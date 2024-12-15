package com.shawnbutton.advent2024.day09

import com.shawnbutton.advent2024.loadFileAsString

fun inputToDiskBlocks(input: String): List<Int> {
    val something = input.chunked(2)
        .map {
            Pair(
                it[0].digitToInt(),
                if (it.length > 1) it[1].digitToInt() else 0
            )
        }
        .mapIndexed { index, pair ->
            val file = List(pair.first) { index }

            val emptySpace = List(pair.second) { -1 }

            return@mapIndexed file + emptySpace
        }.flatten()

    return something
}


fun doPart1(input: String): Int {
    return -999
}

fun doPart2(input: String): Int {
    return -999
}

fun main() {
    val lines = loadFileAsString("/day08.txt")
    println(doPart1(lines))
    println(doPart2(lines))
}


