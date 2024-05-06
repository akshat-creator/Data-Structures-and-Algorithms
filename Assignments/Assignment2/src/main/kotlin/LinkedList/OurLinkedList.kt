package org.example.LinkedList

/**
 * Represents a
 * implementation of a singly linked list.
 *
 * @param T The type of elements stored in the linked list.
 * @property head The reference to the first node in the linked list.
 * @property tail The reference to the last node in the linked list.
 * @property size The number of elements in the linked list.
 */

class OurLinkedList<T>{

    private var head: Node<T>? =null
    private var tail: Node<T>? =null
    private var size: Int = 0

    /**
     * Checks if the linked list is empty.
     *
     * @return `true` if the linked list is empty, `false` otherwise.
     */

    fun isOurLinkedListEmpty() :Boolean{
        if(size == 0) {
            return true
        }else{
            return false
        }
    }

    /**
     * Returns a string representation of the linked list.
     *
     * @return A string representation of the linked list, indicating whether it is empty or showing its elements.
     */

    override fun toString(): String {
        return if(isOurLinkedListEmpty()){
            "Our Linked List is Empty"
        }else{
            head.toString()
        }
    }

    /**
     * Adds the element [data] to the front of the linked list.
     */
    fun pushFront(data:T){
        head = Node(data, nextNode = head)
        if(tail==null){
            tail = head
        }
        size+=1
    }
    /**
     * Adds the element [data] to the back of the linked list.
     */
    fun pushBack(data: T){

        if (isOurLinkedListEmpty()){
            pushFront(data)
            return
        }
        tail?.nextNode = Node(data)
        tail = tail?.nextNode
        size+=1
    }
    /**
     * Removes an element from the front of the list. If the list is empty, it is unchanged.
     * @return the value at the front of the list or nil if none exists
     */
    fun popFront(): T?{
        if (isOurLinkedListEmpty()) {
            return null
        }

        val result = head?.value
        head = head?.nextNode
        size += -1
        if (isOurLinkedListEmpty()) {
            tail = null
        }

        return result
    }
    /**
     * Removes an element from the back of the list. If the list is empty, it is unchanged.
     * @return the value at the back of the list or nil if none exists
     */
    fun popBack(): T?{
        if (isOurLinkedListEmpty()) {
            return null
        }
        if (head?.nextNode == null){
            return popFront()
        }
        size+=-1

        var prev = head
        var current = head
        var next = current?.nextNode
        while (next != null){
            prev = current
            current = next
            next = current.nextNode
        }
        prev?.nextNode = null
        tail = prev
        return current?.value

    }
    /**
     * @return the value at the front of the list or nil if none exists
     */
    fun peekFront(): T?{
        if (isOurLinkedListEmpty()) {
            return null
        }
        return head?.value
    }
    /**
     * @return the value at the back of the list or nil if none exists
     */
    fun peekBack(): T?{
        if (isOurLinkedListEmpty()) {
            return null
        }
        return tail?.value
    }

    /**
     * @return true if the list is empty and false otherwise
     */
    fun isEmpty(): Boolean{
        return isOurLinkedListEmpty()
    }

}