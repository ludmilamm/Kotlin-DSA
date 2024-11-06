package dsa.queue

class Queue<T> {

    private var front: Node<T>? = null
    private var rear: Node<T>? = null

    // O(1)
    fun push(data: T) {
        val newNode = Node(data = data)

        if (isEmpty()) {
            front = newNode
            rear = newNode
        } else {
            rear?.next = newNode
            rear = newNode
        }
    }

    // O(1)
    fun pop(): T? {
        val data = front?.data
        front = front?.next

        return data
    }

    // O(1)
    fun peek(): T? {
        return front?.data
    }

    fun isEmpty() = front == null

    fun print() {
        var iterator = front
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