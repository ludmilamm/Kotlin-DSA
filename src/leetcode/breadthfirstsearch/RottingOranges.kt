package leetcode.breadthfirstsearch

fun orangesRotting(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return -1

    val rows = grid.size
    val columns = grid[0].size
    val queue = ArrayDeque<Pair<Int, Int>>()
    val directions = arrayOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0
    )

    var minutes = 0
    var freshCounter = 0

    for (i in 0..<rows) {
        for (j in 0..<columns) {
            when (grid[i][j]) {
                2 -> queue.add(i to j)
                1 -> freshCounter++
            }
        }
    }

    while (queue.isNotEmpty() && freshCounter > 0) {
        for (i in 0..<queue.size) {
            val (row, column) = queue.removeFirst()

            for ((directionRow, directionColumn) in directions) {
                val newRow = row + directionRow
                val newColumn = column + directionColumn

                if (newRow in 0..<rows &&
                    newColumn in 0..<columns &&
                    grid[newRow][newColumn] == 1
                ) {
                    queue.add(newRow to newColumn)
                    freshCounter--
                    grid[newRow][newColumn] = 2
                }
            }
        }
        minutes++
    }

    return if (freshCounter == 0) minutes else -1
}

fun main() {
    println(
        orangesRotting(
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 1)
            )
        )
    )
}