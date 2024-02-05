package org.example

import org.example.LinkedList.OurLinkedList
import org.example.LinkedList.OurStack

fun main() {
    val ourLinkedList = OurLinkedList<Int>()

    ourLinkedList.pushBack(10)
    ourLinkedList.pushBack(20)
    ourLinkedList.pushBack(30)
    ourLinkedList.peekFront()


    val stack = OurStack<Int>()
    stack.push(10)
    stack.push(20)
    stack.push(30)
    println(stack)
    val removedElement = stack.pop()
    println("Removed Element is $removedElement")
    println(stack)



}