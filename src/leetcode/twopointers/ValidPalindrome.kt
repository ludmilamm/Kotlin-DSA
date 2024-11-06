package leetcode.twopointers

fun isPalindrome(s: String): Boolean {
    val normalized = s.mapNotNull { if (it.isLetterOrDigit()) it.lowercase() else null }
    var leftIndex = 0
    var rightIndex = normalized.size - 1

    while (leftIndex != rightIndex && leftIndex < rightIndex) {
        if (normalized[leftIndex] != normalized[rightIndex]) {
            return false
        }

        leftIndex++
        rightIndex--
    }

    return true
}

fun main() {
    println(isPalindrome("0P"))
}