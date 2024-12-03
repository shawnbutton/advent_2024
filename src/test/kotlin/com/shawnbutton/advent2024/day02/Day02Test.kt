package com.shawnbutton.advent2024.day02

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Day02Test {

    val inputStrings = listOf(
        "7 6 4 2 1",
        "1 2 7 8 9",
        "9 7 6 2 1",
        "1 3 2 4 5",
        "8 6 4 4 1",
        "1 3 6 7 9"
    )

    @Test
    fun should_parse_lines_into_lists_of_integers() {
        val given = listOf("1 2 3", "4 5 6")
        val result = inputToIntegers(given)

        val expected = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        )
        assertEquals(expected, result)
    }

    @Test
    fun should_be_safe_inc_or_dec_steadily() {
        assertTrue(checkSafety(listOf(1, 2, 3)))
        assertTrue(checkSafety(listOf(1, 2, 4)))
        assertTrue(checkSafety(listOf(1, 2, 5)))
        assertTrue(checkSafety(listOf(3, 2, 1)))
        assertTrue(checkSafety(listOf(4, 3, 1)))
        assertTrue(checkSafety(listOf(5, 4, 1)))
    }

    @Test
    fun should_be_unsafe_if_more_than_3_difference() {
        assertFalse(checkSafety(listOf(1, 2, 6)))
        assertFalse(checkSafety(listOf(6, 5, 1)))
    }

    @Test
    fun should_be_unsafe_if_same_number_twice() {
        assertFalse(checkSafety(listOf(1, 2, 2)))
    }

}