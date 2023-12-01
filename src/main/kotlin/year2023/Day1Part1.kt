package year2023

fun main() {
    val filePath = "day1.txt"
    val digitChars = (0..9).map { it.digitToChar() }.toSet()
    var totalCalibration = 0

    filePath.asResource().forEach { line ->
        val calibrationValue = calculateCalibrationValue(line, digitChars)
        totalCalibration += calibrationValue
    }

    println(totalCalibration)
}

private fun String.asResource() = { }::class.java.getResourceAsStream(this)!!.bufferedReader().lines()

private fun calculateCalibrationValue(line: String, digitChars: Set<Char>): Int {
    val firstDigit = findFirstDigit(line, digitChars)
    val lastDigit = findLastDigit(line, digitChars)

    return "$firstDigit$lastDigit".toInt()
}

private fun findFirstDigit(line: String, digitChars: Set<Char>): Char {
    return line.firstOrNull { digitChars.contains(it) } ?: throw NoSuchElementException("No digit found")
}

private fun findLastDigit(line: String, digitChars: Set<Char>): Char {
    return line.lastOrNull { digitChars.contains(it) } ?: throw NoSuchElementException("No digit found")
}
