package io.github.poerl

import java.util.ArrayDeque

fun parseToRPN(tokens: List<String>): List<String> {
    val output = mutableListOf<String>()
    val stack = ArrayDeque<Operations>()
    var operation: Operations?
    var poppedOperation: Operations
    var openBrackets = 0

    for (token in tokens) {
        operation = Operations.entries.find { it.value == token }
        if (operation == null) {
            output.add(token)
            continue
        }

        if (stack.isEmpty()) {
            stack.push(operation)
            continue
        }

        while (stack.isNotEmpty() && operation.level <= stack.peek().level) {
            poppedOperation = stack.pop()
            if (poppedOperation == Operations.OPEN_BRACKET) {
                openBrackets--
                break
            } else {
                output.add(poppedOperation.value)
            }
        }

        when (operation) {
            Operations.OPEN_BRACKET -> {
                stack.push(operation)
                openBrackets++
            }
            Operations.CLOSE_BRACKET ->
                {
                    if (openBrackets > 0) throw IllegalArgumentException("Open brackets must be positive.")
                }
            else -> {
                stack.push(operation)
            }
        }
    }
    if (openBrackets > 0) throw IllegalArgumentException("Open brackets must be positive.")

    for (i in stack) {
        output.add(i.value)
    }

    return output
}
