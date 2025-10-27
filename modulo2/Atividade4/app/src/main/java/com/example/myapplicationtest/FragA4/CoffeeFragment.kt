package com.example.myapplicationtest.FragA4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplicationtest.databinding.FragmentCoffeeBinding

class CoffeeFragment : Fragment() {
    private var _binding: FragmentCoffeeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCoffeeBinding.inflate(inflater, container, false)

        binding.btnDetail.setOnClickListener {
            val action = CoffeeFragmentDirections
                .actionCoffeeFragmentToDetailFragment("Café Expresso")
            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
