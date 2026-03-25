import io.github.poerl.calculateRPN
import io.github.poerl.parseToRPN
import io.github.poerl.parseTokens
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorForRPNTest {
    @Test
    fun emptyInput() {
        val input = parseToRPN(parseTokens(""))
        val output = calculateRPN(input)

        assertThat(output).isEqualTo(0.0f)
    }

    @Test
    fun firstLevelsInput() {
        val input = parseToRPN(parseTokens("2 + 3"))
        val output = calculateRPN(input)
        val expectedOutput = 5.0f

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun firstSecondLevelsInput() {
        val input = parseToRPN(parseTokens("2 + 3 * 5"))
        val output = calculateRPN(input)
        val expectedOutput = 17.0f

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun firstSecondThirdLevelsInput() {
        val input = parseToRPN(parseTokens("2 + 3^6 * 5"))
        val output = calculateRPN(input)
        val expectedOutput = (Math.pow(3.0, 6.0) * 5 + 2).toFloat()

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Suppress
    @Test
    fun allLevelsInput() {
        val input = parseToRPN(parseTokens("2+3*5^4*(2+3)+4^(3+5)"))
        val output = calculateRPN(input)
        val expectedOutput = 74913f

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun floatValuesInput() {
        val input = parseToRPN(parseTokens("2+3.5"))
        val output = calculateRPN(input)
        val expectedOutput = 5.5f

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun divisionByZeroInput() {
        val input = parseToRPN(parseTokens("2 / 0"))
        val output = calculateRPN(input)
        val expectedOutput = Float.POSITIVE_INFINITY

        assertThat(output).isEqualTo(expectedOutput)
    }
}
