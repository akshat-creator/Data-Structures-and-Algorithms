import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Unit tests for the AssociativeArray class.
 */
class AssociativeArrayTest {

    /**
     * Tests the set function of the AssociativeArray class.
     * Verifies that elements are correctly added to the associative array.
     */
    @Test
    fun testSet() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2
        map["key3"] = 3

        assertEquals(3, map.size())
        assertTrue("key1" in map)
        assertTrue("key2" in map)
        assertTrue("key3" in map)
    }

    /**
     * Tests the set function of the AssociativeArray class with overwriting.
     * Verifies that existing mappings are correctly replaced.
     */
    @Test
    fun testSetOverwrite() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key1"] = 2

        assertEquals(1, map.size())
        assertEquals(2, map["key1"])
    }

    /**
     * Tests the contains function of the AssociativeArray class.
     * Verifies that the function correctly determines if a key exists in the associative array.
     */
    @Test
    fun testContains() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2

        assertTrue("key1" in map)
        assertTrue("key2" in map)
        assertFalse("key3" in map)
    }

    /**
     * Tests the get function of the AssociativeArray class.
     * Verifies that the correct value is retrieved for a given key.
     */
    @Test
    fun testGet() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2

        assertEquals(1, map["key1"])
        assertEquals(2, map["key2"])
        assertNull(map["key3"])
    }

    /**
     * Tests the remove function of the AssociativeArray class.
     * Verifies that keys are correctly removed from the associative array.
     */
    @Test
    fun testRemove() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2

        assertTrue(map.remove("key1"))
        assertFalse(map.remove("key3"))
        assertNull(map["key1"])
        assertEquals(1, map.size())
    }

    /**
     * Tests the remove function of the AssociativeArray class with multiple removals.
     * Verifies that multiple keys are correctly removed.
     */
    @Test
    fun testRemoveMultiple() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2
        map["key3"] = 3

        assertTrue(map.remove("key1"))
        assertTrue(map.remove("key2"))
        assertTrue(map.remove("key3"))
        assertEquals(0, map.size())
    }

    /**
     * Tests the size function of the AssociativeArray class.
     * Verifies that the function correctly returns the size of the associative array.
     */
    @Test
    fun testSize() {
        val map = AssociativeArray<String, Int>()

        assertEquals(0, map.size())

        map["key1"] = 1
        map["key2"] = 2

        assertEquals(2, map.size())

        map.remove("key1")

        assertEquals(1, map.size())
    }

    /**
     * Tests the keyValuePairs function of the AssociativeArray class.
     * Verifies that the function correctly returns all key-value pairs in the associative array.
     */
    @Test
    fun testKeyValuePairs() {
        val map = AssociativeArray<String, Int>()

        map["key1"] = 1
        map["key2"] = 2

        val pairs = map.keyValuePairs()

        assertEquals(2, pairs.size)
        assertTrue(pairs.contains("key1" to 1))
        assertTrue(pairs.contains("key2" to 2))
    }

    /**
     * Tests the keyValuePairs function of the AssociativeArray class when the array is empty.
     * Verifies that an empty list is returned when the associative array is empty.
     */
    @Test
    fun testKeyValuePairsEmpty() {
        val map = AssociativeArray<String, Int>()

        val pairs = map.keyValuePairs()

        assertTrue(pairs.isEmpty())
    }
}
