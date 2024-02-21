package org.example

fun main() {
    // Test Heap Sort
    val heapSort = SortingAlgorithms()
    val arrHeap = arrayOf(4, 10, 3, 5, 1)
    println("Original Array (Heap Sort): ${arrHeap.joinToString()}")
    heapSort.heapSort(arrHeap)
    println("Sorted Array (Heap Sort): ${arrHeap.joinToString()}")

    // Test Radix Sort
    val radixSort = SortingAlgorithms()
    val arrRadix = arrayOf(53,89,150,36,633,233)
    println("Original Array (Radix Sort): ${arrRadix.joinToString()}")
    radixSort.radixSort(arrRadix)
    println("Sorted Array (Radix Sort): ${arrRadix.joinToString()}")

    // Test Insertion Sort

    val arrInsertion = arrayOf(12, 11, 13, 5, 6)
    val insertionSort = SortingAlgorithms()

    println("Original Array (Insertion Sort): ${arrInsertion.joinToString()}")
    insertionSort.insertionSort(arrInsertion)
    println("Sorted Array (Insertion Sort): ${arrInsertion.joinToString()}")

    // Test Selection Sort

    val arrSelectionSort = arrayOf(64, 25, 12, 22, 11)
    val selectionSort = SortingAlgorithms()

    println("Original Array (Selection Sort): ${arrSelectionSort.joinToString()}")
    selectionSort.selectionSort(arrSelectionSort)
    println("Sorted Array (Selection Sort): ${arrSelectionSort.joinToString()}")

}
