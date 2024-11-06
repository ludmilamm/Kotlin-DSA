package leetcode.heap

import java.util.*

class KthLargest(private val k: Int, nums: IntArray) {

    private val heap: PriorityQueue<Int> = PriorityQueue(k)

    init {
        nums.forEach {
            add(it)
        }
    }

    fun add(`val`: Int): Int {
        if (heap.size == k && `val` <= heap.peek()) {
            return heap.peek()
        }

        heap.offer(`val`)

        if (heap.size > k) {
            heap.poll()
        }

        return heap.peek()
    }
}

fun main() {
    val kthLargest = KthLargest(3, intArrayOf(4, 5, 8, 2))
    println(kthLargest.add(3))
    println(kthLargest.add(5))
    println(kthLargest.add(10))
    println(kthLargest.add(9))
    println(kthLargest.add(4))
}