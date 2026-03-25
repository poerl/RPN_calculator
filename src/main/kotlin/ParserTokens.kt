package io.github.poerl

val parserRegex = Regex("""\d+(\.\d+)?|[+\-*/%^()]""")

fun parseTokens(input: String): List<String> = parserRegex.findAll(input).map { it.value }.toList()
