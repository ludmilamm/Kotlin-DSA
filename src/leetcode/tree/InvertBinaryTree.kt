package leetcode.tree

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val auxLeft = root.left
    root.left = root.right
    root.right = auxLeft

    invertTree(root.left)
    invertTree(root.right)

    return root
}

fun main() {

}