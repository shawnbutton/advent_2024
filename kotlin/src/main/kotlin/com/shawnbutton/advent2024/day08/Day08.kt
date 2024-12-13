package com.shawnbutton.advent2024.day08

import com.shawnbutton.advent2024.loadFile

class Grid(strings: List<String>) {

    private val grid: List<MutableList<String>> = strings.map { it.toList().map { char -> char.toString() }.toMutableList() }

    fun cloneGrid(): Grid {
        val clonedGrid = grid.map { it.toMutableList() }
        return Grid(clonedGrid.map { it.joinToString("") })
    }

    fun printGrid() {
        grid.forEach { row -> println(row.joinToString("")) }
    }

    fun getGrid(): List<MutableList<String>> {
        return grid
    }

    fun getAt(position: Pair<Int, Int>): String {
        return grid[position.second][position.first]
    }

    fun setAt(position: Pair<Int, Int>, value: String) {
        grid[position.second][position.first] = value
    }

    fun isInBounds(position: Pair<Int, Int>): Boolean {
        return position.second in grid.indices && position.first in grid[position.second].indices
    }

    fun countX(): Int {
        return grid.sumOf { row -> row.count { it == "X" } }
    }

    fun getUnique(): List<String>  {
        return grid.flatten().distinct().filter{ it != "."}
    }

    fun getLocationsForAntenna(string: String): List<Pair<Int, Int>> {
        val locations = mutableListOf<Pair<Int, Int>>()
        grid.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, value ->
                if (value == string) {
                    locations.add(Pair(colIndex, rowIndex))
                }
            }
        }
        return locations
    }

}


fun doesNothing(): Boolean {
    return true
}

fun doPart1(lines: List<String>): Int {
    return -999
}

fun main() {
    val lines = loadFile("/day08.txt")
    val grid = Grid(lines)
}


