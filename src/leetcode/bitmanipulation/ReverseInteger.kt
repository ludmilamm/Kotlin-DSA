package leetcode.bitmanipulation

fun reverse(x: Int): Int {
    var x1 = x
    var result = 0
    while (x1 != 0) {
        val lastDigit = x1 % 10
        x1 /= 10

        if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && lastDigit >= Int.MAX_VALUE % 10))
            return 0
        if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && lastDigit <= Int.MIN_VALUE % 10))
            return 0

        result = result * 10 + lastDigit
    }

    return result
}

fun main() {
    reverse(-1534236469)
}