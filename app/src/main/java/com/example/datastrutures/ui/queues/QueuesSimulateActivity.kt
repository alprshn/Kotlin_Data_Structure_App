package com.example.datastrutures.ui.queues

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.example.datastrutures.R
import com.example.datastrutures.databinding.ActivityQueuesSimulateBinding
import com.example.datastrutures.library.Queues

import com.example.datastrutures.library.Stack

class QueuesSimulateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQueuesSimulateBinding

    var queues = Queues<Any>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQueuesSimulateBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var i = 1

        //Added Stack Class
        var listView = binding.listQueues
        var arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, queues.getQueuesStorage()
        )

        listView.adapter = arrayAdapter

        binding.enqueueQueueButton.setOnClickListener {
            val stackItem = "Index $i" + binding.addQueues.text.toString().trim()
            queues.enqueue(stackItem)
            arrayAdapter.notifyDataSetChanged()
            binding.enqueueText.text = "Index $i" + binding.addQueues.text.toString().trim()
            i = i + 1


            binding.addQueues.text.clear()
        }

        binding.dequeueQueuesButton.setOnClickListener {
            binding.dequeueText.text = queues.peek().toString()
            queues.dequeue()
            arrayAdapter.notifyDataSetChanged()
        }

        binding.clearQueuesButton.setOnClickListener {
            arrayAdapter.clear()
            binding.addQueues.text.clear()
            binding.dequeueText.text = ""
            binding.enqueueText.text = ""

        }


        val actionBar = supportActionBar

        // Eğer ActionBar varsa, metni değiştir
        actionBar?.title = "Queues Simulation"
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