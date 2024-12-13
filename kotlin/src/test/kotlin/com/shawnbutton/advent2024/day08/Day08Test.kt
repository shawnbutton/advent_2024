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
        assertEquals(listOf("0", "A"), grid.getUnique())
    }

    @Test
    fun should_get_all_locations_for_given_antenna() {
        val grid = Grid(testInput)
        assertEquals(listOf(Pair(6, 5), Pair(8, 8), Pair(9, 9)), grid.getLocationsForAntenna("A"))

    }

    @Test
    @Ignore
    fun should_do_part1() {
        assertEquals(14, doPart1(testInput))
    }

}