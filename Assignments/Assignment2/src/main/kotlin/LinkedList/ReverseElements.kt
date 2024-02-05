package org.example.LinkedList

/**
 * Reverse the elements in the stack
 */
class ReverseElements<T> {

    val original = OurStack<Int>()
    val temp = OurStack<Int>()

    // Pop each element from the original stack and push it onto the temporary stack
    fun reverse() {
        while (!original.isEmpty()) {
            temp.push(original.pop()!!)
        }
        // Pop each element from the temporary stack and push it back onto the original stack
        while (!temp.isEmpty()) {
            original.push(temp.pop()!!)
        }
    }
}