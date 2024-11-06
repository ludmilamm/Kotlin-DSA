package leetcode.greedy

fun canJump(nums: IntArray): Boolean {
    var goal = nums.size - 1

    for (i in nums.size - 1 downTo 0) {
        if (i + nums[i] >= goal) {
            goal = i
        }
    }

    return goal == 0
}

fun main() {
    val result = canJump(intArrayOf(2,3,1,1,4))
    println(result)
}