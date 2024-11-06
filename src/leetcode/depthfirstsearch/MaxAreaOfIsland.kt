package leetcode.depthfirstsearch

import kotlin.math.max

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0
    val rows = grid.size
    val columns = grid[0].size
    var maxArea = 0

    fun dfs(i: Int, j: Int): Int {
        if (i < 0 || j < 0 || i >= rows || j >= columns || grid[i][j] == 0) {
            return 0
        }

        grid[i][j] = 0
        return dfs(i + 1, j) +
                dfs(i - 1, j) +
                dfs(i, j + 1) +
                dfs(i, j - 1) + 1
    }

    for (i in 0..<rows) {
        for (j in 0..<columns) {
            if (grid[i][j] == 1) {
                maxArea = max(maxArea, dfs(i, j))
            }
        }
    }

    return maxArea
}

fun main() {
    println(
        maxAreaOfIsland(
            arrayOf(
                intArrayOf(1, 1, 0, 0, 0),
                intArrayOf(1, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1),
                intArrayOf(0, 0, 0, 1, 0)
            )
        )
    )
}