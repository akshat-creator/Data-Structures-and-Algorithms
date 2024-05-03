package org.example
import java.io.File
import AssociativeArray

fun main() {
    fun markov(targetWord: String) {

        val file = File("/home/akshat/Documents/Classes/DSA/Data-Structures-and-Algorithms/Assignments/Assigment7/src/main/kotlin/book")
        val text = file.readText()
        // Tokenize the text into words
        val words = text.split("\\s+".toRegex())
        // Remove punctuation from words
        val cleanWords: List<String> = words.map { it.replace(Regex("[^A-Za-z0-9]"), "") }
            .filter { it.isNotBlank() }
        // Print the clean word list
        cleanWords.forEach { println(it) }

        val map = AssociativeArray<String, Int>()

        for (i in 0..<cleanWords.size) {
            if (cleanWords[i] == targetWord) {
                val next = cleanWords[i + 1]
                val value = map[next]
                if (value == null) {
                    map[next] =  1
                }
                else {
                    map[next] =  value + 1
                }
            }
        }
        print(map.keyValuePairs())

    }


    markov("kill")
}

//fun main() {
//    val map = AssociativeArray<Int, String>()
//
//    // Insertion
//    map[1] = "One"
//    map[2] = "Two"
//    map[3] = "Three"
//    map[4] = "Four"
//    map[5] = "Five"
//    map[6] = "Six"
//    map[7] = "Seven"
//    map[8] = "Eight"
//    map[9] = "Nine"
//    map[10] = "Ten"
//    map[11] = "Eleven"
//    map[12] = "Twelve"
//    map[13] = "Thirteen"
//    map[14] = "Fourteen"
//    map[15] = "Fifteen"
//    map[16] = "Sixteen"
//
//    // Retrieval
//    println("Value for key 1: ${map[1]}") // One
//    println("Value for key 10: ${map[10]}") // Ten
//    println("Key-Value pairs: ${map.keyValuePairs()}") // [(1, One), (2, Two), ..., (16, Sixteen)]
//
//    // Removal
//    map.remove(5)
//    println("Size after removal: ${map.size()}") // 15
//
//    // Contains
//    println("Contains key 5: ${5 in map}") // false
//    println("Contains key 15: ${15 in map}") // true
//
//    map[1] = "One"
//
//    // Key-Value pairs
//    println("Key-Value pairs: ${map.keyValuePairs()}") // [(1, One), (2, Two), ..., (16, Sixteen)]
//}
