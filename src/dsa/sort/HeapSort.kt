package dsa.sort

fun IntArray.heapSort() {
    val array = this
    for (i in size / 2 - 1 downTo 0) {
        heapify(array, size, i)
    }

    for (i in size - 1 downTo 0) {
        val temp = array[0]
        array[0] = array[i]
        array[i] = temp

        heapify(array, i, 0)
    }
}

private fun heapify(
    array: IntArray,
    currentIndex: Int,
    i: Int
) {
    var largest = i
    val left = 2 * i + 1
    val right = 2 * i + 2

    // If left child is larger than root
    if (left < currentIndex && array[left] > array[largest]) {
        largest = left
    }

    // If right child is larger than the largest so far
    if (right < currentIndex && array[right] > array[largest]) {
        largest = right
    }

    // If largest is not the root
    if (largest != i) {
        // Swap the root with the largest
        val temp = array[i]
        array[i] = array[largest]
        array[largest] = temp

        // Recursively heapify the affected sub-tree
        heapify(array, currentIndex, largest)
    }
}
