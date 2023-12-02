package year2023

import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.*

class Day2Part2KtTest {
    @Test
    fun `WHEN sumOfIDs THEN sum is equal to expected value`() {
        // given
        val day2 = Day2Part2()

        // when
        val sum = day2.sumOfIDs()

        // then
        assertThat(sum).isEqualTo(59795)
    }
}
