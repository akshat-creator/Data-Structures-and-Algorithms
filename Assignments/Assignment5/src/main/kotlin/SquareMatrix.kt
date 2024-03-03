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

}
