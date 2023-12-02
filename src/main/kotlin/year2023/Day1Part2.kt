package year2023

class Day1Part2 {
    fun calculateCalibration(): Int {
        var totalCalibration = 0
        DAY_ONE_FILE_NAME.lines().forEach {line ->
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

    private fun findLastDigit(line: String): String {
        var lastIndex: Int = -1
        var lastDigit = ""

        for (digit in DIGITS_STRINGS) {
            val index = line.lastIndexOf(digit)
            if (index != -1 && lastIndex < index) {
                lastIndex = index
                lastDigit = digit
            }
        }

        return WORD_TO_DIGIT[lastDigit] ?: lastDigit
    }

    private fun findFirstDigit(line: String): String {
        var firstIndex: Int = Int.MAX_VALUE
        var firstDigit = ""

        for (digit in DIGITS_STRINGS) {
            val index = line.indexOf(digit)
            if (index != -1 && firstIndex > index) {
                firstIndex = index
                firstDigit = digit
            }
        }

        return WORD_TO_DIGIT[firstDigit] ?: firstDigit
    }
}
