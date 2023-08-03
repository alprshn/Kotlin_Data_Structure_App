package com.example.datastrutures.library

class Stack<Element> {
    private var storage  = ArrayList<Any>()

    fun pop(): Any? {
        if(storage.size == 0){
            return null
        }
        return  storage.removeAt(0)
    }

    fun push(e: Any) {
        storage.add(0,e)
    }

    fun peek(): Any? {
        return storage.firstOrNull()
    }

    fun getStorage(): ArrayList<Any> {
        return storage
    }

    fun setStorage(storage:ArrayList<Any>){
        this.storage = storage
    }
    fun getReversedStorage(): ArrayList<Any> {
        return storage.reversed() as ArrayList<Any>
    }


}