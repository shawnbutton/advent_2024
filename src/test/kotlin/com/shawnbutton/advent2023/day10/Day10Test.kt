package com.shawnbutton.advent2023.day10

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class Day10Test {

    val line1 = "....."
    val line2 = ".S-7."
    val line3 = ".|.|."
    val line4 = ".L-J."
    val line5 = "....."

    val lines = listOf(line1, line2, line3, line4, line5)

    val line1Array = arrayOf('.', '.', '.', '.', '.')
    val line3Array = arrayOf('.', '|', '.', '|', '.')

    @Test
    fun `can parse line`() {
        assertContentEquals(line1Array, parseLine(line1))
        assertContentEquals(line3Array, parseLine(line3))
    }

    @Test
    fun `can make a grid`() {
        val lines = listOf(line1, line3)

        val result = createGrid(lines)

        assertContentEquals(line1Array, result[0])
        assertContentEquals(line3Array, result[1])

        assertEquals('|', result[1][1])
    }

    @Test
    fun `can navigate based on character`() {
        val symbolLoc = Coord(5, 5)

        assertEquals(listOf(Coord(5, 4), Coord(5, 6)), connections(symbolLoc, '|'))
        assertEquals(listOf(Coord(4, 5), Coord(6, 5)), connections(symbolLoc, '-'))
        assertEquals(listOf(Coord(6, 6), Coord(4, 4)), connections(symbolLoc, 'L'))
        assertEquals(listOf(Coord(4, 6), Coord(6, 4)), connections(symbolLoc, 'J'))
        assertEquals(listOf(Coord(4, 4), Coord(6, 6)), connections(symbolLoc, '7'))
        assertEquals(listOf(Coord(6, 4), Coord(4, 6)), connections(symbolLoc, 'F'))
    }

    @Test
    fun `can find symbols that connect to current `() {
        val grid = createGrid(lines)

        val current = Coord(1, 1)

        val result = findConnectedSymbols(grid, current)

        assertEquals(listOf(Coord(2, 1), Coord(1, 2)), result)

    }



//    @Test
//    fun doPartA() {
//        assertEquals(-1, doPartA())
//    }
//
//    @Test
//    fun doPartB() {
//
//        assertEquals(-1, doPartA(line1))
//    }
}
