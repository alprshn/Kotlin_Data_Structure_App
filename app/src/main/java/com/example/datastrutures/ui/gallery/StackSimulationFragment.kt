package com.example.datastrutures.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.datastrutures.R
import com.example.datastrutures.databinding.FragmentStackSimulationBinding
import com.example.datastrutures.library.Stack

class StackSimulationFragment : Fragment() {
    private var _binding: FragmentStackSimulationBinding? = null


    private var popStorage = ArrayList<Any>()

    var stack = Stack<Any>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val galleryViewModel =
            ViewModelProvider(this).get(StackSimulatinViewModel::class.java)

        _binding = FragmentStackSimulationBinding.inflate(inflater, container, false)
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
            val stackItem = "Index $i" + binding.addStack.text.toString().trim()
            stack.push(stackItem)
            arrayAdapter.notifyDataSetChanged()
            binding.pushText.text = "Index $i" + binding.addStack.text.toString().trim()
            i = i + 1


            binding.addStack.text.clear()
        }

        binding.popStackButton.setOnClickListener {
            binding.popText.text = stack.peek().toString()
            stack.pop()
            arrayAdapter.notifyDataSetChanged()
        }

        binding.clearButton.setOnClickListener {
            arrayAdapter.clear()
            binding.addStack.text.clear()
            binding.popText.text = ""
            binding.pushText.text = ""

        }
        return root
    }
}