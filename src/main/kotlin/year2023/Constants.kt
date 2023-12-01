package year2023

import java.util.stream.Stream

val DIGITS_CHARS = (0..9).map { it.digitToChar() }.toSet()
const val DAY_ONE_FILE_NAME = "day1.txt"

fun String.asStreamOfLines(): Stream<String> = { }::class.java.getResourceAsStream(this)!!.bufferedReader().lines()