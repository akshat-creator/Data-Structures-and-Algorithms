package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

/**
 * Unit tests for the SquareMatrix class.
 */
class SquareMatrixTest {

    /**
     * Tests the multiply function of SquareMatrix class.
     * Verifies that the multiplication of two matrices produces the correct result.
     */
    @Test
    fun testMultiply() {
        // Arrange
        val matrix1 = SquareMatrix(2).apply {
            setValue(0, 0, 1)
            setValue(0, 1, 2)
            setValue(1, 0, 3)
            setValue(1, 1, 4)
        }

        val matrix2 = SquareMatrix(2).apply {
            setValue(0, 0, 5)
            setValue(0, 1, 6)
            setValue(1, 0, 7)
            setValue(1, 1, 8)
        }

        // Expected result
        val expectedResult = SquareMatrix(2).apply {
            setValue(0, 0, 19)
            setValue(0, 1, 22)
            setValue(1, 0, 43)
            setValue(1, 1, 50)
        }

        // Act
        val result = matrix1.multiply(matrix2)

        // Assert
        assertEquals(expectedResult.toString(), result.toString())
    }

    /**
     * Tests the multiply function of SquareMatrix class with incompatible sizes.
     * Verifies that null is returned when multiplying matrices with incompatible sizes.
     */
    @Test
    fun testMultiplyWithIncompatibleSizes() {
        // Arrange
        val matrix1 = SquareMatrix(2)
        val matrix2 = SquareMatrix(3)

        // Act
        val result = matrix1.multiply(matrix2)

        // Assert
        assertNull(result)
    }

    /**
     * Tests the Strassen multiplication algorithm in SquareMatrix class.
     * Verifies that the multiplication using Strassen's algorithm produces the correct result.
     */
    @Test
    fun testStrassenMultiply() {
        // Arrange
        val matrix1 = SquareMatrix(2).apply {
            setValue(0, 0, 1)
            setValue(0, 1, 2)
            setValue(1, 0, 3)
            setValue(1, 1, 4)
        }

        val matrix2 = SquareMatrix(2).apply {
            setValue(0, 0, 5)
            setValue(0, 1, 6)
            setValue(1, 0, 7)
            setValue(1, 1, 8)
        }

        // Expected result
        val expectedResult = SquareMatrix(2).apply {
            setValue(0, 0, 19)
            setValue(0, 1, 22)
            setValue(1, 0, 43)
            setValue(1, 1, 50)
        }

        // Act
        val result = SquareMatrix(matrix1.getSize()).strassen(matrix1, matrix2)

        // Assert
        assertEquals(expectedResult.toString(), result.toString())
    }

    /**
     * Tests the Strassen multiplication algorithm in SquareMatrix class with incompatible sizes.
     * Verifies that IllegalArgumentException is thrown when multiplying matrices with incompatible sizes.
     */
    @Test
    fun testStrassenMultiplyWithIncompatibleSizes() {
        // Arrange
        val matrix1 = SquareMatrix(2)
        val matrix2 = SquareMatrix(3)

        // Act & Assert
        try {
            matrix1.strassen(matrix1, matrix2)
        } catch (e: IllegalArgumentException) {
            assertEquals("Matrices must be square and have the same dimensions.", e.message)
        }
    }
}

/**
 * Unit tests for the Needleman-Wunsch algorithm.
 */
class NeedlemanWunschTest {

    /**
     * Tests the alignment of two DNA sequences using the Needleman-Wunsch algorithm.
     * Verifies that the algorithm aligns the sequences correctly.
     */
    @Test
    fun testAlignment1() {
        // Arrange
        val sequence1 = "AGTACGCA"
        val sequence2 = "TATGC"

        // Act
        val result = needlemanWunsch(sequence1, sequence2)
        val alignedSequences = backtrace(result.tracebackMatrix, sequence1, sequence2)

        // Assert
        assertEquals("AGTACGCA", alignedSequences.first)
        assertEquals("--TATGC-", alignedSequences.second)
    }

    /**
     * Tests the alignment of two DNA sequences using the Needleman-Wunsch algorithm.
     * Verifies that the algorithm aligns the sequences correctly.
     */
    @Test
    fun testAlignment2() {
        // Arrange
        val sequence1 = "GATTACA"
        val sequence2 = "GCATGCU"

        // Act
        val result = needlemanWunsch(sequence1, sequence2)
        val alignedSequences = backtrace(result.tracebackMatrix, sequence1, sequence2)

        // Assert
        assertEquals("G-ATTACA", alignedSequences.first)
        assertEquals("GCA-TGCU", alignedSequences.second)
    }

    /**
     * Tests the alignment of two DNA sequences using the Needleman-Wunsch algorithm.
     * Verifies that the algorithm aligns the sequences correctly.
     */
    @Test
    fun testAlignment3() {
        // Arrange
        val sequence1 = "AAAGAGA"
        val sequence2 = "GAGAGAG"

        // Act
        val result = needlemanWunsch(sequence1, sequence2)
        val alignedSequences = backtrace(result.tracebackMatrix, sequence1, sequence2)

        // Assert
        assertEquals("AAAGAGA-", alignedSequences.first)
        assertEquals("-GAGAGAG", alignedSequences.second)
    }

    /**
     * Tests the alignment of two DNA sequences using the Needleman-Wunsch algorithm.
     * Verifies that the algorithm aligns the sequences correctly.
     */
    @Test
    fun testAlignment4() {
        // Arrange
        val sequence1 = "ATCG"
        val sequence2 = "ATCG"

        // Act
        val result = needlemanWunsch(sequence1, sequence2)
        val alignedSequences = backtrace(result.tracebackMatrix, sequence1, sequence2)

        // Assert
        assertEquals("ATCG", alignedSequences.first)
        assertEquals("ATCG", alignedSequences.second)
    }

    /**
     * Tests the alignment of two DNA sequences using the Needleman-Wunsch algorithm.
     * Verifies that the algorithm aligns the sequences correctly.
     */
    @Test
    fun testAlignment5() {
        // Arrange
        val sequence1 = "ACG"
        val sequence2 = "ACGT"

        // Act
        val result = needlemanWunsch(sequence1, sequence2)
        val alignedSequences = backtrace(result.tracebackMatrix, sequence1, sequence2)

        // Assert
        assertEquals("ACG-", alignedSequences.first)
        assertEquals("ACGT", alignedSequences.second)
    }
}


