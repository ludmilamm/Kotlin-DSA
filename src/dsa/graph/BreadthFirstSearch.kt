package dsa.graph

import dsa.queue.Queue

class BreadthFirstSearch<T>(private val graph: Graph<T>) {

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
        val queue= Queue<T>()
        queue.push(data)

        while(queue.isEmpty().not()) {
            val vertex = queue.pop()
            if (marker.getOrElse(vertex!!) { false }.not()) {
                visited.add(vertex)
                marker[vertex] = true

                for (n in graph.getNeighbors(vertex)) {
                    if (marker.getOrElse(n) { false }.not()) {
                        queue.push(n)
                    }
                }
            }
        }
    }
}