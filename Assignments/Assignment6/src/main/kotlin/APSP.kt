package org.example

/**
 * This code implements the Floyd-Warshall algorithm,
 * which finds the shortest path between all pairs of vertices in a given graph. It can also detect negative cycles.
 * @param distance An array representing the vertices in the graph.
 * @param hasNegativeEdges Indicates whether the graph contains negative edges or not.
 */
fun floydWarshall(distance: Array<DoubleArray>, hasNegativeEdges: Boolean = false) {

    setAllPairsDistances(distance)
    if (hasNegativeEdges) {
        markNegativeCycles(distance)
    }
}


/**
 * Update the distances between all pairs of vertices in the graph.
 *
 * @param distance A 2D array representing the distances between any two pairs of vertices.
 */
private fun setAllPairsDistances(dist: Array<DoubleArray>) {
    for (a in dist.indices) {
        for (b in dist.indices) {
            for (c in dist.indices) {
                if (dist[b][c] > dist[b][a] + dist[a][c]) {
                    dist[b][c] = dist[b][a] + dist[a][c]
                }
            }
        }
    }
}

/**
 * Mark distance between a pair of vertices as negative infinity when a
 * negative cycle exists.
 *
 * @param distance A 2D array storing the distance between any two pairs of vertices
 */
private fun markNegativeCycles(dist: Array<DoubleArray>) {
    for (a in dist.indices) {
        for (b in dist.indices) {
            for (c in dist.indices) {
                if (dist[b][c] > dist[b][a] + dist[a][c]) {
                    dist[b][c] = Double.NEGATIVE_INFINITY
                }
            }
        }
    }
}