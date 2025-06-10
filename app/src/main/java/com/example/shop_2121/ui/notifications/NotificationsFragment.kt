package com.example.shop_2121.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shop_2121.R
import com.example.shop_2121.databinding.FragmentNotificationsBinding
import com.example.shop_2121.loadImage
import com.example.shop_2121.models.ProductItem

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var comonqId: Int = 0
    private var product: ProductItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args:Bundle? = this.arguments

        if (args!=null){
            product = args.getSerializable("key") as ProductItem
        }else{
            comonqId = 1
        }

    }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.apply {
            cardDescTitle.text = product?.title
            cardDescPrice.text = product?.price.toString()
            cardDescDescriptoin.text = product?.description

            cardDescImage1.loadImage(product?.image.toString())
        }

//       if (product?.images?.size == 3){
//           binding.apply {
//               cardDescImage1.loadImage(product?.images!![0])
//               cardDescImage2.loadImage(product?.images!![1])
//               cardDescImage3.loadImage(product?.images!![2])
//
//
//           }
//       }else {
//           binding.cardDescImage1.loadImage(product?.images!![0])
//       }



        setUpOnBackPressed()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToHome.setOnClickListener{v ->
        findNavController().navigate(R.id.action_navigation_notifications_to_navigation_home)
        }





    }

    fun setUpOnBackPressed(){
        requireActivity().onBackPressedDispatcher
            .addCallback(object:OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    if (isEnabled){
                        requireActivity()
                            .finish()
                    }
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}