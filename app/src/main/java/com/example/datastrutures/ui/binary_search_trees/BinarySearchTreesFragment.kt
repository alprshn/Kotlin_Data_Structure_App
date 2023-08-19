package com.example.datastrutures.ui.binary_search_trees

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

import com.example.datastrutures.databinding.FragmentBinarySearchTreesBinding


class BinarySearchTreesFragment : Fragment() {

    private var _binding: FragmentBinarySearchTreesBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binaryTreesViewModel =
            ViewModelProvider(this).get(BinarySearchTreesViewModel::class.java)

        _binding = FragmentBinarySearchTreesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBinaryTrees
        binaryTreesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}