package leetcode.tree

import kotlin.math.max

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0

    var maxDepth = 0

    fun dfs(currentNode: TreeNode?, depthCounter: Int) {
        if (currentNode?.left == null && currentNode?.right == null) {
            maxDepth = max(maxDepth, depthCounter)
            return
        }

        dfs(currentNode.left, depthCounter + 1)
        dfs(currentNode.right, depthCounter + 1)
    }

    dfs(root, 1)

    return maxDepth
}

fun main() {
    val tree = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    println(maxDepth(tree))
}