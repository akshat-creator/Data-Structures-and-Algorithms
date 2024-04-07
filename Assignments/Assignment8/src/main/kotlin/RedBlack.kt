/**
 * Red-Black Tree implementation.
 *
 * Red-Black Tree is a balanced binary search tree where each node has an extra bit for denoting the color (red or black).
 * The properties of a Red-Black Tree are:
 * 1. Every node is either red or black.
 * 2. The root is always black.
 * 3. Red nodes cannot have red children (no two red nodes can be adjacent).
 * 4. Every path from a node to its descendant null nodes (leaves) must have the same number of black nodes.
 *
 * @property root The root node of the Red-Black Tree.
 */

class RedBlack {
    companion object {
        private const val RED = false
        private const val BLACK = true
    }

    /**
     * Node class representing a node in the Red-Black Tree.
     *
     * @property key The value/key stored in the node.
     * @property color The color of the node (true for black, false for red).
     * @property left The left child of the node.
     * @property right The right child of the node.
     * @property parent The parent node of the node.
     */

    data class Node(var key: Int, var color: Boolean = BLACK, var left: Node? = null, var right: Node? = null, var parent: Node? = null)

    /** The root node of the Red-Black Tree. */
    var root: Node? = null

    /**
     * Inserts a key into the Red-Black Tree while maintaining the Red-Black Tree properties.
     *
     * @param key The key to be inserted.
     */
    fun insert(key: Int) {
        val newNode = Node(key)
        var parent: Node? = null
        var current = root

        while (current != null) {
            parent = current
            if (key < current.key) {
                current = current.left
            } else {
                current = current.right
            }
        }

        newNode.parent = parent

        if (parent == null) {
            root = newNode
        } else if (key < parent.key) {
            parent.left = newNode
        } else {
            parent.right = newNode
        }

        fixTreeAfterInsertion(newNode)
    }

    private fun fixTreeAfterInsertion(node: Node) {
        var newNode = node
        while (newNode != null && newNode != root && newNode.parent?.color == RED) {
            if (newNode.parent == newNode.parent!!.parent?.left) {
                val uncle = newNode.parent!!.parent?.right
                if (uncle?.color == RED) {
                    newNode.parent!!.color = BLACK
                    uncle.color = BLACK
                    newNode.parent!!.parent!!.color = RED
                    newNode = newNode.parent!!.parent!!
                } else {
                    if (newNode == newNode.parent!!.right) {
                        newNode = newNode.parent!!
                        rotateLeft(newNode)
                    }
                    newNode.parent!!.color = BLACK
                    newNode.parent!!.parent!!.color = RED
                    rotateRight(newNode.parent!!.parent!!)
                }
            } else {
                val uncle = newNode.parent!!.parent?.left
                if (uncle?.color == RED) {
                    newNode.parent!!.color = BLACK
                    uncle.color = BLACK
                    newNode.parent!!.parent!!.color = RED
                    newNode = newNode.parent!!.parent!!
                } else {
                    if (newNode == newNode.parent!!.left) {
                        newNode = newNode.parent!!
                        rotateRight(newNode)
                    }
                    newNode.parent!!.color = BLACK
                    newNode.parent!!.parent!!.color = RED
                    rotateLeft(newNode.parent!!.parent!!)
                }
            }
        }
        root!!.color = BLACK
    }

    private fun rotateLeft(node: Node) {
        val temp = node.right ?: return // Ensure the nullable receiver is handled safely
        node.right = temp.left
        temp.left?.parent = node // Safe access to nullable receiver
        temp.parent = node.parent
        if (node.parent == null) {
            root = temp
        } else if (node == node.parent!!.left) {
            node.parent!!.left = temp
        } else {
            node.parent!!.right = temp
        }
        temp.left = node
        node.parent = temp
    }

    private fun rotateRight(node: Node) {
        val temp = node.left ?: return // Ensure the nullable receiver is handled safely
        node.left = temp.right
        temp.right?.parent = node // Safe access to nullable receiver
        temp.parent = node.parent
        if (node.parent == null) {
            root = temp
        } else if (node == node.parent!!.right) {
            node.parent!!.right = temp
        } else {
            node.parent!!.left = temp
        }
        temp.right = node
        node.parent = temp
    }

    /**
     * Performs a lookup operation to determine if a key exists in the Red-Black Tree.
     *
     * @param key The key to lookup.
     * @return true if the key exists in the Red-Black Tree, false otherwise.
     */
    fun lookup(key: Int): Boolean {
        var current = root
        while (current != null) {
            when {
                key == current.key -> return true
                key < current.key -> current = current.left
                else -> current = current.right
            }
        }
        return false
    }

    /**
     * Performs a lookup operation to determine if a key exists in the Red-Black Tree.
     *
     * @param key The key to lookup.
     * @return true if the key exists in the Red-Black Tree, false otherwise.
     */    fun checkInvariants(): Boolean {
        return checkRedBlackProperty(root) && checkBinarySearchTreeProperty(root)
    }

    private fun checkRedBlackProperty(node: Node?): Boolean {
        if (node == null) return true

        if (node.color == RED && (node.left?.color == RED || node.right?.color == RED)) {
            return false
        }

        return checkRedBlackProperty(node.left) && checkRedBlackProperty(node.right)
    }

    private fun checkBinarySearchTreeProperty(node: Node?): Boolean {
        if (node == null) return true

        if ((node.left != null && node.left!!.key >= node.key) || (node.right != null && node.right!!.key <= node.key)) {
            return false
        }

        return checkBinarySearchTreeProperty(node.left) && checkBinarySearchTreeProperty(node.right)
    }


    /**
     * Prints the Red-Black Tree in a readable format.
     */
    fun printTree() {
        println("Red-Black Tree:")
        printTree(root, 0)
    }

    private fun printTree(node: Node?, level: Int) {
        if (node == null) return

        printTree(node.right, level + 1)
        println("\t".repeat(level) + "${if (node.color == RED) "R" else "B"} ${node.key}")
        printTree(node.left, level + 1)
    }
}
