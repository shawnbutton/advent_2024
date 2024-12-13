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
        assertEquals("0", Grid(testInput).getAt(Pair(5, 2)))
    }

    @Test
    @Ignore
    fun should_do_part1() {
        assertEquals(14, doPart1(testInput))
    }

}