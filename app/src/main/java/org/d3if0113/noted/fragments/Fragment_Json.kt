package org.d3if0113.noted.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if0113.noted.R
import org.d3if0113.noted.databinding.FragmentJsonBinding


class fragment_Json : Fragment(R.layout.fragment__json) {

    private var _binding: FragmentJsonBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentJsonBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }




}