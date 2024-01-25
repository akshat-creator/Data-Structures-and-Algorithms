import kotlin.reflect.typeOf
fun main() {

    val palindromeChecker = palndromecheck()
    val result = palindromeChecker.is_palindrome("ihi")
    println(result)

}

class palndromecheck() {

    fun is_palindrome(palindrome: String): Boolean {
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




/*
def is_palindrome(string):
    """
    Checks if a string is a palindrome or not
    Arg: Check if string is palindrome

    Return: True if a string is palindromem, False if it is not a palindrome
    """
    if len(string) <= 1:
        return True
    else:
        if string[0] == string[len(string) - 1]:
            return is_palindrome(string[1 : len(string) - 1])
        else:
            return False
 */