package com.example.datastrutures.ui.binary_search_trees

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BinarySearchTreesViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Binary Fragment"
    }
    val text: LiveData<String> = _text
}