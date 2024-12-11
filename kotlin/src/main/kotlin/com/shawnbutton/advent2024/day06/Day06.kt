package com.shawnbutton.advent2024.day06

import com.shawnbutton.advent2024.loadFile


fun getStartingPos(grid: List<List<String>>): Pair<Int, Int> {
    for (y in grid.indices) {
        for (x in grid[y].indices) {
            if (grid[y][x] == "^") {
                return Pair(x, y)
            }
        }
    }
    throw IllegalArgumentException("Starting position not found in the grid")
}

fun toGrid(strings: List<String>): List<List<String>> {
    return strings.map { it.toList().map { char -> char.toString() } }
}

fun countSteps(grid: List<List<String>>): Int {
    return 0
}

fun main() {
    val lines = loadFile("/day06.txt")
    println(doit1(lines))
    println(doit2(lines))
}


fun doit1(lines: List<String>): Int {

    return 999
}

fun doit2(lines: List<String>): Int {
    return 123
}

