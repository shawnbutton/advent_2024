package com.shawnbutton.advent2024.day09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

class Day09Test {
    val testInput = "2333133121414131402"

    @Test
    fun should_represent_input_as_disk_blocks() {
        val expected =
            listOf<Int>(0, 0, -1, -1, -1, 1, 1, 1, -1, -1, -1, 2, -1, -1, -1, 3, 3, 3, -1, 4, 4, -1, 5, 5, 5, 5, -1, 6, 6, 6, 6, -1, 7, 7, 7, -1, 8, 8, 8, 8, 9, 9)

        assertEquals(expected, inputToDiskBlocks(testInput))

    }

    @Test
    @Ignore
    fun should_do_part1() {
        assertEquals(1928, doPart1(testInput))
    }

    @Test
    @Ignore
    fun should_do_part2() {
        assertEquals(-9990, doPart2(testInput))
    }

}