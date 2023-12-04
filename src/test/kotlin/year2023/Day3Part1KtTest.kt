package year2023

import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

const val SAMPLE_LINE_NUMBER = 123

class Day3Part1KtTest {

    @Test
    fun `WHEN sumOfIDs THEN sum is equal to expected value`() {
        // given
        val day2 = Day3Part1()

        // when
        val sum = day2.solve(DAY_THREE_FILE_NAME.createInput())

        // then
        assertThat(sum).isEqualTo(531932)
    }

    @Test
    fun `WHEN solve THEN sum is equal to expected value`() {
        // given
        val sampleInput = listOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...\$.*....",
            ".664.598.."
        )
        val day3 = Day3Part1()

        // when
        val sum = day3.solve(sampleInput)

        // then
        assertThat(sum).isEqualTo(4361)
    }

    @ParameterizedTest
    @MethodSource("lines")
    fun `WHEN findNumbersInOneLine GIVEN sample line THEN numbers are extracted`(line: String, expectedNumbers: List<Day3Part1.OneNumber>) {
        // given
        val day3 = Day3Part1()

        // when
        val result = day3.findNumbersInOneLine(line, SAMPLE_LINE_NUMBER)

        // then
        assertThat(result).containsExactlyInAnyOrder(*expectedNumbers.toTypedArray())
    }

    companion object {
        @JvmStatic
        fun lines(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("467..114..", listOf(Day3Part1.OneNumber(0,2,SAMPLE_LINE_NUMBER,467), Day3Part1.OneNumber(5,7,SAMPLE_LINE_NUMBER,114))),
                Arguments.of("...*......", listOf<Day3Part1.OneNumber>()),
                Arguments.of("..35..633.", listOf(Day3Part1.OneNumber(2,3,SAMPLE_LINE_NUMBER,35), Day3Part1.OneNumber(6,8,SAMPLE_LINE_NUMBER,633))),
                Arguments.of("617*......", listOf(Day3Part1.OneNumber(0,2,SAMPLE_LINE_NUMBER,617))),
                Arguments.of(".....+.58.", listOf(Day3Part1.OneNumber(7,8,SAMPLE_LINE_NUMBER,58))),
                Arguments.of("..592.....", listOf(Day3Part1.OneNumber(2,4,SAMPLE_LINE_NUMBER,592))),
                Arguments.of("......755.", listOf(Day3Part1.OneNumber(6,8,SAMPLE_LINE_NUMBER,755))),
                Arguments.of("...\$.*....", listOf<Day3Part1.OneNumber>()),
                Arguments.of("123\$.*....", listOf(Day3Part1.OneNumber(0,2,SAMPLE_LINE_NUMBER,123))),
                Arguments.of("1233457", listOf(Day3Part1.OneNumber(0,6,SAMPLE_LINE_NUMBER,1233457))),
            )
        }
    }
}


