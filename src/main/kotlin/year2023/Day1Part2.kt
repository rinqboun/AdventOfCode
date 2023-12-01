package year2023

val digits = (0..9).map { it.toString() }.toSet() +
        "zero" + "one" + "two" + "three" + "four" + "five" + "six" + "seven" + "eight" + "nine"
val wordToDigit = mapOf(
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

fun main() {
    val filePath = "day1.txt"

    var totalCalibration = 0

    filePath.asResource().forEach { line ->
        val calibrationValue = calculateCalibrationValue(line)
        totalCalibration += calibrationValue
    }

    println(totalCalibration)
}

private fun String.asResource() = { }::class.java.getResourceAsStream(this)!!.bufferedReader().lines()

private fun calculateCalibrationValue(line: String): Int {
    val firstDigit = findFirstDigit(line)
    val lastDigit = findLastDigit(line)
    return "$firstDigit$lastDigit".toInt()
}

private fun findLastDigit(line: String): String {
    var lastIndex: Int = -1
    var lastDigit = ""

    for (digit in digits) {
        val index = line.lastIndexOf(digit)
        if (lastIndex < index) {
            lastIndex = index
            lastDigit = digit
        }
    }

    return wordToDigit[lastDigit] ?: lastDigit
}

private fun findFirstDigit(line: String): String {
    var firstIndex: Int = Int.MAX_VALUE
    var firstDigit = ""

    for (digit in digits) {
        val index = line.indexOf(digit)
        if (index != -1 && firstIndex > index) {
            firstIndex = index
            firstDigit = digit
        }
    }

    return wordToDigit[firstDigit] ?: firstDigit
}