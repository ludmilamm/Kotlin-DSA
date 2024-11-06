package leetcode.stack

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    s.forEach { bracket ->
        when(bracket) {
            '(' -> stack.add(')')
            '{' -> stack.add('}')
            '[' -> stack.add(']')
            else -> {
                if (stack.isEmpty() || stack.removeLast() != bracket)
                    return false
            }
        }

    }

    return stack.isEmpty()
}

fun main() {
    println(isValid("()[]{}"))
}