package org.example

class SortingAlgorithms {

    fun <T : Comparable<T>> heapSort(arr: Array<T>) {
        // Build max heap
        for (i in (arr.size / 2 - 1) downTo 0) {
            heapify(arr, arr.size, i)
        }

        // Extract elements from heap one by one
        for (i in arr.size - 1 downTo 1) {
            val temp = arr[0]
            arr[0] = arr[i]
            arr[i] = temp

            heapify(arr, i, 0)
        }
    }

    private fun <T : Comparable<T>> heapify(arr: Array<T>, n: Int, i: Int) {
        var largest = i // Initialize largest as root
        val left = 2 * i + 1
        val right = 2 * i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right

        // If largest is not root
        if (largest != i) {
            val swap = arr[i]
            arr[i] = arr[largest]
            arr[largest] = swap

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest)
        }
    }

    fun radixSort(arr: Array<Int>) {
        val max = arr.maxOrNull() ?: return // Get the maximum number in the array
        var exp = 1 // Initialize the exponent

        // Iterate through each digit position
        while (max / exp > 0) {
            countSort(arr, exp)
            exp *= 10 // Move to the next digit position
        }
    }

    private fun countSort(arr: Array<Int>, exp: Int) {
        val n = arr.size
        val output = Array(n) { 0 }
        val count = Array(10) { 0 }

        // Store count of occurrences in count[]
        for (i in arr.indices) {
            count[(arr[i] / exp) % 10]++
        }

        // Change count[i] so that count[i] now contains actual
        // position of this digit in output[]
        for (i in 1 until 10) {
            count[i] += count[i - 1]
        }

        // Build the output array
        for (i in n - 1 downTo 0) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]
            count[(arr[i] / exp) % 10]--
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i in arr.indices) {
            arr[i] = output[i]
        }
    }
    fun <T : Comparable<T>> insertionSort(arr: Array<T>) {
        for (i in 1 until arr.size) {
            val key = arr[i]
            var j = i - 1

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j -= 1
            }
            arr[j + 1] = key
        }
    }
    fun <T : Comparable<T>> selectionSort(arr: Array<T>) {
        for (i in arr.indices) {
            var minIndex = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            val temp = arr[i]
            arr[i] = arr[minIndex]
            arr[minIndex] = temp
            println(arr.joinToString())
        }
    }

}
