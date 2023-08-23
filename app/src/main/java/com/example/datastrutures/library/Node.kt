package com.example.datastrutures.library

class Nodes {     /* Node data structure for binary search tree */
    var data: Int = 0
    var leftChild: Node? = null
    var rightChild: Node? = null

    fun Node(item: Int) {
        data = item
        leftChild = null
        rightChild = null
    }
}