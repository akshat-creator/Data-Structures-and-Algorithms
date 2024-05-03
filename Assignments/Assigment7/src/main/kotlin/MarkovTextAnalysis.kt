import java.io.File

/**
 * Represents a class for performing Markov text analysis.
 */
class MarkovTextAnalysis {

    /**
     * Performs Markov text analysis based on a target word.
     *
     * @param targetWord The target word for which Markov analysis will be performed.
     */
    fun markov(targetWord: String) {

        // Read the text from the file
        val file = File("/home/akshat/Documents/Classes/DSA/Data-Structures-and-Algorithms/Assignments/Assigment7/src/main/kotlin/book")
        val text = file.readText()

        // Tokenize the text into words
        val words = text.split("\\s+".toRegex())

        // Remove punctuation from words and filter out blank words
        val cleanWords: List<String> = words.map { it.replace(Regex("[^A-Za-z0-9]"), "") }
            .filter { it.isNotBlank() }

        // Print the clean word list
        cleanWords.forEach { println(it) }

        // Initialize an associative array to store word frequencies
        val map = AssociativeArray<String, Int>()

        // Iterate over the words to build the word frequency map
        for (i in 0 until cleanWords.size) {
            if (cleanWords[i] == targetWord) {
                val next = cleanWords[i + 1]
                val value = map[next]
                if (value == null) {
                    map[next] =  1
                } else {
                    map[next] =  value + 1
                }
            }
        }

        // Print the key-value pairs of the word frequency map
        print(map.keyValuePairs())

    }
}
