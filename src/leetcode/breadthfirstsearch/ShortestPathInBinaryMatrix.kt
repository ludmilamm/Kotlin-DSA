package leetcode.breadthfirstsearch

fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return -1

    val rows = grid.size
    val columns = grid[0].size

    if (grid[0][0] == 1 || grid[rows - 1][columns - 1] == 1)
        return -1

    val queue = ArrayDeque<Triple<Int, Int, Int>>() // row, column, steps
    val visited = mutableSetOf<Pair<Int, Int>>()

    queue.add(Triple(0, 0, 1))
    visited.add(0 to 0)

    while (queue.isNotEmpty()) {
        val toVisit = queue.removeFirst()
        val row = toVisit.first
        val column = toVisit.second
        val steps = toVisit.third

        if (row == rows - 1 && column == columns - 1) {
            return steps
        }

        for (directionRow in -1..1) {
            for (directionColumn in -1..1) {
                val neighborRow = row + directionRow
                val neighborColumn = column + directionColumn

                if (neighborRow in 0..<rows &&
                    neighborColumn in 0..<columns &&
                    grid[neighborRow][neighborColumn] == 0 &&
                    visited.contains(neighborRow to neighborColumn).not()
                ) {
                    queue.add(Triple(neighborRow, neighborColumn, steps + 1))
                    visited.add(neighborRow to neighborColumn)
                }
            }
        }
    }

    return -1
}

fun main() {
    println(
        shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0)
            )
        )
    )
}