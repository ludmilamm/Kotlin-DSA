package dsa.graph

class DepthFirstSearch<T>(private val graph: Graph<T>) {

    fun searchConnections(data: T): List<T> {
        val marker = mutableMapOf<T, Boolean>()
        val visited = mutableListOf<T>()

        searchConnections(
            data = data,
            visited = visited,
            marker = marker
        )

        return visited
    }

    private fun searchConnections(
        data: T,
        visited: MutableList<T>,
        marker: MutableMap<T, Boolean>
    ) {
        visited.add(data)
        marker[data] = true
        for (n in graph.getNeighbors(data)) {
            if (marker.getOrElse(n) { false }.not()) {
                searchConnections(n, visited, marker)
            }
        }
    }
}