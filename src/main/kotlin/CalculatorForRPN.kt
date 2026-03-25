package io.github.poerl

import java.util.ArrayDeque
import kotlin.math.pow

fun calculateRPN(tokens: List<String>): Float {
    val numbers = ArrayDeque<Float>()
    var operation: Operations?

    for (token in tokens) {
        operation = Operations.entries.find { it.value == token }

        if (operation == null) {
            numbers.push(token.toFloat())
            continue
        }

        when (operation) {
            Operations.ADD -> {
                numbers.push(numbers.pop() + numbers.pop())
            }
            Operations.SUB -> {
                numbers.push(numbers.pop() - numbers.pop())
            }
            Operations.MUL -> {
                numbers.push(numbers.pop() * numbers.pop())
            }
            Operations.DIV -> {
                val b = numbers.pop()
                val a = numbers.pop()
                numbers.push(a / b)
            }
            Operations.DEGREE -> {
                val b = numbers.pop()
                val a = numbers.pop()
                numbers.push(a.pow(b))
            }
            else -> {}
        }
    }
    return if (numbers.isNotEmpty()) numbers.pop() else 0.0f
}
