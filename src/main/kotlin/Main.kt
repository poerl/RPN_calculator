package io.github.poerl

fun main() {
    print("Введите пример: ")
    val input = readln()
    val parsedRPN = parseToRPN(parseTokens(input))
    println("Выражение в ОПЗ: $parsedRPN")
    println("Ответ: ${calculateRPN(parsedRPN)}")
}
