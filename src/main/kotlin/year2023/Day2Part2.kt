package year2023

class Day2Part2 {
    private val colors = listOf("red", "green", "blue")

    fun sumOfIDs() = DAY_TWO_FILE_NAME.lines().map(::calculateGameFactor).toList().sum()

    private fun calculateGameFactor(gameLine: String): Int {
        val gameData = extractGameData(gameLine)
        val colorToValue = gameData.flatMap { extractColorToValues(it) }
        val maxValuesByColor = calculateMaxValuesByColor(colorToValue)
        return calculateTotalFactor(maxValuesByColor)
    }

    private fun extractGameData(gameLine: String): List<String> = gameLine.substringAfter(":").split(";")

    private fun extractColorToValues(oneGameData: String): List<Pair<String, Int>> = oneGameData.split(",").map(::extractColorToValue)

    private fun extractColorToValue(oneThrow: String): Pair<String, Int> {
        val color = findMatchingColor(oneThrow)
        val value = extractThrowValue(oneThrow, color)
        return Pair(color, value)
    }

    private fun findMatchingColor(oneThrow: String) = colors.first { oneThrow.contains(it) }

    private fun extractThrowValue(oneThrow: String, color: String) = oneThrow.substringBefore(" $color").trim().toInt()

    private fun calculateMaxValuesByColor(colorToValue: List<Pair<String, Int>>): Map<String, Int> =
        colorToValue.groupBy({ it.first }, { it.second }).mapValues { it.value.maxOrNull() ?: 0 }

    private fun calculateTotalFactor(maxValuesByColor: Map<String, Int>) = maxValuesByColor.values.reduce { result, value -> result * value }
}
