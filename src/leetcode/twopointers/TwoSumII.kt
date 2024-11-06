package leetcode.twopointers

fun twoSum(numbers: IntArray, target: Int): IntArray {
    if (numbers.isEmpty()) return intArrayOf()

    var leftPointer = 0
    var rightPointer = numbers.size - 1

    while (leftPointer < rightPointer) {
        val sum = numbers[leftPointer] + numbers[rightPointer]
        when {
            sum > target -> rightPointer--
            sum < target -> leftPointer++
            else -> {
                return intArrayOf(leftPointer + 1, rightPointer + 1)
            }
        }
    }

    return intArrayOf()
}

fun main() {
    twoSum(intArrayOf(2, 7, 11, 15), 9).forEach {
        println(it)
    }
}