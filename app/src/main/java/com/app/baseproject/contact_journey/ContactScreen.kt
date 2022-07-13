package com.app.baseproject.contact_journey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.load
import coil.request.Disposable
import coil.transform.RoundedCornersTransformation
import com.app.baseproject.databinding.ContactScreenBinding
import com.app.baseproject.utils.network.NetworkResult
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactScreen : Fragment() {
    private val viewModel: ContactViewModel by viewModel()
    private lateinit var _binding: ContactScreenBinding
    private var imageUrl: String? = null
    private lateinit var disposable: Disposable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ContactScreenBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchData()
        _binding.imgRefresh.setOnClickListener {
            fetchResponse()
        }
    }

    private fun fetchResponse() {
        viewModel.fetchContactResponse()
        _binding.pbDog.visibility = View.VISIBLE
    }


    private fun fetchData() {
        fetchResponse()
        viewModel.response.observe(viewLifecycleOwner) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        imageUrl = response.data.message
                        _binding.imgDog.load(
                            response.data.message
                        ) {
                            transformations(RoundedCornersTransformation(16f))
                        }
                    }
                    _binding.pbDog.visibility = View.GONE
                }

                is NetworkResult.Error -> {
                    _binding.pbDog.visibility = View.GONE
                    Toast.makeText(
                        activity,
                        response.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is NetworkResult.Loading -> {
                    _binding.pbDog.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}