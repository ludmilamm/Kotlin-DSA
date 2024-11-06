package leetcode.depthfirstsearch

fun exist(board: Array<CharArray>, word: String): Boolean {
    if (board.isEmpty() || word.isEmpty()) return false
    val rows = board.size
    val columns = board[0].size
    val visited = mutableSetOf<Pair<Int, Int>>()

    fun dfs(row: Int, column: Int, letterIndex: Int): Boolean {
        if (letterIndex == word.length) return true
        if (
            row < 0 ||
            row >= rows ||
            column < 0 ||
            column >= columns ||
            word[letterIndex] != board[row][column] ||
            visited.contains(row to column)
        ) {
            return false
        }

        visited.add(row to column)
        val result = dfs(row + 1, column, letterIndex + 1) ||
                dfs(row - 1, column, letterIndex + 1) ||
                dfs(row, column + 1, letterIndex + 1) ||
                dfs(row, column - 1, letterIndex + 1)
        visited.remove(row to column)
        return result
    }

    for (i in 0..<rows) {
        for (j in 0..<columns) {
            if (dfs(i, j, 0)) {
                return true
            }
        }
    }

    return false
}

fun main() {
    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ),
            "WER"
        )
    )
}