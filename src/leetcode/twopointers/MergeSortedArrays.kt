package leetcode.twopointers

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
    var index1 = m - 1
    var index2 = n - 1

    for (index in (m + n - 1) downTo 0) {
        if (index1 < 0) {
            nums1[index] = nums2[index2]
            index2 -= 1
        } else if (index2 < 0) {
            break
        } else if (nums1[index1] < nums2[index2]) {
            nums1[index] = nums2[index2]
            index2 -= 1
        } else {
            nums1[index] = nums1[index1]
            index1 -= 1
        }
    }

    return nums1
}

fun main() {
    val result = merge(intArrayOf(5, 6, 7, 8, 0, 0, 0), 4, intArrayOf(2, 5, 6), 3).joinToString(",")
    println(result)
}