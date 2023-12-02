package year2023

import java.util.stream.Stream

val DIGITS_CHARS = (0..9).map { it.digitToChar() }.toSet()
const val DAY_ONE_FILE_NAME = "day1.txt"
const val DAY_TWO_FILE_NAME = "day2.txt"

fun String.lines(): Stream<String> = { }::class.java.getResourceAsStream(this)!!.bufferedReader().lines()