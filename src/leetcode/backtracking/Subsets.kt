package leetcode.backtracking

fun subsets(nums: IntArray): List<List<Int>> {
    val subsets = mutableListOf<List<Int>>(emptyList())

    fun backtracking(index: Int, subset: List<Int>) {
        if (index == nums.size) {
            subsets.add(subset)
            return
        }

        // add the current number on the subset
        listOf(nums[index]) + subset
        backtracking(
            index = index + 1,
            subset = listOf(nums[index]) + subset
        )

        // not add the current number on the subset
        backtracking(
            index = index + 1,
            subset = subset
        )
    }

    backtracking(0, emptyList())

    return subsets
}

fun main() {
    val result = subsets(intArrayOf(1, 2, 3))
    println(result)
}