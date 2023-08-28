package com.example.datastrutures.ui.binary_search_trees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.marginStart
import com.example.datastrutures.R
import com.example.datastrutures.databinding.ActivityBinarySearchTreesBinding
import com.example.datastrutures.databinding.ActivityQueuesSimulateBinding
import com.example.datastrutures.databinding.ActivityStackSimulateBinding
import com.example.datastrutures.library.BinarySearchTrees

class BinarySearchTreesSimulateActivity : AppCompatActivity() {
    private lateinit var frameLayout: FrameLayout
    private lateinit var binding: ActivityBinarySearchTreesBinding
    var trees: BinarySearchTrees = BinarySearchTrees()
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

    var marginStartCount = 0
    var marginTopCount = 0
    var marginEndCount = 0


    fun createNewCircle() {
        val newFrameLayout = FrameLayout(this)
        var deneme = binding.addTreeData.text.toString().toInt()
        val layoutParams = FrameLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.frame_width),
            resources.getDimensionPixelSize(R.dimen.frame_height)
        )
        trees.directionSelector
        if (trees.directionSelector == false) {

            layoutParams.marginStart =
                resources.getDimensionPixelSize(R.dimen.margin_start) - marginStartCount
            layoutParams.topMargin =
                resources.getDimensionPixelSize(R.dimen.margin_top) + marginTopCount
            layoutParams.marginEnd = resources.getDimensionPixelSize(R.dimen.margin_end)
            LeftArrow()
        } else {
            layoutParams.marginStart =
                resources.getDimensionPixelSize(R.dimen.margin_start) + marginStartCount
            layoutParams.topMargin =
                resources.getDimensionPixelSize(R.dimen.margin_top) + marginTopCount
            layoutParams.marginEnd = resources.getDimensionPixelSize(R.dimen.margin_end)
            RigtArrow()
        }
        marginStartCount = marginStartCount + 50
        marginTopCount = marginTopCount + 150
        newFrameLayout.layoutParams = layoutParams
        newFrameLayout.setBackgroundResource(R.drawable.circle_background)

        val textView = TextView(this)
        textView.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.CENTER
        }
        textView.text = binding.addTreeData.text.toString()
        textView.textSize = 16f

        newFrameLayout.addView(textView)
        frameLayout.addView(newFrameLayout)

    }

    fun LeftArrow() {
        val leftArrow = TextView(this)
        leftArrow.setBackgroundResource(R.drawable.trees_arrow_left)
        val layoutLeftArrow = FrameLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.frame_width),
            resources.getDimensionPixelSize(R.dimen.frame_height)
        )
        layoutLeftArrow.marginStart = resources.getDimensionPixelSize(R.dimen.margin_start) + 50
        layoutLeftArrow.topMargin = resources.getDimensionPixelSize(R.dimen.margin_top) + 100
        layoutLeftArrow.marginEnd = resources.getDimensionPixelSize(R.dimen.margin_end)
        leftArrow.rotation = 225f
        leftArrow.layoutParams = layoutLeftArrow
        frameLayout.addView(leftArrow)
    }

    fun RigtArrow() {
        val rightArrow = TextView(this)
        rightArrow.setBackgroundResource(R.drawable.trees_arrow_left)
        val layoutLeftArrow = FrameLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.frame_width),
            resources.getDimensionPixelSize(R.dimen.frame_height)
        )
        layoutLeftArrow.marginStart = resources.getDimensionPixelSize(R.dimen.margin_start) - 50
        layoutLeftArrow.topMargin = resources.getDimensionPixelSize(R.dimen.margin_top) + 100
        layoutLeftArrow.marginEnd = resources.getDimensionPixelSize(R.dimen.margin_end)
        rightArrow.rotation = 315f
        rightArrow.layoutParams = layoutLeftArrow
        frameLayout.addView(rightArrow)
    }
}