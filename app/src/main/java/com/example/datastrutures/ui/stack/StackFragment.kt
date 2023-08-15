package com.example.datastrutures.ui.stack

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.datastrutures.databinding.FragmentStackBinding
import com.example.datastrutures.library.Stack

class StackFragment : Fragment() {

    private var _binding: FragmentStackBinding? = null


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
        val stackViewModel =
            ViewModelProvider(this).get(StackViewModel::class.java)

        _binding = FragmentStackBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.stackSimulateButton.setOnClickListener {
            val intent = Intent(activity, StackSimulateActivity::class.java)
            startActivity(intent)

        }
        val markdownText = """
           # Kotlin_Note_App V1

<h2>Documentation Dokka</h2>
Documentation rules for Kotlin in this link https://kotlinlang.org/docs/kotlin-doc.html
<h3>Setup Dokka</h3>

This will be written in build.gradle(Module:app).
```
plugins {
    id("org.jetbrains.dokka") version "1.8.20"
}
```

and to start it in terminal.
```
 ./gradlew dokkaHtml  
```


        """.trimIndent()

        val htmlText = Html.fromHtml(markdownText, Html.FROM_HTML_MODE_COMPACT)
        binding.stackTest.text = htmlText


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}