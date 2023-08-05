package com.example.datastrutures.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.datastrutures.R
import com.example.datastrutures.databinding.FragmentGalleryBinding
import com.example.datastrutures.library.Stack

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null


    private var popStorage  = ArrayList<Any>()

    var stack = Stack<Any>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root


        var i = 1

         //Added Stack Class
        var pushListView = binding.listStack
        var arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1, stack.getStorage()
        )

        pushListView.adapter = arrayAdapter

        binding.addStackButton.setOnClickListener {
            val stackItem = binding.addStack.text.toString().trim() + "Eleman $i"
            stack.push(stackItem)
            arrayAdapter.notifyDataSetChanged()
            i= i+1
            binding.addStack.text.clear()
        }


        var popListView = binding.listPopStack
        var popArrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1, popStorage
        )
        popListView.adapter = popArrayAdapter


        binding.popStackButton.setOnClickListener{
            popStorage.add(stack.peek().toString())
            stack.pop()
            popArrayAdapter.notifyDataSetChanged()
            arrayAdapter.notifyDataSetChanged()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}