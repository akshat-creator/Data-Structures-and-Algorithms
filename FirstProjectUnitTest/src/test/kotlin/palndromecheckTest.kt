import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class palndromecheckTest {

    private val testpalindrome: palndromecheck = palndromecheck()

    @Test
    fun Testpalindrome() {
        val expected: Boolean = true
        assertEquals(expected, testpalindrome.is_palindrome("ihi"))
        assertEquals(expected, testpalindrome.is_palindrome("malayalam"))

    }
}
