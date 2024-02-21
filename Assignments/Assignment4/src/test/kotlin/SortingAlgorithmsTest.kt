package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortingAlgorithmsTest {

    @Test
    fun testHeapSort() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(12, 11, 13, 5, 6, 7)
        sortingAlgorithms.heapSort(arr)
        assertArrayEquals(arrayOf(5, 6, 7, 11, 12, 13), arr)
    }

    @Test
    fun testRadixSort() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(170, 45, 75, 90, 802, 24, 2, 66)
        sortingAlgorithms.radixSort(arr)
        assertArrayEquals(arrayOf(2, 24, 45, 66, 75, 90, 170, 802), arr)
    }

    @Test
    fun testInsertionSort() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(12, 11, 13, 5, 6)
        sortingAlgorithms.insertionSort(arr)
        assertArrayEquals(arrayOf(5, 6, 11, 12, 13), arr)
    }

    @Test
    fun testSelectionSort() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(64, 25, 12, 22, 11)
        sortingAlgorithms.selectionSort(arr)
        assertArrayEquals(arrayOf(11, 12, 22, 25, 64), arr)
    }

    @Test
    fun testEmptyArrayHeap() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = emptyArray<Int>()
        sortingAlgorithms.heapSort(arr)
        assertArrayEquals(emptyArray<Int>(), arr)
    }
    @Test
    fun testEmptyArrayRadix() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = emptyArray<Int>()
        sortingAlgorithms.radixSort(arr)
        assertArrayEquals(emptyArray<Int>(), arr)
    }
    @Test
    fun testEmptyArrayInsertion() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = emptyArray<Int>()
        sortingAlgorithms.insertionSort(arr)
        assertArrayEquals(emptyArray<Int>(), arr)
    }
    @Test
    fun testEmptyArraySelection() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = emptyArray<Int>()
        sortingAlgorithms.selectionSort(arr)
        assertArrayEquals(emptyArray<Int>(), arr)
    }
    @Test
    fun testAlreadySortedArrayHeapSort() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(1, 2, 3, 4, 5)
        sortingAlgorithms.heapSort(arr)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), arr)
    }
    @Test
    fun testAlreadySortedArrayRadixSort() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(1, 2, 3, 4, 5)
        sortingAlgorithms.radixSort(arr)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), arr)
    }
    @Test
    fun testAlreadySortedArrayInsertionSort() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(1, 2, 3, 4, 5)
        sortingAlgorithms.insertionSort(arr)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), arr)
    }
    @Test
    fun testAlreadySortedArraySelectionSort() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(1, 2, 3, 4, 5)
        sortingAlgorithms.selectionSort(arr)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), arr)
    }
    @Test
    fun testReverseHeapArray() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(5, 4, 3, 2, 1)
        sortingAlgorithms.heapSort(arr)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), arr)
    }
    @Test
    fun testReverseRadixArray() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(5, 4, 3, 2, 1)
        sortingAlgorithms.radixSort(arr)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), arr)
    }
    @Test
    fun testReverseInsertionArray() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(5, 4, 3, 2, 1)
        sortingAlgorithms.insertionSort(arr)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), arr)
    }
    @Test
    fun testReverseSortedSelectionArray() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(5, 4, 3, 2, 1)
        sortingAlgorithms.selectionSort(arr)
        assertArrayEquals(arrayOf(1, 2, 3, 4, 5), arr)
    }

    @Test
    fun testDuplicateElementsHeapSort() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(3, 2, 2, 1, 4, 3, 1)
        sortingAlgorithms.heapSort(arr)
        assertArrayEquals(arrayOf(1, 1, 2, 2, 3, 3, 4), arr)
    }
    @Test
    fun testDuplicateElementsRadix() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(3, 2, 2, 1, 4, 3, 1)
        sortingAlgorithms.radixSort(arr)
        assertArrayEquals(arrayOf(1, 1, 2, 2, 3, 3, 4), arr)
    }
    @Test
    fun testDuplicateElementsInsertion() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(3, 2, 2, 1, 4, 3, 1)
        sortingAlgorithms.insertionSort(arr)
        assertArrayEquals(arrayOf(1, 1, 2, 2, 3, 3, 4), arr)
    }
    @Test
    fun testDuplicateElementsSelection() {
        val sortingAlgorithms = SortingAlgorithms()
        val arr = arrayOf(3, 2, 2, 1, 4, 3, 1)
        sortingAlgorithms.selectionSort(arr)
        assertArrayEquals(arrayOf(1, 1, 2, 2, 3, 3, 4), arr)
    }
}
