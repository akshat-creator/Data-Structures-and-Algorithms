package org.example.LinkedList

/**
 * Represents a node in a linked list.
 *
 * @param T The type of value stored in the node.
 * @property value The value stored in the node.
 * @property nextNode The reference to the next node in the linked list. Defaults to null if the node is the last node.
 */
data class Node<T>(var value: T, var nextNode: Node<T>? = null) {

    /**
     * Returns a string representation of the node and its subsequent nodes in the linked list.
     *
     * @return A string representation of the node and its subsequent nodes in the linked list.
     */
    override fun toString(): String {
        return if (nextNode != null) {
            "$value -> ${nextNode.toString()}"
        } else {
            "$value"
        }
    }
}
