package year2023

import org.junit.jupiter.api.Test

import org.assertj.core.api.Assertions.*

class Day1Part2KtTest {
    @Test
    fun `WHEN calculate calibration THEN sum is equal to expected value`() {
        // given
        val day1 = Day1Part2()

        // when
        val calibration = day1.calculateCalibration()

        // then
        assertThat(calibration).isEqualTo(54591)
    }
}
