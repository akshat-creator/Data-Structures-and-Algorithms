import kotlin.reflect.typeOf
fun main() {

    val palindromeChecker = palndromecheck()
    val result = palindromeChecker.is_palindrome("ihi")
    println(result)

}

class palndromecheck() {

    fun is_palindrome(palindrome: String): Boolean {
        /*
        Checks if a string is a palindrome or not
        Arg: Check if string is palindrome

        Return: true if a string is palindrome, false if it is not a palindrome
        */
         */
        var len = palindrome.length
        if (len<=1){
            return true
        }
        else{
            if(palindrome[0]==palindrome[len-1]){
                return is_palindrome(palindrome.substring(1,len-1))
            }
            else{
                return false
            }
        }
    }
}


