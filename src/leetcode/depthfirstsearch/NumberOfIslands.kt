package leetcode.depthfirstsearch

@OptIn(ExperimentalStdlibApi::class)
fun numIslands(grid: Array<CharArray>): Int {
    val rows = grid.size
    val columns = grid[0].size
    var islands = 0

    fun dfs(i: Int, j: Int) {
        if (i < 0 || j < 0 || i >= rows || j >= columns || grid[i][j] == '0') return
        grid[i][j] = '0'
        dfs(i + 1, j)
        dfs(i, j + 1)
    }

    for (i in 0..<rows) {
        for (j in 0..<columns) {
            if (grid[i][j] == '1') {
                islands++
                dfs(i, j)
            }
        }
    }

    return islands
}

fun main() {
    println(
        numIslands(
            arrayOf(
                charArrayOf('1','1','1','1','0'),
                charArrayOf('1','1','0','1','0'),
                charArrayOf('1','1','0','0','1'),
                charArrayOf('0','0','0','1','0')
            )
        )
    )
}