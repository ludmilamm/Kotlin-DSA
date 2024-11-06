package leetcode.heap

import java.util.*

fun lastStoneWeight(stones: IntArray): Int {
    if (stones.isEmpty()) return 0

    val heap = PriorityQueue<Int>(Collections.reverseOrder())

    for (stone in stones) {
        heap.add(stone)
    }

    while (heap.size > 1) {
        val firstGreater = heap.poll()
        val secondGreater = heap.poll()

        if (firstGreater != secondGreater) {
            heap.offer(firstGreater - secondGreater)
        }
    }

    return heap.peek() ?: 0
}

fun main() {
    println(lastStoneWeight(intArrayOf(2,7,4,1,8,1)))
}