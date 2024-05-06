import org.example.floydWarshall
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Unit tests for the Floyd-Warshall algorithm implementation.
 */
class FloydWarshallTest {

    /**
     * Tests whether the algorithm finds correct minimum distances between pairs of nodes.
     * It constructs a graph with both positive and negative edges and verifies the computed distances.
     */
    @Test
    fun shouldFindCorrectMinimumDistancesBetweenPairsOfNodes() {
        val graph = constructGraph()

        floydWarshall(distance = graph, hasNegativeEdges = true)

        assertEquals(-3.0, graph[0][7])
        assertEquals(Double.POSITIVE_INFINITY, graph[7][0])
        assertEquals(Double.NEGATIVE_INFINITY, graph[0][5])
        assertEquals(Double.POSITIVE_INFINITY, graph[5][0])
        assertEquals(Double.NEGATIVE_INFINITY, graph[3][4])
        assertEquals(Double.NEGATIVE_INFINITY, graph[4][3])
        assertEquals(0.0, graph[2][2])
        assertEquals(Double.POSITIVE_INFINITY, graph[0][6])
    }

    /**
     * Tests whether the algorithm handles an empty graph correctly.
     */
    @Test
    fun shouldHandleEmptyGraph() {
        val emptyGraph = Array(0) { DoubleArray(0) }

        floydWarshall(distance = emptyGraph, hasNegativeEdges = false)

        assertEquals(0, emptyGraph.size)
    }

    /**
     * Tests whether the algorithm handles a graph with a single vertex correctly.
     */
    @Test
    fun shouldHandleSingleVertexGraph() {
        val singleVertexGraph = Array(1) { DoubleArray(1) }

        floydWarshall(distance = singleVertexGraph, hasNegativeEdges = false)

        assertEquals(0.0, singleVertexGraph[0][0])
    }

    /**
     * Tests whether the algorithm handles a disconnected graph correctly.
     */
    @Test
    fun shouldHandleDisconnectedGraph() {
        val disconnectedGraph = Array(4) { DoubleArray(4) { Double.POSITIVE_INFINITY } }

        floydWarshall(distance = disconnectedGraph, hasNegativeEdges = false)

        assertEquals(Double.POSITIVE_INFINITY, disconnectedGraph[0][0])
        assertEquals(Double.POSITIVE_INFINITY, disconnectedGraph[1][2])
        assertEquals(Double.POSITIVE_INFINITY, disconnectedGraph[2][1])
        assertEquals(Double.POSITIVE_INFINITY, disconnectedGraph[3][3])
    }

    /**
     * Tests whether the algorithm handles a graph with negative cycles correctly.
     */
    @Test
    fun shouldHandleGraphWithNegativeCycles() {
        val graph = constructGraphWithNegativeCycles()

        floydWarshall(distance = graph, hasNegativeEdges = true)

        assertEquals(Double.NEGATIVE_INFINITY, graph[0][7])
        assertEquals(Double.NEGATIVE_INFINITY, graph[7][0])
        assertEquals(Double.NEGATIVE_INFINITY, graph[0][5])
        assertEquals(Double.POSITIVE_INFINITY, graph[5][0])
        assertEquals(Double.NEGATIVE_INFINITY, graph[3][4])
        assertEquals(Double.NEGATIVE_INFINITY, graph[4][3])
        assertEquals(Double.NEGATIVE_INFINITY, graph[2][2])
        assertEquals(Double.POSITIVE_INFINITY, graph[0][6])
    }

    /**
     * Helper function to construct a sample graph for testing.
     */
    private fun constructGraph(): Array<DoubleArray> {
        val n = 8
        val graph = Array(n) { DoubleArray(n) { Double.POSITIVE_INFINITY } }
        for (i in graph.indices) {
            graph[i][i] = 0.0
        }
        graph[0][1] = 5.0
        graph[0][2] = 5.0
        graph[2][7] = -8.0
        graph[0][3] = 100.0
        graph[3][4] = 99.0
        graph[4][3] = -100.0
        graph[4][5] = 100.0

        return graph
    }

    /**
     * Helper function to construct a sample graph with negative cycles for testing.
     */
    private fun constructGraphWithNegativeCycles(): Array<DoubleArray> {
        val n = 8
        val graph = Array(n) { DoubleArray(n) { Double.POSITIVE_INFINITY } }
        for (i in graph.indices) {
            graph[i][i] = 0.0
        }
        graph[0][1] = 5.0
        graph[0][2] = 5.0
        graph[2][7] = -8.0
        graph[0][3] = 100.0
        graph[3][4] = 99.0
        graph[4][3] = -100.0
        graph[4][5] = 100.0
        graph[7][0] = -3.0 // Creating a negative cycle from node 7 to node 0

        return graph
    }
}
