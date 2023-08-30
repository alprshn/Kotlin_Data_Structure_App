package com.example.datastrutures.ui.binary_search_trees

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.datastrutures.R
import com.example.datastrutures.databinding.ActivityBinarySearchTreesBinding
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
        drawTree(root, frameLayout, resources.displayMetrics.widthPixels / 2, 200, 300)
    }

    private fun drawTree(node: Node?, parent: FrameLayout, x: Int, y: Int, xOffset: Int) {
        if (node != null) {
            val nodeView = createNewCircle(node.data.toString(), x, y, xOffset)
            //Daierelrein içerisine Textview içerisindeki sayıyı atama
            parent.addView(nodeView)
            if (node.leftChild != null) {
                val leftX = x - xOffset / 2
                val leftY = y + 150

                drawTree(node.leftChild, parent, leftX, leftY, xOffset / 2)
                val lineView = createLine(x, y, leftX, leftY)
                parent.addView(lineView)
            }

            if (node.rightChild != null) {
                val rightX = x + xOffset / 2
                val rightY = y + 150
                drawTree(node.rightChild, parent, rightX, rightY, xOffset / 2)
                val lineView = createLine(x, y, rightX, rightY)
                parent.addView(lineView)
            }
        }
    }

    fun createNewCircle(text: String, x: Int, y: Int, xOffset: Int): FrameLayout {
        val newFrameLayout = FrameLayout(this)
        var deneme = binding.addTreeData.text.toString().toInt()
        val layoutParams = FrameLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.frame_width),
            resources.getDimensionPixelSize(R.dimen.frame_height)
        )
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


    private fun createLine(x1: Int, y1: Int, x2: Int, y2: Int): View {
        val line = View(this)
        val deltaX = (x2 - x1).toDouble()
        val deltaY = (y2 - y1).toDouble()

        val length = Math.sqrt(deltaX * deltaX + deltaY * deltaY)
        val angle = Math.atan2(deltaY, deltaX)
        val angleDegrees = Math.toDegrees(angle).toFloat()

        val layoutParams = FrameLayout.LayoutParams(
            length.toInt(),
            resources.getDimensionPixelSize(R.dimen.line_thickness)
        )
        layoutParams.leftMargin = x1
        layoutParams.topMargin = y1
        line.layoutParams = layoutParams
        line.setBackgroundColor(Color.BLACK)
        line.rotation = angleDegrees

        return line
    }



}