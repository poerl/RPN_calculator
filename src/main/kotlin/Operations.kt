package io.github.poerl

enum class Operations(
    val value: String,
    val level: Int,
) {
    ADD("+", 0),
    SUB("-", 0),
    MUL("*", 1),
    DIV("/", 1),
    DEGREE("^", 2),
    OPEN_BRACKET("(", 3),
    CLOSE_BRACKET(")", 3),
}
