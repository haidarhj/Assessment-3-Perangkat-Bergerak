package org.d3if0113.noted.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0113.noted.R
import org.d3if0113.noted.databinding.FragmentJsonBinding
import org.d3if0113.noted.model.Mobil
import org.d3if0113.noted.network.MobilApi


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

    private fun updateProgress(status: MobilApi.ApiStatus) {
        when (status) {
            MobilApi.ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            MobilApi.ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
            }
            MobilApi.ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(MobilApi.ApiStatus.LOADING)
            try {
                data.postValue(Mobil.service.getMobilUrl())
                status.postValue(MobilApi.ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(MobilApi.ApiStatus.FAILED)
            }
        }
    }
    fun getStatus(): LiveData<MobilApi.ApiStatus> = status



}