package com.shawnbutton.advent2024.day05

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Day05Test {

    val givenRules = listOf(
        "47|53",
        "97|13",
        "97|61",
        "97|47",
        "75|29",
        "61|13",
        "75|53",
        "29|13",
        "97|29",
        "53|29",
        "61|53",
        "97|53",
        "61|29",
        "47|13",
        "75|47",
        "97|75",
        "47|61",
        "75|61",
        "47|29",
        "75|13",
        "53|13"
    )

    val givenUpdates = listOf(
        "75,47,61,53,29",
        "97,61,53,29,13",
        "75,29,13",
        "75,97,47,61,53",
        "61,13,29",
        "97,13,75,29,47"
    )

    val inputStrings = givenRules + "" + givenUpdates


    @Test
    fun should_parse_input_into_rules_and_updates() {
        val (rules, updates) = parseLines(inputStrings)

        Assertions.assertEquals(givenRules, rules)
        Assertions.assertEquals(givenUpdates, updates)
    }

    @Test
    fun should_check_a_pair_against_a_list_of_rules() {
        val rules = listOf(
            "47|53",
            "97|13"
        )

        assertFalse(isViolation(rules, Pair("1", "2")), "not found")
        assertFalse(isViolation(rules, Pair("47", "53")), "found correct")
        assertTrue(isViolation(rules, Pair("53", "47")), "found violation")
    }

    @Test
    fun should_return_middle_of_list() {
        Assertions.assertEquals("2", middle(listOf("1", "2", "3")))
        Assertions.assertEquals("3", middle(listOf("1", "2", "3", "4", "5")))
    }

    @Test
    fun should_pass_update() {
        Assertions.assertEquals(false, updateViolates(givenRules, givenUpdates[0]))
        Assertions.assertEquals(false, updateViolates(givenRules, givenUpdates[1]))
        Assertions.assertEquals(false, updateViolates(givenRules, givenUpdates[2]))
        Assertions.assertEquals(true, updateViolates(givenRules, givenUpdates[3]))
        Assertions.assertEquals(true, updateViolates(givenRules, givenUpdates[4]))
        Assertions.assertEquals(true, updateViolates(givenRules, givenUpdates[5]))
    }

    @Test
    fun should_do_test_data() {
        Assertions.assertEquals(143, getAllMiddles(inputStrings))
    }


//    @Test
//    fun doIt2() {
//        Assertions.assertEquals(4, doit2(inputStrings))
//    }

}