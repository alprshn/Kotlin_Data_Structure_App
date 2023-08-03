package com.example.datastrutures.library

class Stack<Element> {
    private var storage  = ArrayList<Any>()

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

    fun getStorage(): ArrayList<Any> {
        return storage
    }

    fun setStorage(storage:ArrayList<Any>){
        this.storage = storage
    }



}