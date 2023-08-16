package com.example.datastrutures.library


class Queues<T> {
    private val list = ArrayList<Any>()

    fun enqueue(element: Any) {
        list.add(0,element)
    }

    fun dequeue() {
        if (list.isEmpty()) {
            null
        } else {
            list.remove(list.getOrNull(list.size - 1))
        }
    }

    fun peek(): Any? {
        if (list.isEmpty()) {
            return null
        } else {
            return list[0]
        }
    }

    fun size(): Int = list.count()
    fun isEmpty(): Boolean = list.isEmpty()

    fun getQueuesStorage(): ArrayList<Any> {
        return list
    }
}