package dsa.array

import kotlin.Array as KotlinArray

class IntArray(private var capacity: Int) {

    private var array: KotlinArray<Int?> = KotlinArray(capacity) { null }
    var size: Int = 0
        private set

    // O(1)
    fun add(element: Int) {
        if (size == capacity) {
            capacity += capacity
            array = KotlinArray(capacity) { array.getOrNull(it) }
        }
        array[size] = element
        size++
    }

    // O(n)
    fun addAt(index: Int, element: Int) {
        if (index < 0 || index > capacity) {
            throw IndexOutOfBoundsException()
        }

        if (size == capacity) {
            capacity += capacity
            array = KotlinArray(capacity) { array.getOrNull(it) }
        }

        array.copyInto(
            destination = array,
            destinationOffset = index + 1,
            startIndex = index,
            endIndex = size
        )
        array[index] = element
        size++
    }

    // O(n)
    fun remove(element: Int) {
        array.forEachIndexed { index, i ->
            if (i == element) {
                if (index == size - 1) {
                    array[index] = null
                } else {
                    array.copyInto(
                        destination = array,
                        destinationOffset = index,
                        startIndex = index + 1,
                        endIndex = size
                    )
                    array[size] = null
                }

                size--
                if (capacity > 1 && size < capacity * 0.5) {
                    capacity -= capacity / 2
                    array = KotlinArray(capacity) { array.getOrNull(it) }
                }

                return
            }
        }

        throw IndexOutOfBoundsException()
    }

    // O(1)
    fun get(index: Int): Int {
        return array[index] ?: throw IndexOutOfBoundsException()
    }

    fun print() {
        array.forEach { println(it) }
    }
}