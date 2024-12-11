package com.shawnbutton.advent2024.day06

import com.shawnbutton.advent2024.day06.Direction.*
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

enum class Direction(val delta: Pair<Int, Int>) {
    UP(Pair(0, -1)),
    DOWN(Pair(0, 1)),
    LEFT(Pair(-1, 0)),
    RIGHT(Pair(1, 0))
}

fun addPairs(pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(pair1.first + pair2.first, pair1.second + pair2.second)
}


fun countSteps(grid: List<List<String>>): Int {
    var numSteps = 0

    var currentDirection = UP
    var currentPosition = getStartingPos(grid)

    var inGrid = true

    while (inGrid) {
        val possibleNext = addPairs(currentPosition, currentDirection.delta)


        if (possibleNext.second in grid.indices && possibleNext.first in grid[possibleNext.second].indices) return numSteps

        val nextElement = grid[possibleNext.second][possibleNext.first]

        if (nextElement == "#") {
            currentDirection = when (currentDirection) {
                UP -> RIGHT
                RIGHT -> DOWN
                DOWN -> LEFT
                LEFT -> UP
            }
        } else {
            currentPosition = possibleNext
            numSteps++
        }
    }


    return numSteps
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

