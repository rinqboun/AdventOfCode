package year2023

class Day2Part1 {
    private val colorToLimit = mapOf(
        "red" to 12,
        "green" to 13,
        "blue" to 14
    )

    fun sumOfIDs(): Int {
        var counter = 0

        DAY_TWO_FILE_NAME.lines().forEach { gameLine ->
            if (isGamePossible(gameLine)) {
                counter += extractGameNumber(gameLine)
            }
        }

        return counter
    }

    private fun isGamePossible(gameLine: String): Boolean {
        val gameData = gameLine.substringAfter(":").split(";")

        gameData.forEach { oneGameData ->
            if (oneGameData.split(",").any { throwIsNotPossible(it) }) {
                return false
            }
        }

        return true
    }

    private fun throwIsNotPossible(oneThrow: String): Boolean {
        return colorToLimit.any { entry ->
            oneThrow.contains(entry.key) &&
                    oneThrow.substringBefore(" ${entry.key}").trim().toInt() > entry.value
        }
    }

    private fun extractGameNumber(gameLine: String): Int {
        return gameLine.substringAfter("Game ").substringBefore(":").toInt()
    }
}
