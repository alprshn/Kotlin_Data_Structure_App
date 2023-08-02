package com.example.datastrutures.library

class Stack<Element> {
    private val storage  = arrayListOf<Any>()
    fun pop(): Any? {
        if(storage.size == 0){
            return null
        }
        return  storage.removeAt(storage.size-1)
    }

    fun push(e: Any) {
        storage.add(e)
    }

    fun peek(): Any? {
        return storage.lastOrNull()
    }


}