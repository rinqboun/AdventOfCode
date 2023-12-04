package year2023


const val DAY_THREE_FILE_NAME = "day3.txt"

fun String.createInput(): List<String> = { }::class.java.getResourceAsStream(this)!!.bufferedReader().lines().toList()
