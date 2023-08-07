package com.example.datastrutures.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.datastrutures.R
import com.example.datastrutures.databinding.FragmentGalleryBinding
import com.example.datastrutures.library.Stack

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null


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
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.stackSimulateButton.setOnClickListener {
            val intent = Intent(activity, StackSimulateActivity::class.java)
            startActivity(intent)

        }

        binding.stackReadButton.setOnClickListener {
            callFragment(GalleryFragment())

        }

        return root
    }

    fun callFragment(fragment: Fragment) {
        val fragmentTransaction =  activity?.supportFragmentManager?.beginTransaction()

        fragmentTransaction?.replace(R.id.frameLayoutForFragments, fragment)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}