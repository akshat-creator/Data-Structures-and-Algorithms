import kotlin.system.measureTimeMillis
import org.example.*

fun main() {
    // Define parameters for experiments
    val graphSizes = intArrayOf(10, 200, 1000) // Varying sizes of graphs
    val densities = doubleArrayOf(0.2, 0.5, 0.8) // Varying densities of graphs
    val iterations = 5

    // Perform experiments
    for (size in graphSizes) {
        for (density in densities) {
            println("Running experiments for graph size $size and density $density...")
            val graph = generateGraph(size, density)

            // Measure execution time
            var totalTime = 0L
            repeat(iterations) {
                totalTime += measureTimeMillis {
                    floydWarshall(graph)
                }
            }

            // Calculate average execution time
            val averageTime = totalTime / iterations
            println("Average execution time for $iterations iterations: $averageTime ms\n")
        }
    }
}

/**
 * Generate a random graph with the given size and density.
 * The graph is represented as a 2D array of distances between vertices.
 */
fun generateGraph(size: Int, density: Double): Array<DoubleArray> {
    val graph = Array(size) { DoubleArray(size) }

    // Initialize distances between vertices
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (i != j && Math.random() < density) {
                // Generate a random distance for connected vertices
                graph[i][j] = (1 + Math.random() * 10) // Adjust range as needed
            } else {
                graph[i][j] = Double.POSITIVE_INFINITY
            }
        }
    }

    return graph
}
