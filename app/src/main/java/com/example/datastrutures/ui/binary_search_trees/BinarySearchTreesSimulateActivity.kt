package com.example.datastrutures.ui.binary_search_trees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import com.example.datastrutures.R
import com.example.datastrutures.databinding.ActivityBinarySearchTreesBinding
import com.example.datastrutures.databinding.ActivityQueuesSimulateBinding
import com.example.datastrutures.databinding.ActivityStackSimulateBinding

class BinarySearchTreesSimulateActivity : AppCompatActivity() {
    private lateinit var frameLayout: FrameLayout
    private lateinit var binding: ActivityBinarySearchTreesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBinarySearchTreesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        binding.addCircleButton.setOnClickListener {
            frameLayout = binding.frameLayout
            createNewCircle()
        }
    }

    fun createNewCircle() {
        val newFrameLayout = FrameLayout(this)

        val layoutParams = FrameLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.frame_width),
            resources.getDimensionPixelSize(R.dimen.frame_height)
        )
        layoutParams.marginStart = resources.getDimensionPixelSize(R.dimen.margin_start)
        layoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.margin_top)
        layoutParams.marginEnd = resources.getDimensionPixelSize(R.dimen.margin_end)
        newFrameLayout.layoutParams = layoutParams
        newFrameLayout.setBackgroundResource(R.drawable.circle_background)

        val textView = TextView(this)
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
}