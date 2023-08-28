package com.example.datastrutures.library

import android.util.Log
import kotlin.math.log


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

    fun inorder() {
        InorderRec(root)
    }

    fun InorderRec(root: Node?) {
        if (root != null) {
            InorderRec(root.leftChild)
            var deneme = root.data
            Log.e("deneme","$deneme + ->")
            InorderRec(root.rightChild)
        }
    }

    fun DeleteData(data: Int) {
        root = DeleteRec(root, data)
    }

    fun DeleteRec(root: Node?, data: Int): Node? {
        if (root == null) {
            return root
        }
        if (data < root.data)
            root.leftChild = DeleteRec(root.leftChild, data)
        else if (data > root.data)
            root.rightChild = DeleteRec(root.rightChild, data)
        else {
            // If the node is with only one child or no child
            if (root.leftChild == null)
                return root.rightChild
            else if (root.rightChild == null)
                return root.leftChild

            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.data = minValue(root.rightChild);

            // Delete the inorder successor
            root.rightChild = DeleteRec(root.rightChild, root.data);
        }
        return root;
    }

    fun minValue(root: Node?): Int {
        var minv = root?.data
        var current = root
        while (current?.leftChild != null) {
            minv = current?.leftChild!!.data
            current = current?.leftChild
        }
        return minv!!
    }


    fun main() {


        Insert(8);
        Insert(3);
        Insert(1);
        Insert(6);
        Insert(7);
        Insert(10);
        Insert(14);
        Insert(4);

        Log.e("deneme","Inorder traversal: ");
        inorder();

        Log.e("deneme","\n\nAfter deleting 10");
        DeleteData(10);
        Log.e("deneme","Inorder traversal: ");
        inorder();
    }
}
