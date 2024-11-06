package leetcode.topologicalsort

import java.util.*

fun canFinish(
    numCourses: Int,
    prerequisites: Array<IntArray>
): Boolean {
    val graph = mutableMapOf<Int, MutableList<Int>>()
    val coursesDegree = IntArray(numCourses) { 0 }
    val queue = ArrayDeque<Int>()
    var topoCount = 0

    prerequisites.forEach {
        val course = it[0]
        val prerequisit = it[1]

        graph[prerequisit] = graph[prerequisit]?.apply { add(course) } ?: mutableListOf(course)
        coursesDegree[course]++
    }

    coursesDegree.forEachIndexed { course, degree ->
        if (degree == 0) {
            queue.offer(course)
        }
    }

    while (queue.isNotEmpty()) {
        val course = queue.poll()
        topoCount++

        graph[course]?.forEach { neighbor ->
            coursesDegree[neighbor]--
            if (coursesDegree[neighbor] == 0) {
                queue.offer(neighbor)
            }
        }
    }

    return topoCount == numCourses
}

fun main() {
    val result = canFinish(2, arrayOf(intArrayOf(0, 1)))
    println(result)
}