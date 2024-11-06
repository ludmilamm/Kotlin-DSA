package leetcode.linkedlist

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    return if (list1.`val` <= list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        list1
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        list2
    }
}

fun main() {
    val result = mergeTwoLists(
        list1 = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(4)
            }
        },
        list2 = ListNode(1).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
    )
    println(result)
}