package org.example

class SquareMatrix(private val size: Int) {
    private val matrix: Array<IntArray> = Array(size) { IntArray(size) }

    init {
        require(size > 0) { "Size must be a positive integer" }
    }

    fun setValue(row: Int, col: Int, value: Int) {
        checkIndices(row, col)
        matrix[row][col] = value
    }

    fun getValue(row: Int, col: Int): Int {
        checkIndices(row, col)
        return matrix[row][col]
    }

    private fun checkIndices(row: Int, col: Int) {
        require(row in 0 until size) { "Row index out of bounds" }
        require(col in 0 until size) { "Column index out of bounds" }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (i in 0 until size) {
            for (j in 0 until size) {
                sb.append(matrix[i][j]).append(" ")
            }
            sb.append("\n")
        }
        return sb.toString()
    }

    /**
     * Multiply [this] matrix by [other].
     * You can implement this either using block-based matrix multiplication or
     * traditional matrix multiplication (the kind you learn about in math
     * classes!)
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    fun multiply(other: SquareMatrix): SquareMatrix? {
        if (size != other.size) return null // Check if dimensions are compatible

        val result = SquareMatrix(size)

        for (i in 0 until size) {
            for (j in 0 until size) {
                var sum = 0
                for (k in 0 until size) {
                    sum += matrix[i][k] * other.matrix[k][j]
                }
                result.setValue(i, j, sum)
            }
        }

        return result
    }
    /**
     * Multiply [this] matrix by [other].
     * Your code should use Strassen's algorithm
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    fun strassen(a: SquareMatrix, b: SquareMatrix): SquareMatrix {
        // Check if the matrices are square and have the same dimensions.

        if (a.size != a.size || b.size != b.size || a.size != b.size) {
            throw IllegalArgumentException("Matrices must be square and have the same dimensions.")
        }

        // If the matrices are small enough, use the naive algorithm.
        if (a.size <= 2) {
            return a.multiply(b) ?: throw IllegalStateException("Multiplication result is null.")
        }

        // Divide the matrices into four submatrices.
        val a11 = a.submatrix(0, a.size / 2, 0, a.size / 2)
        val a12 = a.submatrix(0, a.size / 2, a.size / 2, a.size)
        val a21 = a.submatrix(a.size / 2, a.size, 0, a.size / 2)
        val a22 = a.submatrix(a.size / 2, a.size, a.size / 2, a.size)
        val b11 = b.submatrix(0, b.size / 2, 0, b.size / 2)
        val b12 = b.submatrix(0, b.size / 2, b.size / 2, b.size)
        val b21 = b.submatrix(b.size / 2, b.size, 0, b.size / 2)
        val b22 = b.submatrix(b.size / 2, b.size, b.size / 2, b.size)

        // Compute the seven subproblems.
        val p1 = strassen(a11.add(a22), b11.add(b22))
        val p2 = strassen(a21.add(a22), b11)
        val p3 = strassen(a11, b12.subtract(b22))
        val p4 = strassen(a22, b21.subtract(b11))
        val p5 = strassen(a11.add(a12), b22)
        val p6 = strassen(a21.subtract(a11), b11.add(b12))
        val p7 = strassen(a12.subtract(a22), b21.add(b22))

        // Combine the subproblems to form the result matrix.
        val c11 = p1.add(p4).subtract(p5).add(p7)
        val c12 = p3.add(p5)
        val c21 = p2.add(p4)
        val c22 = p1.add(p3).subtract(p2).add(p6)

        // Combine the submatrices into the result matrix.
        val result = SquareMatrix(a.size)
        result.joinSubmatrices(c11, c12, c21, c22)

        return result
    }

    private fun submatrix(startRow: Int, endRow: Int, startCol: Int, endCol: Int): SquareMatrix {

        /**
         * Extracts a submatrix from the current matrix based on the provided indices.
         *
         * @param startRow The starting row index (inclusive) of the submatrix.
         * @param endRow The ending row index (exclusive) of the submatrix.
         * @param startCol The starting column index (inclusive) of the submatrix.
         * @param endCol The ending column index (exclusive) of the submatrix.
         * @return A new SquareMatrix representing the extracted submatrix.
         */

        val subSize = endRow - startRow
        val submatrix = SquareMatrix(subSize)

        for (i in 0 until subSize) {
            for (j in 0 until subSize) {
                submatrix.setValue(i, j, matrix[startRow + i][startCol + j])
            }
        }
        return submatrix
    }

    private fun joinSubmatrices(c11: SquareMatrix, c12: SquareMatrix, c21: SquareMatrix, c22: SquareMatrix) {

        /**
         * Joins four submatrices into the current matrix.
         *
         * @param c11 Top-left submatrix.
         * @param c12 Top-right submatrix.
         * @param c21 Bottom-left submatrix.
         * @param c22 Bottom-right submatrix.
         */

        val subSize = c11.size
        for (i in 0 until subSize) {
            for (j in 0 until subSize) {
                matrix[i][j] = c11.getValue(i, j)
                matrix[i][j + subSize] = c12.getValue(i, j)
                matrix[i + subSize][j] = c21.getValue(i, j)
                matrix[i + subSize][j + subSize] = c22.getValue(i, j)
            }
        }
    }

    private fun add(other: SquareMatrix): SquareMatrix {

        /**
         * Adds another SquareMatrix to the current matrix element-wise.
         *
         * @param other The SquareMatrix to be added.
         * @return A new SquareMatrix representing the result of the addition.
         */

        val result = SquareMatrix(size)
        for (i in 0 until size) {
            for (j in 0 until size) {
                result.setValue(i, j, matrix[i][j] + other.matrix[i][j])
            }
        }
        return result
    }

    private fun subtract(other: SquareMatrix): SquareMatrix {

        /**
         * Subtracts another SquareMatrix from the current matrix element-wise.
         *
         * @param other The SquareMatrix to be subtracted.
         * @return A new SquareMatrix representing the result of the subtraction.
         */

        val result = SquareMatrix(size)
        for (i in 0 until size) {
            for (j in 0 until size) {
                result.setValue(i, j, matrix[i][j] - other.matrix[i][j])
            }
        }
        return result
    }

    fun getSize(): Int {
        return size
    }

}

enum class Direction {
    DIAGONAL, LEFT, UP
}

fun needlemanWunsch(sequence1: String, sequence2: String): AlignmentResult {

    /**
     * Performs global sequence alignment using the Needleman-Wunsch algorithm.
     *
     * This algorithm aligns two sequences by finding the optimal alignment that maximizes
     * a similarity score based on match, mismatch, and gap penalties.
     *
     * @param sequence1 The first sequence to be aligned.
     * @param sequence2 The second sequence to be aligned.
     * @return An [AlignmentResult] object containing the alignment matrix and traceback matrix.
     */

    val n = sequence1.length
    val m = sequence2.length

    val alignmentMatrix = Array(n + 1) { IntArray(m + 1) }
    val tracebackMatrix = Array(n + 1) { Array<Direction>(m + 1) { Direction.DIAGONAL } }

    for (i in 1..n) {
        alignmentMatrix[i][0] = i * -1
    }
    for (j in 1..m) {
        alignmentMatrix[0][j] = j * -1
    }

    for (i in 1..n) {
        for (j in 1..m) {
            val match = if (sequence1[i - 1] == sequence2[j - 1]) 1 else -1
            val diagonalScore = alignmentMatrix[i - 1][j - 1] + match
            val leftScore = alignmentMatrix[i][j - 1] - 1
            val upScore = alignmentMatrix[i - 1][j] - 1

            val maxScore = maxOf(diagonalScore, leftScore, upScore)

            alignmentMatrix[i][j] = maxScore

            if (maxScore == diagonalScore) {
                tracebackMatrix[i][j] = Direction.DIAGONAL
            } else if (maxScore == leftScore) {
                tracebackMatrix[i][j] = Direction.LEFT
            } else {
                tracebackMatrix[i][j] = Direction.UP
            }
        }
    }

    return AlignmentResult(alignmentMatrix, tracebackMatrix)
}

fun backtrace(
    tracebackMatrix: Array<Array<Direction>>,
    sequence1: String,
    sequence2: String
): Pair<String, String> {

    /**
     * Backtraces through the traceback matrix to generate the aligned sequences.
     *
     * This function reconstructs the optimal alignment by tracing back through the traceback matrix
     * generated by the Needleman-Wunsch algorithm.
     *
     * @param tracebackMatrix The traceback matrix obtained from the Needleman-Wunsch algorithm.
     * @param sequence1 The first sequence used in alignment.
     * @param sequence2 The second sequence used in alignment.
     * @return A pair of aligned sequences representing the optimal alignment.
     */

    var i = sequence1.length
    var j = sequence2.length

    val alignedSequence1 = StringBuilder()
    val alignedSequence2 = StringBuilder()

    while (i > 0 || j > 0) {
        when (tracebackMatrix[i][j]) {
            Direction.DIAGONAL -> {
                alignedSequence1.append(if (i > 0) sequence1[--i] else '-')
                alignedSequence2.append(if (j > 0) sequence2[--j] else '-')
            }
            Direction.LEFT -> {
                alignedSequence1.append('-')
                alignedSequence2.append(sequence2[--j])
            }
            Direction.UP -> {
                alignedSequence1.append(sequence1[--i])
                alignedSequence2.append('-')
            }
        }
    }

    return Pair(alignedSequence1.reverse().toString(), alignedSequence2.reverse().toString())
}

