package year2023

class Day2Part2 {
    private val colors = listOf("red", "green", "blue")

    fun sumOfIDs() = DAY_TWO_FILE_NAME.lines().map { calculateGameFactor(it) }.toList().sum()

    private fun calculateGameFactor(gameLine: String): Int {
        val gameData = gameLine.substringAfter(":").split(";")
        val colorToValue = gameData.flatMap { oneGameData ->
            oneGameData.split(",").map { extractColorToValue(it) }
        }
        val maxValuesByColor = colorToValue.groupBy({ it.first }, { it.second }).mapValues { it.value.maxOrNull() ?: 0 }
        return maxValuesByColor.values.reduce { sum, value -> sum * value }
    }

    private fun extractColorToValue(oneThrow: String): Pair<String, Int> {
        val color = colors.first { oneThrow.contains(it) }
        val value =  oneThrow.substringBefore(" $color").trim().toInt()
        return Pair(color, value)
    }
}
