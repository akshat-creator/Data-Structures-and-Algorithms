package org.example.LinkedList

class OurStack <T>{

    private val storage = arrayListOf<T>()
    override fun toString() = buildString {
        storage.reversed().forEach(){
            appendLine("$it")
        }

    }
    /**
     * Add [data] to the top of the stack
     */
    fun push(data: T){
        storage.add(data)
    }
    /**
     * Remove the element at the top of the stack.  If the stack is empty, it remains unchanged.
     * @return the value at the top of the stack or nil if none exists
     */
    fun pop() : T?{
        return if(storage.size == 0){
            null
        }else {
            storage.removeAt(storage.size - 1)
        }
    }
    /**
     * @return the value on the top of the stack or nil if none exists
     */
    fun peek(): T?{
        return if(storage.size == 0) {
            null
        } else {
            storage[storage.size -1]
        }
    }
    /**
     * @return true if the stack is empty and false otherwise
     */
    fun isEmpty(): Boolean{
        return if(storage.size == 0) {
            true
        } else {
            false
        }
        }

}