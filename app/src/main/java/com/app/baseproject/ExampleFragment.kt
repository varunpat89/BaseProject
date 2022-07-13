//package com.app.baseproject
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import coil.load
//import coil.request.Disposable
//import coil.transform.RoundedCornersTransformation
//import com.app.baseproject.databinding.TempLoadBinding
//import com.app.baseproject.utils.network.NetworkResult
//import com.app.baseproject.contact_journey.MainViewModel
//import org.koin.androidx.viewmodel.ext.android.viewModel
//import org.koin.dsl.module
//
//val fragmentModule = module {
//    factory { ExampleFragment() }
//}
//
//class ExampleFragment : Fragment() {
//    private val mainViewModel: MainViewModel by viewModel()
//    private lateinit var _binding: TempLoadBinding
//    private var imageUrl: String? = null
//    private lateinit var disposable: Disposable
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = TempLoadBinding.inflate(inflater, container, false)
//        return _binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        fetchData()
//        _binding.imgRefresh.setOnClickListener {
//            fetchResponse()
//        }
//    }
//
//    private fun fetchResponse() {
//        mainViewModel.fetchDogResponse()
//        _binding.pbDog.visibility = View.VISIBLE
//    }
//
//
//    private fun fetchData() {
//        fetchResponse()
//        mainViewModel.response.observe(viewLifecycleOwner) { response ->
//            when (response) {
//                is NetworkResult.Success -> {
//                    response.data?.let {
//                        imageUrl = response.data.message
//                        _binding.imgDog.load(
//                            response.data.message
//                        ) {
//                            transformations(RoundedCornersTransformation(16f))
//                        }
//                    }
//                    _binding.pbDog.visibility = View.GONE
//                }
//
//                is NetworkResult.Error -> {
//                    _binding.pbDog.visibility = View.GONE
//                    Toast.makeText(
//                        activity,
//                        response.message,
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//
//                is NetworkResult.Loading -> {
//                    _binding.pbDog.visibility = View.VISIBLE
//                }
//            }
//        }
//    }
//
//    override fun onDestroy() {
//        disposable.dispose()
//        super.onDestroy()
//    }
//
//}