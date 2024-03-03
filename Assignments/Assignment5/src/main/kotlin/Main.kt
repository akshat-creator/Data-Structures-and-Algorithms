package org.example


fun main() {
    // Create two square matrices
    val matrix1 = SquareMatrix(3)
    val matrix2 = SquareMatrix(3)

    // Set values for matrix1
    matrix1.setValue(0, 0, 1)
    matrix1.setValue(0, 1, 2)
    matrix1.setValue(0, 2, 3)
    matrix1.setValue(1, 0, 4)
    matrix1.setValue(1, 1, 5)
    matrix1.setValue(1, 2, 6)
    matrix1.setValue(2, 0, 7)
    matrix1.setValue(2, 1, 8)
    matrix1.setValue(2, 2, 9)

    // Set values for matrix2
    matrix2.setValue(0, 0, 9)
    matrix2.setValue(0, 1, 8)
    matrix2.setValue(0, 2, 7)
    matrix2.setValue(1, 0, 6)
    matrix2.setValue(1, 1, 5)
    matrix2.setValue(1, 2, 4)
    matrix2.setValue(2, 0, 3)
    matrix2.setValue(2, 1, 2)
    matrix2.setValue(2, 2, 1)

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
}


//fun main() {
//    val matrixSize = 3
//    val matrix = SquareMatrix(matrixSize)
//
//    // Setting values
//    for (i in 0 until matrixSize) {
//        for (j in 0 until matrixSize) {
//            matrix.setValue(i, j, i + j)
//        }
//    }
//
//    // Getting and printing values
//    println("Matrix:")
//    for (i in 0 until matrixSize) {
//        for (j in 0 until matrixSize) {
//            print("${matrix.getValue(i, j)} ")
//        }
//        println()
//    }
//}