package org.example

import RedBlack

fun main() {
    val tree =  ()
    tree.insert(10)
    println("Red-Black Tree invariants maintained: ${tree.checkInvariants()}") // true
    tree.insert(5)
    tree.insert(15)
    tree.insert(3)
    tree.insert(7)
    tree.insert(12)
    tree.insert(17)
    tree.printTree()

    println("Lookup 10: ${tree.lookup(10)}") // true
    println("Lookup 20: ${tree.lookup(20)}") // false

    println("Red-Black Tree invariants maintained: ${tree.checkInvariants()}") // true
}
