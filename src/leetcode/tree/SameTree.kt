package leetcode.tree

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

    fun isSameNode(nodeP: TreeNode?, nodeQ: TreeNode?): Boolean {
        if (nodeQ == null && nodeP == null) return true

        if (nodeP?.`val` != nodeQ?.`val`) return false

        return isSameNode(nodeP?.left, nodeQ?.left) && isSameNode(nodeP?.right, nodeQ?.right)
    }

    return isSameNode(p, q)
}

fun main() {
    val p = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    val q = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    println(isSameTree(p, q))
}