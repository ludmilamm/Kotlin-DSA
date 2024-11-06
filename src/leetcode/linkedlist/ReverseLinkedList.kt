package leetcode.linkedlist

fun reverseList(head: ListNode?): ListNode? {
    var current: ListNode? = head
    var previous: ListNode? = null

    while (current != null) {
        val tempNext = current.next
        current.next = previous
        previous = current
        current = tempNext
    }

    return previous
}

