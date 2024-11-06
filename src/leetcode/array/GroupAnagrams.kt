package leetcode

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result = hashMapOf<String, MutableList<String>>()

    for (word in strs) {
        val count = IntArray(26)

        for (char in word) {
            val charIndex = char - 'a'
            count[charIndex]++
        }

        val key = count.joinToString()
        result[key] = result.getOrDefault(key, mutableListOf())
            .apply { add(word) }
    }

    return result.values.toList()
}

fun main() {
    val result = groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
    println(result)
}