package year2023

import java.awt.Point

class Day3Part2 {
    fun solve(input: List<String>): Int {
        val numbers: List<OneNumber> = findNumbers(input)
        val adjacentNumbers: List<OneNumber> = numbers.filter { it.isAdjacent(input) }
        val mapa = mutableMapOf<Point, MutableList<OneNumber>>()
        for (adjacentNumber in adjacentNumbers) {
            for (point in adjacentNumber.asterisks) {
                if (mapa[point] != null) {
                    mapa[point]?.add(adjacentNumber)
                } else {
                    mapa[point] = mutableListOf(adjacentNumber)
                }
            }
        }
        val sum = mapa.filter { it.value.size == 2 }.map { it.value[0].value * it.value[1].value }.sum()
        return sum
    }

    fun findNumbers(input: List<String>): List<OneNumber> {
        val numbers = mutableListOf<OneNumber>()
        for (i in input.indices) {
            numbers.addAll(findNumbersInOneLine(input[i], i))
        }
        return numbers
    }

    fun findNumbersInOneLine(line: String, lineNumber: Int): List<OneNumber> {
        var startIndex: Int = line.indexOfFirst {it.isDigit()}
        var endIndex: Int = line.indexOfFirst {it.isDigit()}
        if (startIndex == -1) return listOf()
        var number: String = line[startIndex].toString()
        if (startIndex == line.indices.last) return listOf(OneNumber(start = startIndex, end = endIndex, line = lineNumber, value = number.toInt()))

        val numbers = mutableListOf<OneNumber>()
        val iterateFrom = startIndex + 1
        for (i in iterateFrom..line.indices.last) {
            if (line[i].isDigit() && endIndex == i - 1) {
                number += line[i]
                endIndex = i
            } else if (line[i].isDigit()) {
                numbers.add(OneNumber(start = startIndex, end = endIndex, line = lineNumber, value = number.toInt()))
                startIndex = i
                endIndex = i
                number = line[i].toString()
            }
        }

        numbers.add(OneNumber(start = startIndex, end = endIndex, line = lineNumber, value = number.toInt()))

        return numbers
    }

    data class OneNumber(val start: Int, val end: Int, val line: Int, val value: Int, val asterisks: MutableSet<Point> = mutableSetOf()) {
        fun isAdjacent(input: List<String>): Boolean {
            return isAdjacentToSameLine(input) || isAdjacentToPreviousLine(input) || isAdjacentToNextLine(input)
        }

        private fun isAdjacentToNextLine(input: List<String>): Boolean {
            if (line == input.indices.last) {
                return false
            }

            var result = false
            var first = start
            if (start != 0) first -= 1
            var last = end
            if (end != input[line + 1].indices.last) last += 1

            for (i in first..last) {
                if (isAdjacentChar(input[line + 1][i])) {
                    result = true
                    asterisks.add(Point(line + 1, i))
                }
            }

            return result
        }

        private fun isAdjacentToPreviousLine(input: List<String>): Boolean {
            if (line == 0) {
                return false
            }

            var result = false
            var first = start
            if (start != 0) first -= 1
            var last = end
            if (end != input[line - 1].indices.last) last += 1

            for (i in first..last) {
                if (isAdjacentChar(input[line - 1][i])) {
                    result = true
                    asterisks.add(Point(line - 1, i))
                }
            }


            return result
        }

        private fun isAdjacentToSameLine(input: List<String>): Boolean {
            var result = false
            if (start != 0 && isAdjacentChar(input[line][start - 1])) {
                result = true
                asterisks.add(Point(line, start - 1))
            }
            if (end != input[line].indices.last && isAdjacentChar(input[line][end + 1])) {
                result = true
                asterisks.add(Point(line, end + 1))
            }
            return result
        }

        private fun isAdjacentChar(char: Char): Boolean {
            return char == '*'
        }
    }
}
