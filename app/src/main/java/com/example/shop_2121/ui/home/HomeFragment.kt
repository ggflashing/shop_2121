package com.example.shop_2121.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shop_2121.databinding.FragmentHomeBinding
import com.example.shop_2121.models.ProductItem
import com.example.shop_2121.visibility

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var myAdapter: ShooseAdapter
    private lateinit var  mainList: ArrayList<ProductItem>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(homeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.progressBar.visibility(true)

        homeViewModel.getResponseLiveData().observe(

            viewLifecycleOwner,object :Observer<ArrayList<ProductItem>?>{
                override fun onChanged(value: ArrayList<ProductItem>?) {
                    binding.progressBar.visibility(false)
                    mainList = value!!

                    myAdapter = ShooseAdapter(requireActivity(),mainList)
                    binding.rvMainLsit.adapter = myAdapter

                }

            }

        )
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}