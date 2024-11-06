package leetcode.array

fun containsDuplicate(nums: IntArray): Boolean {
    val backup = hashSetOf<Int>()
    for (i in nums.indices) {
        val verified = nums[i]
        if (backup.contains(verified))
            return true
        backup.add(verified)
    }
    return false
}

fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 4, 1)))
}