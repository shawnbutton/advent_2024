package com.shawnbutton.advent2024.day02

import org.junit.jupiter.api.Assertions
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
    fun should_parse_a_line_into_list_of_integers() {
        val given = listOf("1 2 3", "4 5 6")
        val result = inputToIntegers(given)

        val expected = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        )
        Assertions.assertEquals(expected, result)
    }

}