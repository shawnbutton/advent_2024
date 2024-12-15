package com.shawnbutton.advent2024.day09

import com.shawnbutton.advent2024.loadFileAsString

fun toIntPair(asString: String): Pair<Int, Int> {
    return Pair(
        asString[0].digitToInt(),
        if (asString.length > 1) asString[1].digitToInt() else 0
    )
}

fun inputToDiskBlocks(input: String): List<Int> {
    return input.chunked(2)
        .map(::toIntPair)
        .flatMapIndexed { index, pair: Pair<Int, Int> ->
            val file = List(pair.first) { index }
            val emptySpace = List(pair.second) { -1 }
            return@flatMapIndexed file + emptySpace
        }
}

fun moveFiles(diskBlocks: List<Int>): List<Int> {
    val clonedDiskBlocks = diskBlocks.toList()

    var result = diskBlocks.toMutableList()
    for (i in clonedDiskBlocks.size - 1 downTo 0) {
        val targetIndex = result.indexOfFirst { it == -1 }
        if (targetIndex == -1) break
        if (clonedDiskBlocks[i] != -1) {
            result[targetIndex] = clonedDiskBlocks[i]
            result = result.dropLast(1).toMutableList()
        } else {
            result = result.dropLast(1).toMutableList()
        }
    }

    return result.toList()
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


