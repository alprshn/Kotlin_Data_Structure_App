package com.example.datastrutures.ui.binary_search_trees

import android.os.Bundle
import android.text.Layout
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AlignmentSpan
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.datastrutures.R

import com.example.datastrutures.databinding.FragmentBinarySearchTreesBinding
import com.google.android.material.navigation.NavigationView


class BinarySearchTreesFragment : Fragment() {

    private var _binding: FragmentBinarySearchTreesBinding? = null
    private lateinit var frameLayout: FrameLayout

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


       binding.addCircleButton.setOnClickListener{
           frameLayout = binding.frameLayout
           createNewCircle()
       }


        return root
    }

    fun createNewCircle(){
        val newFrameLayout = FrameLayout(requireContext())

        val layoutParams = FrameLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.frame_width),
            resources.getDimensionPixelSize(R.dimen.frame_height)
        )
        layoutParams.marginStart = resources.getDimensionPixelSize(R.dimen.margin_start)
        layoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.margin_top)
        layoutParams.marginEnd = resources.getDimensionPixelSize(R.dimen.margin_end)
        newFrameLayout.layoutParams = layoutParams
        newFrameLayout.setBackgroundResource(R.drawable.circle_background)

        val textView = TextView(requireContext())
        textView.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.CENTER
        }
        textView.text = "10"
        textView.textSize = 16f

        newFrameLayout.addView(textView)
        frameLayout.addView(newFrameLayout)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}