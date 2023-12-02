package year2023

import java.util.stream.Stream

val DIGITS_CHARS = (0..9).map { it.digitToChar() }.toSet()
val DIGITS_STRINGS = (0..9).map { it.toString() }.toSet() +
        "zero" + "one" + "two" + "three" + "four" + "five" + "six" + "seven" + "eight" + "nine"
val WORD_TO_DIGIT = mapOf(
    "zero"  to  "0",
    "one"   to  "1",
    "two"   to  "2",
    "three" to  "3",
    "four"  to  "4",
    "five"  to  "5",
    "six"   to  "6",
    "seven" to  "7",
    "eight" to  "8",
    "nine"  to  "9",
)
const val DAY_ONE_FILE_NAME = "day1.txt"
const val DAY_TWO_FILE_NAME = "day2.txt"

fun String.lines(): Stream<String> = { }::class.java.getResourceAsStream(this)!!.bufferedReader().lines()