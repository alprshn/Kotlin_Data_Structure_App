package com.example.datastrutures.ui.binary_search_trees

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginStart
import com.example.datastrutures.R
import com.example.datastrutures.databinding.ActivityBinarySearchTreesBinding
import com.example.datastrutures.databinding.ActivityQueuesSimulateBinding
import com.example.datastrutures.databinding.ActivityStackSimulateBinding
import com.example.datastrutures.library.BinarySearchTrees
import com.example.datastrutures.library.Node

class BinarySearchTreesSimulateActivity : AppCompatActivity() {
    private lateinit var frameLayout: FrameLayout
    private lateinit var binding: ActivityBinarySearchTreesBinding
    var trees: BinarySearchTrees = BinarySearchTrees()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBinarySearchTreesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        frameLayout = binding.frameLayout

        binding.addCircleButton.setOnClickListener {
            var insertData = binding.addTreeData.text.toString()
                .toInt() //Textview içerisinde bulunan sayıyı alma

            trees.Insert(insertData) // BST algoritmasına Textview içerisinde bulunan sayıyı gönderme
            refreshNodes(trees.root)
        }
    }

    private fun refreshNodes(root: Node?) {
        drawTree(root, frameLayout, resources.displayMetrics.widthPixels / 2, 100, 300)
    }

    private fun drawTree(node: Node?, parent: FrameLayout, x: Int, y: Int, xOffset: Int) {
        if (node != null) {
            val nodeView = createNewCircle(node.data.toString(), x, y, xOffset)
            //Daierelrein içerisine Textview içerisindeki sayıyı atama
            parent.addView(nodeView)
            if (node.leftChild != null) {
                drawTree(node.leftChild, parent, x - xOffset / 2, y + 150, xOffset / 2)
                LeftArrow(x, y, xOffset)
            }

            if (node.rightChild != null) {
                drawTree(node.rightChild, parent, x + xOffset / 2, y + 150, xOffset / 2)
                RightArrow(x, y, xOffset) // Sağ ok çizimi
            }
        }
    }

    fun createNewCircle(text: String, x: Int, y: Int, xOffset: Int): FrameLayout {
        val newFrameLayout = FrameLayout(this)
        var deneme = binding.addTreeData.text.toString().toInt()
        val layoutParams = FrameLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.frame_width),
            resources.getDimensionPixelSize(R.dimen.frame_height)
        ).apply {
            gravity = Gravity.CENTER_VERTICAL
        }

        layoutParams.leftMargin = x - xOffset / 2
        layoutParams.topMargin = y



        newFrameLayout.layoutParams = layoutParams
        newFrameLayout.setBackgroundResource(R.drawable.circle_background)

        val textView = TextView(this)
        textView.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.CENTER
        }
        textView.text = text
        textView.textSize = 16f

        newFrameLayout.addView(textView)
        //frameLayout.addView(newFrameLayout)
        return newFrameLayout
    }

    fun LeftArrow(x: Int, y: Int, xOffset: Int) {
        val leftArrow = TextView(this)
        leftArrow.setBackgroundResource(R.drawable.trees_arrow_left)
        val layoutLeftArrow = FrameLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.frame_width),
            resources.getDimensionPixelSize(R.dimen.frame_height)
        )
        layoutLeftArrow.marginStart =
            x - xOffset / 2 + resources.getDimensionPixelSize(R.dimen.margin_start)
        layoutLeftArrow.topMargin = y + resources.getDimensionPixelSize(R.dimen.margin_top)

        leftArrow.rotation = 225f
        leftArrow.layoutParams = layoutLeftArrow
        frameLayout.addView(leftArrow)
    }

    fun RightArrow(x: Int, y: Int, xOffset: Int) {
        val rightArrow = TextView(this)
        rightArrow.setBackgroundResource(R.drawable.trees_arrow_left)
        val layoutLeftArrow = FrameLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.frame_width),
            resources.getDimensionPixelSize(R.dimen.frame_height)
        )
        layoutLeftArrow.marginStart =
            x - xOffset / 2 + resources.getDimensionPixelSize(R.dimen.margin_start)
        layoutLeftArrow.topMargin =
            x - xOffset / 2 + resources.getDimensionPixelSize(R.dimen.margin_top)
        rightArrow.rotation = 45f
        rightArrow.layoutParams = layoutLeftArrow
        frameLayout.addView(rightArrow)
    }


}