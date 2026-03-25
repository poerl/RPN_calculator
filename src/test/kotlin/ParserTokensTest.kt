import io.github.poerl.parseTokens
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ParserTokensTest {
    @Test
    fun emptyTest() {
        val input = ""
        val output = parseTokens(input)

        assertThat(output).isEmpty()
    }

    @Test
    fun numbersTest() {
        val input = "23 5 4.3"
        val output = parseTokens(input)
        val expectedOutput = listOf("23", "5", "4.3")

        assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun operatorsTest() {
        val input = "+ - ++"
        val output = parseTokens(input)
        val expectedOutput = listOf("+", "-", "+", "+")

        assertThat(output).isEqualTo(expectedOutput)
    }
}
