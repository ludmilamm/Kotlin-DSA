package leetcode

import java.util.*

fun calculate(s: String): Int {
    val stack = ArrayDeque<Int>()
    var currentNumber = ""
    var currentOperator = "+"
    val operators = listOf('+', '-', '*', '/')

    s.forEachIndexed { index, c ->
        if (c.isDigit()) {
            currentNumber += c
        }

        if (operators.contains(c) || index == s.length - 1) {
            when(currentOperator) {
                "+" -> stack.add(currentNumber.toInt())
                "-" -> stack.add("-$currentNumber".toInt())
                "*" -> stack.add(stack.removeLast() * currentNumber.toInt())
                "/" -> stack.add(stack.removeLast() / currentNumber.toInt())
            }
            currentNumber = ""
            currentOperator = c.toString()
        }
    }

    return stack.sum()
}

fun main() {
    val result = calculate(" 3+5 / 2 ")
    println(result)
}