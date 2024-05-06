# All-Pairs Shortest Paths (APSP) Algorithm
### Introduction
The All-Pairs Shortest Paths (APSP) problem is a fundamental problem in graph theory. It aims to find the shortest path between every pair of nodes in a graph. This is in contrast to the single-source shortest path problem, which only focuses on finding the shortest paths from a single source node to all other nodes.

### Underlying Principles
The APSP algorithm relies on the concept of dynamic programming. It solves the problem by iteratively building up solutions to smaller subproblems. Here's the general idea:

Start with the shortest paths of length 1: 
Consider all edges directly connecting nodes. These paths have a length of 1 and represent the base case.
Iteratively expand possible paths: In each iteration, the algorithm examines paths of length k (where k is the current iteration number). It considers all pairs of nodes (u, v) and checks if there exists a node w, such that the combination of the shortest path from u to w (length k-1) and the edge from w to v leads to a shorter path from u to v compared to previously found paths.
Update shortest paths: If a shorter path is found in any iteration, the algorithm updates the distance and potentially the path itself for the specific node pair.
This process continues until the algorithm reaches the maximum possible path length (which is equal to the number of nodes in the worst case). By the end, the algorithm has effectively considered all possible paths between every node pair and identified the shortest ones.

### Popular APSP Algorithms
There are several algorithms for solving the APSP problem, each with different time and space complexities. Here are two common ones:

Floyd-Warshall Algorithm: This is a versatile algorithm that works for directed graphs with arbitrary edge weights (including negative weights). It has a time complexity of O(n^3), where n is the number of nodes in the graph.

Johnson's Algorithm: This algorithm is specifically designed for sparse graphs with negative edge weights. It preprocesses the graph to eliminate negative weight cycles and then utilizes Dijkstra's algorithm for single-source shortest paths. Johnson's algorithm has a time complexity of O(mn + n^2 log n), where m is the number of edges in the graph.

### Computational Complexity
I have implemented the Floyd-Warshall Algorithm for this project, the computational complexity of the APSP problem depends on the chosen algorithm and the characteristics of the graph (directed vs. undirected, edge weights, density). Here's a summary:

Floyd-Warshall Algorithm: O(n^3) - This is the dominant factor for dense graphs.
Note: For specific graph types (e.g., unweighted directed acyclic graphs), specialized algorithms with lower complexities might exist.

### Conclusion
The APSP algorithm is a powerful tool for finding shortest paths in various applications, including navigation systems, network routing protocols, and social network analysis. While the computational cost can be significant for dense graphs, efficient algorithms like Floyd-Warshall make it a practical solution for many real-world scenarios.