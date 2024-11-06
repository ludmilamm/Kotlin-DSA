package leetcode.tree

import kotlin.math.max

fun diameterOfBinaryTree(root: TreeNode?): Int {
    var edgeCounter = 0

    fun dfs(currentNode: TreeNode?) : Int{
        if (currentNode == null) return 0

        val leftEdges = dfs(currentNode.left)
        val rightEdges = dfs(currentNode.right)

        edgeCounter = max(edgeCounter, leftEdges + rightEdges)
        return  max(leftEdges, rightEdges) + 1
    }

    dfs(root)
    return edgeCounter
}

fun main() {
    val tree = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
            right = TreeNode(5)
        }
        right = TreeNode(3)
    }

    println(diameterOfBinaryTree(tree))
}