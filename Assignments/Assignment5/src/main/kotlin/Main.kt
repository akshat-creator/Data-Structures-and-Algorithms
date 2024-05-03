package org.example

fun main() {
    // Create two square matrices
    val size = 4
    val matrix1 = SquareMatrix(size)
    val matrix2 = SquareMatrix(size)

    // Fill matrices with sample data
    for (i in 0 until size) {
        for (j in 0 until size) {
            matrix1.setValue(i, j, i * size + j)
            matrix2.setValue(i, j, (i * size + j) * 2)
        }
    }

    // Print the matrices
    println("Matrix 1:")
    println(matrix1)
    println("Matrix 2:")
    println(matrix2)

    // Multiply the matrices
    val result = matrix1.multiply(matrix2)

    // Print the result
    if (result != null) {
        println("Result of matrix multiplication:")
        println(result)
    } else {
        println("Matrices cannot be multiplied due to incompatible dimensions.")
    }

    val sequence1 = "AGTACGCA"
    val sequence2 = "TATGC"

    val resultneedleman = needlemanWunsch(sequence1, sequence2)
    val alignedSequences = backtrace(resultneedleman.tracebackMatrix, sequence1, sequence2)

    println("Best alignment score: ${resultneedleman.alignmentMatrix[sequence1.length][sequence2.length]}")
    println("Aligned Sequences:")
    println(alignedSequences.first)
    println(alignedSequences.second)
}

data class AlignmentResult(
    val alignmentMatrix: Array<IntArray>,
    val tracebackMatrix: Array<Array<Direction>>
)
