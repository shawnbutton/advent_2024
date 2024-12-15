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
    val result = diskBlocks.toMutableList()
    for (i in diskBlocks.indices.reversed()) {
        val emptySpace = result.indexOfFirst { it == -1 }
        if (emptySpace == -1) break
        if (diskBlocks[i] != -1) {
            result[emptySpace] = diskBlocks[i]
        }
        result.removeAt(result.size - 1)
    }
    return result
}

fun calcChecksum(diskBlocks: List<Int>): Int {
    return diskBlocks.mapIndexed { index, value -> index * value }.sum()
}


fun doPart1(input: String): Int {
    val diskBlocks = inputToDiskBlocks(input)
    val movedBlocks = moveFiles(diskBlocks)
    return calcChecksum(movedBlocks)
}

fun doPart2(input: String): Int {
    return -999
}

fun main() {
    val lines = loadFileAsString("/day09.txt")
    println(doPart1(lines))
    println(doPart2(lines))
}


