package leetcode.backtracking

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()

    val map = hashMapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )
    val combinations = mutableListOf<String>()

    fun backtrack(index: Int, builtString: String) {
        if (builtString.length == digits.length) {
            combinations.add(builtString)
            return
        }

        map[digits[index]]?.forEach {
            backtrack(index + 1, builtString + it)
        }
    }

    backtrack(0, "")

    return combinations
}

fun main() {
    val result = letterCombinations("23")
    println(result)
}