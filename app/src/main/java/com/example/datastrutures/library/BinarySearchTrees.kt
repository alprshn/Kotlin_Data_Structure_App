package com.example.datastrutures.library

import android.provider.ContactsContract.Intents.Insert


class Node(item: Int) {     /* Node data structure for binary search tree */
    var data: Int = item
    var leftChild: Node? = null
    var rightChild: Node? = null

}

var root: Node? = null

class BinarySearchTrees {

    fun Insert(data: Int) {
        root = InsertData(root, data);
    }

    fun InsertData(root: Node?, data: Int): Node {
        if (root == null) {
            return Node(data)
        }
        if (data < root.data) {
            root.leftChild = InsertData(root.leftChild, data)
        } else if (data > root.data) {
            root.rightChild = InsertData(root.rightChild, data)
        }

        return root
    }
}