package com.example.datastrutures.ui.stack

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.datastrutures.databinding.FragmentStackBinding
import com.example.datastrutures.library.Stack

class StackFragment : Fragment() {

    private var _binding: FragmentStackBinding? = null


    private var popStorage = ArrayList<Any>()

    var stack = Stack<Any>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val stackViewModel =
            ViewModelProvider(this).get(StackViewModel::class.java)

        _binding = FragmentStackBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.stackSimulateButton.setOnClickListener {
            val intent = Intent(activity, StackSimulateActivity::class.java)
            startActivity(intent)

        }
        val markdownText = """
        <center><h1>Stack Data Structures</h1><center><br>
        <p>The stack data structure is identical, in concept, to a physical stack of objects. When you add an item to a stack, you place it on top of the stack. When you remove an item from a stack, you always remove the top-most item.</p>
        <br>       
        <h3>Stack operations</h3><br>
        <p>Stacks are useful, and also exceedingly simple. The main goal of building a stack is to enforce how you access your data. If you had a tough time with the linked list concepts, you’ll be glad to know that stacks are comparatively trivial.</p>
        There are only two essential operations for a stack:<br>
        <li><strong>push:</strong> Adding an element to the top of the stack.</li><br>
        <li><strong>pop:</strong> Removing the top element of the stack.</li><br>
        <hr>
        <p>This means that you can only add or remove elements from one side of the data structure. In computer science, a stack is known as the LIFO (last-in first-out) data structure. Elements that are pushed in last are the first ones to be popped out.</p><br>
        """.trimIndent()

        val htmlText: Spanned = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            HtmlCompat.fromHtml(markdownText, HtmlCompat.FROM_HTML_MODE_COMPACT)
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(markdownText)
        }

        binding.stackTest.text = htmlText


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}