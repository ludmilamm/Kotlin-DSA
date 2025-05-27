package leetcode.slidingwindow

import kotlin.system.measureTimeMillis

@OptIn(ExperimentalStdlibApi::class)
fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false

    val s1Count = IntArray(26)
    val s2Count = IntArray(26)

    for (i in s1.indices) {
        s1Count[s1[i] - 'a']++
        s2Count[s2[i] - 'a']++
    }

    for (i in 0..<s2.length - s1.length) {
        if (s1Count.contentEquals(s2Count)) return true

        s2Count[s2[i] - 'a']--
        s2Count[s2[i + s1.length] - 'a']++
    }

    return s1Count.contentEquals(s2Count)
}

fun main() {
    val time = measureTimeMillis {
        val result = checkInclusion("daa", "ssfsdaadfsdads")
        println(result)
    }
    println(time)
}