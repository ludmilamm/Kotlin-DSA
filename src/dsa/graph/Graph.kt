package dsa.graph

class Graph<T>(private val isUndirected: Boolean = true) {

    private val neighborhood = mutableMapOf<T, MutableList<T>>()
    val size: Int
        get() = neighborhood.size

    fun add(data: T) {
        neighborhood[data] = mutableListOf()
    }

    fun addEdge(data: T, neighbor: T) {
        neighborhood.getOrPut(data) { mutableListOf() }.add(neighbor)
        if (isUndirected) {
            neighborhood.getOrPut(neighbor) { mutableListOf() }.add(data)
        }
    }

    fun getNeighbors(data: T): List<T> = neighborhood[data].orEmpty()

    fun print() {
        for ((data, connections) in neighborhood) {
            println("$data: $connections")
        }
    }
}