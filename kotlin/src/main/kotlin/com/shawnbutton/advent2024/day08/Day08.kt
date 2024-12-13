package com.shawnbutton.advent2024.day08

import com.shawnbutton.advent2024.loadFile

class Grid(strings: List<String>) {

    private val grid: List<MutableList<String>> =
        strings.map { it.toList().map { char -> char.toString() }.toMutableList() }

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

    fun getUniqueAntennas(): List<String> {
        return grid.flatten().distinct().filter { it != "." }
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


fun getAntiNodes(antennas: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
    val combinations = mutableListOf<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
    for (i in antennas.indices) {
        for (j in i + 1 until antennas.size) {
            combinations.add(Pair(antennas[i], antennas[j]))
        }
    }
    val allAntinodes = combinations
        .flatMap { pair: Pair<Pair<Int, Int>, Pair<Int, Int>> ->
            val antenna1 = pair.first
            val antenna2 = pair.second
            val xDistance = (antenna1.first - antenna2.first)
            val yDistance = (antenna1.second - antenna2.second)
            val antinode1 = Pair(antenna1.first + xDistance, antenna1.second + yDistance)
            val antinode2 = Pair(antenna2.first - xDistance, antenna2.second - yDistance)
            return@flatMap listOf(antinode1, antinode2)
        }

    return allAntinodes
}


fun doPart1(lines: List<String>): Int {
    val grid = Grid(lines)

    val allAntennaTypes = grid.getUniqueAntennas()

    return allAntennaTypes.flatMap { antennaType ->
        val antennaLocs = grid.getLocationsForAntenna(antennaType)
        val antiNodes = getAntiNodes(antennaLocs)
        return@flatMap antiNodes
    }
        .distinct()
        .filter(grid::isInBounds)
        .size
}

fun main() {
    val lines = loadFile("/day08.txt")
    println(doPart1(lines))
}


