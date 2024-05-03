package org.example

class MyMutableIntList {
    /**
     * Add [element] to the end of the list
     *
     *         val listSize = myList.size
     *         for (i in listSize){
     *             if (myList[i] == null){
     *                 myList[i] = element
     *                 return myList
     *             }
     *             elseif
     *
     */

    private var array = intArrayOf()
    private var listSize = 0
//    private var full = false
    private var arraytemp = intArrayOf()

    fun add(element: Int){
//        if(listSize == array.size) {
//            full = true
//        }
        if (array.isEmpty()){
            arraytemp = IntArray(1)
        }
        else if (listSize == array.size) {
            arraytemp = IntArray(array.size*2)
        }
        for (i in 0..<listSize){
            arraytemp[i] = array[i]
        }
        array[listSize] = element
        listSize ++

    }
    fun clear(){
        listSize = 0
    }
    /*
     * @return the size of the list
     */
    fun size(): Int{
        return listSize
    }
    /**
     * @param index the index to return
     * @return the element at [index]
     */
    operator fun get(index: Int):Int{
        return  array[index]
    }
    /**
     * Store [value] at position [index]
     * @param index the index to set
     * @param value to store at [index]
     */
    operator fun set(index: Int, value: Int){
        array.set(index, value)
    }
}
