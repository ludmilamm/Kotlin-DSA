package dsa.stack

class Stack<T> {

    private var top: Node<T>? = null

    // O(1)
    fun push(data: T) {
        val newNode = Node(
            data = data,
            next = top
        )

        top = newNode
    }

    // O(1)
    fun pop(): T? {
        val data = top?.data
        top = top?.next

        return data
    }

    // O(1)
    fun peek(): T? {
        return top?.data
    }

    fun isEmpty() = top == null

    fun print() {
        var iterator = top
        while (iterator?.next != null) {
            println(iterator.data)
            iterator = iterator.next
        }
        println(iterator?.data)
    }

    private data class Node<T>(
        val data: T,
        var next: Node<T>? = null
    )
}