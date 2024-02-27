package org.example

import kotlin.system.measureTimeMillis

fun main() {
    val sortingAlgorithms = SortingAlgorithms()
    val listSizes = listOf(100, 500, 1000, 5000, 10000) // List sizes to test

    val results = mutableMapOf<Int, MutableMap<String, Long>>()

    for (size in listSizes) {
        val randomList = generateRandomList(size)
        val heapSortTime = measureTimeMillis {
            sortingAlgorithms.heapSort(randomList.clone())
        }
        val radixSortTime = measureTimeMillis {
            sortingAlgorithms.radixSort(randomList.clone() as Array<Int>)
        }
        val insertionSortTime = measureTimeMillis {
            sortingAlgorithms.insertionSort(randomList.clone())
        }
        val selectionSortTime = measureTimeMillis {
            sortingAlgorithms.selectionSort(randomList.clone())
        }

        results[size] = mutableMapOf(
            "Heap Sort" to heapSortTime,
            "Radix Sort" to radixSortTime,
            "Insertion Sort" to insertionSortTime,
            "Selection Sort" to selectionSortTime
        )
    }


    // Print results
    println("List Size\tHeap Sort\tRadix Sort\tInsertion Sort\tSelection Sort")
    for ((size, times) in results) {
        print("$size\t\t")
        for (time in times.values) {
            print("$time\t\t\t\t")
        }
        println()
    }
}

fun generateRandomList(size: Int): Array<Int> {
    return Array(size) { (0..size).random() }
}

