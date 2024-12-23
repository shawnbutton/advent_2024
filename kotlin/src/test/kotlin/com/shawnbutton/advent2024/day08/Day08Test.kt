package com.shawnbutton.advent2024.day08

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

class Day08Test {


    val testInput = listOf(
        "............",
        "........0...",
        ".....0......",
        ".......0....",
        "....0.......",
        "......A.....",
        "............",
        "............",
        "........A...",
        ".........A..",
        "............",
        "............",
    )


    @Test
    fun should_load_grid() {
        val grid = Grid(testInput)
        assertEquals("0", grid.getAt(Pair(5, 2)))
        assertEquals("A", grid.getAt(Pair(6, 5)))
        assertEquals(".", grid.getAt(Pair(0, 0)))
    }

    @Test
    fun should_get_all_unique_antennas() {
        val grid = Grid(testInput)
        assertEquals(listOf("0", "A"), grid.getUniqueAntennas())
    }

    @Test
    fun should_get_all_locations_for_given_antenna() {
        val grid = Grid(testInput)
        assertEquals(listOf(Pair(6, 5), Pair(8, 8), Pair(9, 9)), grid.getLocationsForAntenna("A"))

    }

    @Test
    fun should_get_antinodes_for_all_antennas() {
        val twoAntennas = listOf(Pair(5, 5), Pair(7, 7))
        assertEquals(listOf(Pair(3, 3), Pair(9, 9)), getAntiNodes(twoAntennas))

        val threeAntennas = listOf(Pair(5, 5), Pair(7, 7), Pair(7, 6))
        assertEquals(listOf(Pair(3, 3), Pair(9, 9), Pair(3, 4), Pair(9, 7), Pair(7, 8), Pair(7, 5)), getAntiNodes(threeAntennas))
    }

    @Test
    fun should_do_part1() {
        assertEquals(14, doPart1(testInput))
    }

    @Test

    fun should_do_part2() {
        assertEquals(34, doPart2(testInput))
    }

}