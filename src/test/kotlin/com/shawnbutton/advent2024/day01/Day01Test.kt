package com.shawnbutton.advent2024.day01

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day01Test {

    val inputStrings = listOf(
        "3   4",
        "4   3",
        "2   5",
        "1   3",
        "3   9",
        "3   3"
    )

    @Test
    fun should_parse_a_line_into_integer_tuple() {
        Assertions.assertEquals(Pair(3, 4), inputToIntegers("3   4"))
    }

    @Test
    fun should_get_two_lists_from_lines() {
        val given = listOf(
            "3   4",
            "4   3"
        )

        val lists = linesToLists(given)

        Assertions.assertEquals(Pair(listOf(3, 4), listOf(4, 3)), lists)
    }

    @Test
    fun should_do_it() {
        Assertions.assertEquals(11, doit(inputStrings))
    }



}