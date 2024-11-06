package leetcode.backtracking

fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()

    fun backtrack(openCount: Int, closeCount: Int, combinations: String) {
        if (openCount == closeCount && openCount == n) {
            result.add(combinations)
            return
        }

        if (openCount < n) {
            backtrack(openCount + 1, closeCount, "$combinations(")
        }

        if (closeCount < openCount) {
            backtrack(openCount, closeCount + 1, "$combinations)")
        }
    }

    backtrack(0, 0, "")
    return result
}

fun main() {
    println(generateParenthesis(3))
}