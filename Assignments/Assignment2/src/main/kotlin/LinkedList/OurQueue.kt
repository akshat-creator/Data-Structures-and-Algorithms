package org.example.LinkedList

class OurQueue<T>: Queue<T> {

    private val storage = arrayListOf<T>()

    override val count = storage.size

    override val isEmptyQueue: Boolean
        get() = count == 0

    /**
     * Add [data] to the end of the queue.
     */
    override fun enqueue(element: T): Boolean {
        return  storage.add(element)
    }

    /**
     * Remove the element at the front of the queue.  If the queue is empty, it remains unchanged.
     * @return the value at the front of the queue or nil if none exists
     */
    override fun dequeue(): T? {
        return if (isEmptyQueue) null else storage.removeAt(0)
    }
    /**
     * @return the value at the front of the queue or nil if none exists
     */
    override fun peek(): T? {
        return storage.getOrNull(0)
    }
    /**
     * @return true if the queue is empty and false otherwise
     */
    override fun isEmpty(): Boolean{
        return isEmptyQueue
    }



}
