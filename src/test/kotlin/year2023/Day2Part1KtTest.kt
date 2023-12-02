package year2023

import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.*

class Day2Part1KtTest {

    @Test
    fun `WHEN sumOfIDs THEN sum is equal to expected value`() {
        // given
        val day1 = Day2Part1()

        // when
        val sum = day1.sumOfIDs()

        // then
        assertThat(sum).isEqualTo(2617)
    }
}