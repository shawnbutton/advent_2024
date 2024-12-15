package com.shawnbutton.advent2024.day09

import com.shawnbutton.advent2024.loadFileAsString

fun parseIntPair(asString: String): Pair<Int, Int> {
    return asString[0].digitToInt() to if (asString.length > 1) asString[1].digitToInt() else 0
}

fun inputToDiskBlocks(input: String): List<Int> {
    return input.chunked(2)
        .map(::parseIntPair)
        .flatMapIndexed { index, (fileName, emptyCount) ->
            val files = List(fileName) { index }
            val emptySpaces = List(emptyCount) { -1 }
            return@flatMapIndexed files + emptySpaces
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

fun calcChecksum(diskBlocks: List<Int>): Long {
    return diskBlocks
        .mapIndexed { index, value -> index.toLong() * value.toLong() }
        .sum()
}


fun calculatePart1Result(input: String): Long {
    val diskBlocks = inputToDiskBlocks(input)
    val movedBlocks = moveFiles(diskBlocks)
    return calcChecksum(movedBlocks)
}

fun calculatePart2Result(input: String): Int {
    return -999
}

fun main() {
    val lines = loadFileAsString("/day09.txt")
    println(calculatePart1Result(lines))
    println(calculatePart2Result(lines))
}


