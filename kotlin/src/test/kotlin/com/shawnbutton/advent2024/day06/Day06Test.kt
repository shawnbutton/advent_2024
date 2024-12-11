package com.shawnbutton.advent2024.day06

import kotlin.test.Test
import kotlin.test.assertEquals

class Day06Test {


    val testInput = listOf(
        "....#.....",
        ".........#",
        "..........",
        "..#.......",
        ".......#..",
        "..........",
        ".#..^.....",
        "........#.",
        "#.........",
        "......#..."
    )


    @Test
    fun should_load_grid() {
        val given = listOf(
            "ABC",
            "123"
        )

        assertEquals(listOf(listOf("A", "B", "C"), listOf("1", "2", "3")), Grid(given).getGrid())
    }

    @Test
    fun should_get_starting_position() {
        val grid = Grid(testInput)

        assertEquals(Pair(4,6), grid.getStartingPos())
    }


    @Test
    fun should_do_test_grid() {
        val grid = Grid(testInput)

        assertEquals(41, countSteps(grid))

    }

}