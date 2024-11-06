package dsa.tree

class BinarySearchTree<T : Comparable<T>> {

    private var root: Node<T>? = null

    // avg: O(log(n))
    // worst: O(n)
    fun add(data: T) {
        root = add(data, root)
    }

    // avg: O(log(n))
    // worst: O(n)
    fun remove(data: T) {
        root = remove(data, root)
    }

    // avg: O(log(n))
    // worst: O(n)
    fun contains(data: T): Boolean {
        return contains(data, root)
    }

    fun print() {
        print(prefix = "root", node = root)
    }

    private fun add(data: T, node: Node<T>?): Node<T> {
        if (node == null) {
            return Node(data)
        }

        if (data < node.data) {
            node.left = add(data, node.left)
        } else {
            node.right = add(data, node.right)
        }

        return node
    }

    private fun remove(data: T, node: Node<T>?): Node<T>? {
        if (node == null) {
            return null
        }

        when {
            data < node.data -> node.left = remove(data, node.left)
            data > node.data -> node.right = remove(data, node.right)
            else -> {
                if (node.left == null && node.right == null)
                    return null // data deleted with the entire node

                if (node.left == null || node.right == null) {
                    return node.left ?: node.right // data to be deleted has one child
                }

                // data to be deleted has two children
                var newChildrenParent = node.right
                while (newChildrenParent?.left != null) {
                    newChildrenParent = newChildrenParent.left
                }

                newChildrenParent?.data?.let {
                    node.data = it
                    node.right = remove(it, node.right)
                }
            }
        }

        return node
    }

    private fun contains(
        data: T,
        node: Node<T>?,
        iterationCounter: Int = 1
    ): Boolean {
        if (node == null) {
            return false
        }

        println("iterations: $iterationCounter")

        return when {
            data < node.data -> contains(data, node.left, iterationCounter + 1)
            data > node.data -> contains(data, node.right, iterationCounter + 1)
            else -> true
        }
    }

    private fun print(prefix: String, node: Node<T>?): Node<T>? {
        if (node == null) return null

        println("$prefix: ${node.data}")

        if (node.left != null) {
            print("left of ${node.data}", node.left)
        }
        if (node.right != null) {
            print("right of ${node.data}", node.right)
        }

        return node
    }

    private data class Node<T>(
        var data: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null
    )
}