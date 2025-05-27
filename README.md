# Kotlin DSA (Data Structures and Algorithms)

This repository contains implementations of common data structures and algorithms in Kotlin, as well as solutions to various LeetCode problems. It serves as both a learning resource and a reference for Kotlin developers interested in data structures, algorithms, and competitive programming.

## Project Structure

The project is organized into two main directories:

### Data Structures and Algorithms (`src/dsa/`)

Contains implementations of common data structures and algorithms:

- **Arrays**: Custom array implementations
- **Graphs**: Graph representations and traversal algorithms (BFS, DFS)
- **Linked Lists**: Singly and doubly linked list implementations
- **Queues**: Queue data structure
- **Sorting Algorithms**: Various sorting algorithms (HeapSort, InsertionSort, MergeSort, QuickSort, TopologicalSort)
- **Stacks**: Stack data structure
- **Trees**: Binary search tree implementation

### LeetCode Solutions (`src/leetcode/`)

Solutions to various LeetCode problems, organized by category:

- **Array**: Problems involving array manipulation
- **Backtracking**: Backtracking algorithm problems
- **Binary Search**: Binary search algorithm problems
- **Bit Manipulation**: Bit manipulation problems
- **Breadth-First Search**: BFS algorithm problems
- **Depth-First Search**: DFS algorithm problems
- **Dynamic Programming**: DP problems
- **Greedy**: Greedy algorithm problems
- **Heap**: Heap/Priority Queue problems
- **Linked List**: Linked list problems
- **Sliding Window**: Sliding window technique problems
- **Stack**: Stack-based problems
- **Topological Sort**: Topological sorting problems
- **Tree**: Binary tree problems
- **Two Pointers**: Two-pointer technique problems

## Getting Started

### Prerequisites

- JDK 8 or higher
- Kotlin compiler

### Setup

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/Kotlin-DSA.git
   ```

2. Open the project in your preferred IDE (IntelliJ IDEA recommended for Kotlin projects)

3. Build the project to ensure all dependencies are resolved

## Usage

### Data Structures

Each data structure implementation includes common operations with time complexity annotations. For example, to use the LinkedList:

```kotlin
fun main() {
    val list = LinkedList<Int>()
    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    list.print() // Prints: 1, 2, 3
}
```

### LeetCode Solutions

Each LeetCode solution includes a main function for testing. You can run these solutions directly to see the output:

```kotlin
fun main() {
    val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
    println(result.joinToString()) // Prints: 0, 1
}
```

## Contributing

Contributions are welcome! If you'd like to add new data structures, algorithms, or LeetCode solutions, please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature`)
3. Implement your changes
4. Add appropriate tests and documentation
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- LeetCode for providing the programming problems
- The Kotlin community for resources and inspiration
