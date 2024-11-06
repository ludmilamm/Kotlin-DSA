package leetcode.dynamicprogramming

import kotlin.math.max

fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""

    var startIndex = 0
    var endIndex = 0

    fun findPalindrome(left: Int, right: Int): Int {
        var auxLeft = left
        var auxRight = right

        while (
            auxLeft >= 0 &&
            auxRight < s.length &&
            s[auxLeft] == s[auxRight]
        ) {
            auxLeft--
            auxRight++
        }

        return auxRight - auxLeft - 1
    }

    s.forEachIndexed { index, _ ->
        val length1 = findPalindrome(index, index)
        val length2 = findPalindrome(index, index + 1)
        val maxLength = max(length1, length2)
        if (maxLength > endIndex - startIndex) {
            startIndex = index - (maxLength - 1) / 2
            endIndex = index + maxLength / 2
        }
    }

    return s.substring(startIndex, endIndex + 1)
}

fun main() {
    println(longestPalindrome("babarara"))
}