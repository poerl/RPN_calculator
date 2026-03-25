import io.github.poerl.parse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ParserToRPNTest {
    @Test
    fun emptyTest() {
        val input = ""
        val output = parse(input)

        assertThat(output).isEmpty()
    }

    @Test
    fun numbersTest() {
        val input = "23 5 4.3"
        val output = parse(input)
        val expectedOutput = listOf("23", "5", "4.3")

        assertThat(output).isEmpty()
//        assertThat(output).isEqualTo(expectedOutput)
    }
}
