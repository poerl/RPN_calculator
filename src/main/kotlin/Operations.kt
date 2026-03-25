package io.github.poerl

enum class Operations(
    val value: String,
    val level: Int,
) {
    CLOSE_BRACKET(")", 0),
    ADD("+", 1),
    SUB("-", 1),
    MUL("*", 2),
    DIV("/", 2),
    DEGREE("^", 3),
    OPEN_BRACKET("(", 4),
}
