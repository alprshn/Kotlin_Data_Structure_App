package com.example.datastrutures.ui.stack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.example.datastrutures.databinding.ActivityStackSimulateBinding
import com.example.datastrutures.library.Stack

class StackSimulateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStackSimulateBinding


    var stack = Stack<Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStackSimulateBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var i = 1

        //Added Stack Class
        var pushListView = binding.listStack
        var arrayAdapter = ArrayAdapter(
            this,
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


        val actionBar = supportActionBar

        // Eğer ActionBar varsa, metni değiştir
        actionBar?.title = "Stack Simulation"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Aktiviteyi sonlandırarak geri gitme işlemini gerçekleştirir.
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}