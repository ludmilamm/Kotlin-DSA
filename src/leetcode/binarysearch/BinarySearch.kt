package leetcode.binarysearch

fun search(nums: IntArray, target: Int): Int {
    var startIndex = 0
    var endIndex = nums.size - 1

    while (startIndex <= endIndex) {
        val middle = startIndex + (endIndex - startIndex) / 2
        when {
            nums[middle] == target -> return middle
            nums[middle] < target -> startIndex = middle + 1
            else -> endIndex = middle - 1
        }
    }

    return -1
}

fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 12))
}