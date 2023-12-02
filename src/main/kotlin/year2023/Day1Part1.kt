package year2023

class Day1Part1 {
    fun calculateCalibration(): Int {
        var totalCalibration = 0

        DAY_ONE_FILE_NAME.lines().forEach { line ->
            val calibrationValue = calculateCalibrationValue(line)
            totalCalibration += calibrationValue
        }

        return totalCalibration
    }

    private fun calculateCalibrationValue(line: String): Int {
        val firstDigit = findFirstDigit(line)
        val lastDigit = findLastDigit(line)
        return "$firstDigit$lastDigit".toInt()
    }

    private fun findFirstDigit(line: String): Char {
        return line.firstOrNull { DIGITS_CHARS.contains(it) } ?: throw NoSuchElementException("No digit found")
    }

    private fun findLastDigit(line: String): Char {
        return line.lastOrNull { DIGITS_CHARS.contains(it) } ?: throw NoSuchElementException("No digit found")
    }
}

