package com.shawnbutton.advent2024.day09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

class Day09Test {
    val testInput = "2333133121414131402"

    @Test
    fun should_represent_input_as_disk_blocks() {
        val expected =
            listOf<Int>(
                0,
                0,
                -1,
                -1,
                -1,
                1,
                1,
                1,
                -1,
                -1,
                -1,
                2,
                -1,
                -1,
                -1,
                3,
                3,
                3,
                -1,
                4,
                4,
                -1,
                5,
                5,
                5,
                5,
                -1,
                6,
                6,
                6,
                6,
                -1,
                7,
                7,
                7,
                -1,
                8,
                8,
                8,
                8,
                9,
                9
            )

        assertEquals(expected, inputToDiskBlocks(testInput))
    }

    @Test
    fun should_move_files_into_free_space() {
        assertEquals(
            listOf(0, 0, 9, 5, 5),
            moveFiles(listOf(0, 0, -1, -1, 5, 5, -1, -1, 9)),
            "simple move"
        )

        assertEquals(
            listOf(0, 0, 4, 4, 2, 2, 4),
            moveFiles(listOf(0, 0, -1, -1, 2, 2, -1, -1, 4, 4, 4)),
            "move where there's not enough space"
        )

        assertEquals(
            listOf(0, 0, 2, 1, 1),
            moveFiles(listOf(0, 0, -1, -1, 1, 1, -1, -1, -1, -1, 2)),
            "move where there's free space at the end"
        )

        assertEquals(
            listOf(0, 0, 2),
            moveFiles(listOf(0, 0, -1, -1, -1, -1, -1, -1, -1, -1, 2)),
            "move where there's free space at the end"
        )
    }

    @Test
    fun should_calculate_checksum() {
        assertEquals(8, calcChecksum(listOf(9, 2, 3)))
    }

    @Test
    fun should_do_part1() {
        assertEquals(1928, doPart1(testInput))
    }

    @Test
    @Ignore
    fun should_do_part2() {
        assertEquals(-9990, doPart2(testInput))
    }

}