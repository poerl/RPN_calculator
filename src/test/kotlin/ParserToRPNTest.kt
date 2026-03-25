import io.github.poerl.parse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ParserToRPNTest {

    @Test
    fun emptyTest(){
        val input = ""
        val output = parse(input)

        assertThat(output).isEmpty()
    }

}