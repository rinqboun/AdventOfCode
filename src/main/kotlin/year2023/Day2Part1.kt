package year2023

class Day2Part1 {
    private val colorToLimit = mapOf(
        "red" to 12,
        "green" to 13,
        "blue" to 14
    )
    fun sumOfIDs(): Int {
        var counter = 0
        DAY_TWO_FILE_NAME.lines().forEach {
            var gamePossible = true
            val gameNumber = it.substringAfter("Game ").substringBefore(":").toInt()
            val gameData = it.substringAfter(":").split(";")
            game@ for (oneGameData in gameData) {
                for (oneThrow in oneGameData.split(",")) {
                    for (entry in colorToLimit) {
                        if (oneThrow.contains(entry.key) && oneThrow.substringBefore(" ${entry.key}").trim().toInt() > entry.value) {
                            gamePossible = false
                            break@game
                        }
                    }
                }
            }
            if (gamePossible) {
                counter += gameNumber
            }
        }
        return counter
    }
}