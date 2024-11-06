package leetcode.tree

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (subRoot == null) return true
    if (root == null) return false

    fun isSameSubtree(rootNode: TreeNode?, subRootNode: TreeNode?): Boolean {
        if (rootNode == null && subRootNode == null) return true

        if (rootNode?.`val` != subRootNode?.`val`) return false

        return isSameSubtree(rootNode?.left, subRootNode?.left) && isSameSubtree(rootNode?.right, subRootNode?.right)
    }

    return if (isSameSubtree(root, subRoot)) {
        true
    } else {
        isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
}

fun main() {
    val root = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    val subRoot = TreeNode(20).apply {
        left = TreeNode(15)
        right = TreeNode(7)
    }

    println(isSubtree(root, subRoot))
}