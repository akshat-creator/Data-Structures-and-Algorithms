package org.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import RedBlack

class RedBlackTest {
    @Test
    fun testInsert() {
        val tree = RedBlack()
        tree.insert(10)
        tree.insert(5)
        tree.insert(15)
        tree.insert(3)
        tree.insert(7)
        tree.insert(12)
        tree.insert(17)

        assertTrue(tree.lookup(10))
        assertTrue(tree.lookup(5))
        assertTrue(tree.lookup(15))
        assertTrue(tree.lookup(3))
        assertTrue(tree.lookup(7))
        assertTrue(tree.lookup(12))
        assertFalse(tree.lookup(19))
    }

    class RedBlackTest {
        @Test
        fun testCheckInvariants() {
            val tree = RedBlack()
            tree.insert(10)
            tree.insert(5)
            tree.insert(15)
            tree.insert(3)
            tree.insert(7)
            tree.insert(12)
            tree.insert(17)

            assertTrue(tree.checkInvariants())
        }

        @Test
        fun testCheckInvariantsEmptyTree() {
            val tree = RedBlack()

            assertTrue(tree.checkInvariants()) // Empty tree should always satisfy Red-Black Tree invariants
        }

        @Test
        fun testCheckInvariantsSingleNode() {
            val tree = RedBlack()
            tree.insert(10)

            assertTrue(tree.checkInvariants()) // Single node tree should always satisfy Red-Black Tree invariants
        }

        @Test
        fun testCheckInvariantsInvalidRedParent() {
            val tree = RedBlack()
            tree.insert(10)
            tree.insert(5)
            tree.insert(15)
            tree.insert(3)
            tree.insert(7)
            tree.insert(12)
            tree.insert(17)

            // Change color of a red parent node to red, violating Red-Black Tree property
            tree.root!!.color = false

            assertFalse(tree.checkInvariants()) // Should return false because Red-Black Tree invariants are violated
        }

        @Test
        fun testCheckInvariantsBlackDepth() {
            val tree = RedBlack()
            tree.insert(10)
            tree.insert(5)
            tree.insert(15)
            tree.insert(3)
            tree.insert(7)
            tree.insert(12)
            tree.insert(17)

            // Increase black depth of one of the paths, violating Red-Black Tree property
            tree.root!!.left!!.left!!.color = true

            assertFalse(tree.checkInvariants()) // Should return false because Red-Black Tree invariants are violated
        }
    }

    @Test
    fun testLookup() {
        val tree = RedBlack()
        tree.insert(10)
        tree.insert(5)
        tree.insert(15)
        tree.insert(3)
        tree.insert(7)
        tree.insert(12)
        tree.insert(17)

        assertTrue(tree.lookup(10))
        assertFalse(tree.lookup(20))
        assertFalse(tree.lookup(0))
        assertFalse(tree.lookup(1))

    }
}
