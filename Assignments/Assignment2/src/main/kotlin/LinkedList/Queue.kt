package org.example.LinkedList

interface Queue<T>{

    val count: Int
    val isEmptyQueue: Boolean

    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    fun peek(): T?
    fun isEmpty(): Boolean
}