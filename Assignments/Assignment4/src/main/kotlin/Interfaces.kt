package org.example

interface SortAlgorithm<T> {
    fun <T : Comparable<T>> sort(arr: Array<T>)
}
