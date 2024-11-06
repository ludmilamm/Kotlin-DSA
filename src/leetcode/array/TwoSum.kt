package leetcode.array

fun twoSum(nums: IntArray, target: Int): IntArray {
    val aux = mutableMapOf<Int, Int>()
    nums.forEachIndexed { i, num ->
        val rest = target - num
        aux[rest]?.let {
            return intArrayOf(it, i)
        }
        aux[num] = i
    }

    return intArrayOf()
}

fun main() {
    twoSum(intArrayOf(2, 7, 11, 15), 9).forEach {
        println(it)
    }
}