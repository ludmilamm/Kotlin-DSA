package leetcode.tree

import kotlin.math.abs
import kotlin.math.max

fun isBalanced(root: TreeNode?): Boolean {
    var isBalanced = true

    fun height(currentNode: TreeNode?): Int {
        if (currentNode == null) return 0

        val leftHeight = height(currentNode.left)
        if (isBalanced.not()) return 0

        val rightHeight = height(currentNode.right)

        if (abs(leftHeight - rightHeight) > 1) {
            isBalanced = false
            return 0
        }

        return max(leftHeight, rightHeight) + 1
    }

    height(root)

    return isBalanced
}

fun main() {
    val tree = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    println(isBalanced(tree))
}