package leetcode.dynamicprogramming

fun climbStairs(n: Int): Int {
    var step1 = 1
    var step2 = 1

    for (i in 0..<n - 1) {
        val aux = step1
        step1 += step2
        step2 = aux
    }

    return step1
}

fun main() {
    println(climbStairs(3))
}