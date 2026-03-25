import io.github.poerl.parseToRPN
import io.github.poerl.parseTokens
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ParserToRPNTest {
    @Test
    fun emptyInput() {
        val input = mutableListOf<String>()
        val output = parseToRPN(input)

        assertThat(output).isEmpty()
    }

    @Test
    fun firstLevelsInput() {
        val input = parseTokens("2 + 3")
        val output = parseToRPN(input)
        val expectedOutput = mutableListOf("2", "3", "+")

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun firstSecondLevelsInput() {
        val input = parseTokens("2 + 3 * 5")
        val output = parseToRPN(input)
        val expectedOutput = mutableListOf("2", "3", "5", "*", "+")

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun firstSecondThirdLevelsInput() {
        val input = parseTokens("2 + 3^6 * 5")
        val output = parseToRPN(input)
        val expectedOutput = mutableListOf("2", "3", "6", "^", "5", "*", "+")

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Suppress
    @Test
    fun allLevelsInput() {
        val input = parseTokens("2+3*5^4*(2+3)+4^(3+5)")
        val output = parseToRPN(input)
        val expectedOutput =
            mutableListOf(
                "2", "3", "5", "4", "^", "*", "2", "3", "+", "*",
                "+", "4", "3", "5", "+", "^", "+",
            )

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun floatValuesInput() {
        val input = parseTokens("2+3.5")
        val output = parseToRPN(input)
        val expectedOutput = mutableListOf("2", "3.5", "+")

        assertThat(output).isEqualTo(expectedOutput)
    }
}
