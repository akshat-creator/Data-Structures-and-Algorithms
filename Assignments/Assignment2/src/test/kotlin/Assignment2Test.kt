import org.example.LinkedList.OurLinkedList
import org.example.LinkedList.OurStack
import org.example.LinkedList.OurQueue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Unit tests for the custom implementations of linked lists, stacks, and queues.
 */
class Assignment2Test {

    // Tests for linked lists
    /**
     * Test case to verify the behavior of an empty linked list.
     */
    @Test
    fun testEmptyLinkedList() {
        val ourLinkedList = OurLinkedList<Int>()

        assertTrue(ourLinkedList.isEmpty())
        assertNull(ourLinkedList.peekFront())
        assertNull(ourLinkedList.peekBack())
        assertNull(ourLinkedList.popFront())
        assertNull(ourLinkedList.popBack())
    }

    /**
     * Test case to verify the behavior of pushing elements to the front of a linked list.
     */
    @Test
    fun testPushFront() {
        val ourlinkedList = OurLinkedList<Int>()

        ourlinkedList.pushFront(1)
        ourlinkedList.pushFront(2)
        ourlinkedList.pushFront(3)

        assertEquals("3", ourlinkedList.peekFront().toString())
        assertEquals("1", ourlinkedList.peekBack().toString())
    }

    /**
     * Test case to verify the behavior of pushing elements to the back of a linked list.
     */
    @Test
    fun testPushBack() {
        val ourLinkedList = OurLinkedList<String>()

        ourLinkedList.pushBack("apple")
        ourLinkedList.pushBack("banana")
        ourLinkedList.pushBack("orange")

        assertEquals("apple", ourLinkedList.peekFront())
        assertEquals("orange", ourLinkedList.peekBack())
    }

    /**
     * Test case to verify the behavior of popping elements from the front of a linked list.
     */
    @Test
    fun testPopFront() {
        val ourLinkedList = OurLinkedList<Double>()

        ourLinkedList.pushFront(1.0)
        ourLinkedList.pushFront(2.0)
        ourLinkedList.pushFront(3.0)

        assertEquals(3.0, ourLinkedList.popFront())
        assertEquals(2.0, ourLinkedList.popFront())
        assertEquals(1.0, ourLinkedList.popFront())

        assertTrue(ourLinkedList.isEmpty())
        assertNull(ourLinkedList.peekFront())
        assertNull(ourLinkedList.peekBack())
    }

    /**
     * Test case to verify the behavior of popping elements from the back of a linked list.
     */
    @Test
    fun testPopBack() {
        val ourLinkedList = OurLinkedList<Char>()

        ourLinkedList.pushBack('a')
        ourLinkedList.pushBack('b')
        ourLinkedList.pushBack('c')

        assertEquals('c', ourLinkedList.popBack())
        assertEquals('b', ourLinkedList.popBack())
        assertEquals('a', ourLinkedList.popBack())

        assertTrue(ourLinkedList.isEmpty())
        assertNull(ourLinkedList.peekFront())
        assertNull(ourLinkedList.peekBack())
    }

    // Test for Stacks -----------------------------------
    /**
     * Test case to verify the behavior of an empty stack.
     */
    @Test
    fun testEmptyStack() {
        val stack = OurStack<Int>()

        assertTrue(stack.isEmpty())
        assertNull(stack.pop())
        assertNull(stack.peek())
    }

    /**
     * Test case to verify the behavior of pushing elements onto a stack.
     */
    @Test
    fun testPush() {
        val stack = OurStack<String>()

        stack.push("apple")
        stack.push("banana")
        stack.push("orange")

        assertFalse(stack.isEmpty())
        assertEquals("orange", stack.peek())
    }

    /**
     * Test case to verify the behavior of popping elements from a stack.
     */
    @Test
    fun testPop() {
        val stack = OurStack<Double>()

        stack.push(1.0)
        stack.push(2.0)
        stack.push(3.0)

        assertEquals(3.0, stack.pop())
        assertEquals(2.0, stack.pop())
        assertEquals(1.0, stack.pop())

        assertTrue(stack.isEmpty())
        assertNull(stack.peek())
        assertEquals("", stack.toString())
    }

    /**
     * Test case to verify the behavior of peeking at the top element of a stack.
     */
    @Test
    fun testPeekQueue() {
        val stack = OurStack<Char>()

        stack.push('a')
        stack.push('b')
        stack.push('c')

        assertEquals('c', stack.peek())
        stack.pop()
        assertEquals('b', stack.peek())
    }

    // Test for Queues -------------------------------------

    /**
     * Test case to verify the behavior of an empty queue.
     */
    @Test
    fun testEmptyQueue() {
        val queue = OurQueue<Int>()

        assertTrue(queue.isEmpty())
        assertNull(queue.dequeue())
        assertNull(queue.peek())
        assertEquals(0, queue.count)
    }

    /**
     * Test case to verify the behavior of enqueueing elements into a queue.
     */
    @Test
    fun testEnqueue() {
        val queue = OurQueue<String>()

        assertTrue(queue.enqueue("apple"))
        assertTrue(queue.enqueue("banana"))
        assertTrue(queue.enqueue("orange"))

        assertTrue(queue.isEmpty())
        assertEquals(0, queue.count)
        assertEquals("apple", queue.peek())
    }

    /**
     * Test case to verify the behavior of dequeueing elements from a queue.
     */
    @Test
    fun testDequeue() {
        val queue = OurQueue<Double>()

        queue.enqueue(1.0)
        queue.enqueue(2.0)
        queue.enqueue(3.0)

        assertEquals(null, queue.dequeue())
        assertEquals(null, queue.dequeue())
        assertEquals(null, queue.dequeue())

        assertTrue(queue.isEmpty())

    }
}