package com.example.shop_2121.payment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shop_2121.R
import com.example.shop_2121.databinding.FragmentPaymentBinding


class PaymentFragment : Fragment() {

    var _binding:FragmentPaymentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPaymentBinding.inflate(inflater,container,false)
        val root:View = binding.root



        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardVisa.setOnClickListener{ v4 ->
            val myIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://visa.com/")
            )
            startActivity(myIntent)

        }

        binding.cardMbank.setOnClickListener{ v3 ->
            val myIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://mbank.kg/")
            )
            startActivity(myIntent)

        }

        binding.cardNurtelecom.setOnClickListener{ v2 ->
            val myIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=kg.o.nurte")
            )
            startActivity(myIntent)

        }

        binding.cardPaypal.setOnClickListener{ v1 ->
            val myIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://paypal.com/")
            )
            startActivity(myIntent)

        }


    }


}