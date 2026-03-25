package io.github.poerl

val parserRegex = Regex("""\d+(\.\d+)?|[+\-*/%^()]""")

fun parse(input: String): List<String> {
    val output = mutableListOf<String>()

    val parsed = parserRegex.findAll(input)

    for (token in parsed) {
        output.add(token.value)
    }
    return output
}
