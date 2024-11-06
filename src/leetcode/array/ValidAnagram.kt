package leetcode.array

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val counterS = mutableMapOf<Char, Int>()
    val counterT = mutableMapOf<Char, Int>()

    for (i in s.indices) {
        counterS[s[i]] = counterS[s[i]]?.plus(1) ?: 1
        counterT[t[i]] = counterT[t[i]]?.plus(1) ?: 1
    }

    for (i in s.indices) {
        if (counterS[s[i]] != counterT[s[i]])
            return false
    }

    return true
}

fun main() {
    println(isAnagram("anagram", "nagaram"))
}