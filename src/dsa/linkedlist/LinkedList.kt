package dsa.linkedlist

class LinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    // O(1)
    fun addFirst(data: T) {
        val newNode = Node(data = data, next = head)
        head = newNode

        if (head?.next == null) {
            tail = newNode
        }
    }

    // O(1)
    fun addLast(data: T) {
        val newNode = Node(data = data)

        if (isEmpty()) {
            head = newNode
            tail = newNode
            return
        }

        tail?.next = newNode
        tail = newNode
    }

    // O(n)
    fun addBefore(data: T, before: T) {
        val newNode = Node(data = data)

        if (isEmpty()) {
            head = newNode
            tail = newNode
            return
        }

        var iterator = head
        while (iterator?.next?.data != before) {
            iterator = iterator?.next
        }

        newNode.next = iterator?.next
        iterator?.next = newNode
    }

    // O(n)
    fun addAfter(data: T, after: T) {
        val newNode = Node(data = data)

        if (isEmpty()) {
            head = newNode
            tail = newNode
            return
        }

        var iterator = head
        while (iterator?.data != after) {
            iterator = iterator?.next
        }

        newNode.next = iterator?.next
        iterator?.next = newNode
    }

    // O(1) - when data is in the head
    // O(n) - other cases
    fun remove(data: T) {
        if (isEmpty()) return

        if (head?.data == data) {
            head = head?.next
            return
        }

        var iterator = head
        while (iterator?.next?.data != data) {
            iterator = iterator?.next
        }

        if (iterator?.next == tail) {
            iterator?.next = null
            tail = iterator
        } else {
            iterator?.next = iterator?.next?.next
        }
    }

    // O(1) - when index is 0
    // O(n) - other cases
    fun get(index: Int): T? {
        if (index < 0) return null

        if (index == 0) {
            return head?.data
        }

        var data: T? = null
        var iterator = head
        for (i in 0..index) {
            data = iterator?.data
            iterator = iterator?.next
        }

        return data
    }

    fun isEmpty() = head == null

    fun print() {
        var iterator = head
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