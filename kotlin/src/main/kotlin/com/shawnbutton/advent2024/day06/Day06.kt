package com.shawnbutton.advent2024.day06

import com.shawnbutton.advent2024.day06.Direction.*
import com.shawnbutton.advent2024.loadFile


class Grid(strings: List<String>) {

    private val grid: List<MutableList<String>> = strings.map { it.toList().map { char -> char.toString() }.toMutableList() }

    fun printGrid() {
        grid.forEach { row -> println(row.joinToString("")) }
    }

    fun getGrid(): List<MutableList<String>> {
        return grid
    }

    fun get(position: Pair<Int, Int>): String {
        return grid[position.second][position.first]
    }

    fun set(position: Pair<Int, Int>, value: String) {
        grid[position.second][position.first] = value
    }

    fun isInBounds(position: Pair<Int, Int>): Boolean {
        return position.second in grid.indices && position.first in grid[position.second].indices
    }

    fun getStartingPos(): Pair<Int, Int> {
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (grid[y][x] == "^") {
                    return Pair(x, y)
                }
            }
        }
        throw IllegalArgumentException("Starting position not found in the grid")
    }

    fun countX(): Int {
        return grid.sumOf { row -> row.count { it == "X" } }
    }
    
    
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


fun countSteps(grid: Grid): Int {
    var numSteps = 0

    var currentDirection = UP
    var currentPosition = grid.getStartingPos()

    grid.set(currentPosition, "X")

    while (grid.isInBounds(currentPosition)) {
        val possibleNext = addPairs(currentPosition, currentDirection.delta)

        if (!grid.isInBounds(possibleNext)) {
            return grid.countX()
        }

        val nextElement = grid.get(possibleNext)

        if (nextElement == "#") {
            currentDirection = when (currentDirection) {
                UP -> RIGHT
                RIGHT -> DOWN
                DOWN -> LEFT
                LEFT -> UP
            }
        } else {
            currentPosition = possibleNext
            grid.set(currentPosition, "X")
            numSteps++
        }
    }
    return -1
}

fun main() {
    val lines = loadFile("/day06.txt")
    val grid = Grid(lines)
    println(countSteps(grid))
}


fun doit1(grid: Grid): Int {
    return countSteps(grid)
}

fun doit2(grid: Grid): Int {
    return grid.countX()
}

