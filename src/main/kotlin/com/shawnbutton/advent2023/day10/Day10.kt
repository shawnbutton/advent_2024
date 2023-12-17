package com.shawnbutton.advent2023.day10

import com.shawnbutton.advent2023.loadFile

data class Coord(val x: Int, val y: Int) {
    val right: Coord
        get() = Coord(x + 1, y)
    val left: Coord
        get() = Coord(x - 1, y)
    val up: Coord
        get() = Coord(x, y - 1)
    val down: Coord
        get() = Coord(x, y + 1)
}

fun connections(start: Coord, c: Char): List<Coord>? {
    return when (c) {
        '|' -> listOf(start.up, start.down)
        '-' -> listOf(start.left, start.right)
        'L' -> listOf(start.down.right, start.left.up)
        'J' -> listOf(start.down.left, start.right.up)
        '7' -> listOf(start.up.left, start.right.down)
        'F' -> listOf(start.up.right, start.left.down)
        else -> null
    }
}

fun possibleSymbol (grid: Array<Array<Char>>, loc: Coord): Pair<Coord, Char>? {
    if (loc.x < 0 || loc.y < 0) return null
    return Pair(loc, grid[loc.y][loc.x])
}

fun findConnectedSymbols(grid: Array<Array<Char>>, current: Coord): List<Coord> {

    val surroundings = listOf(
        current.up.left,
        current.up,
        current.up.right,
        current.left,
        current.right,
        current.down.left,
        current.down,
        current.down.right
    )

    val allClose = surroundings
        .mapNotNull { possibleSymbol(grid, it) }

//    return allClose.filter {
//
//    }

        return listOf()
}

fun parseLine(line: String): Array<Char> {
    return line.toCharArray().toTypedArray()
}

fun createGrid(lines: List<String>): Array<Array<Char>> {
    return lines.map { parseLine(it) }.toTypedArray()
}

fun doPartA(lines: List<String>): Int {
    return -1
}

fun doPartB(lines: List<String>): Int {
    return -1
}

fun main() {
    val lines = loadFile("/day10.txt")

    print(doPartA(lines))
    print("\n")

    print(doPartB(lines))
    print("\n")
}
