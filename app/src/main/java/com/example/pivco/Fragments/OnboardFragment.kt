package com.example.pivco.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.pivco.MainActivity
import com.example.pivco.R
import com.example.pivco.databinding.FragmentOnboardBinding


class OnboardFragment : Fragment(R.layout.fragment_onboard) {
    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonEnter.setOnClickListener {
            (activity as? MainActivity)?.navigateToLogin()
        }

        binding.buttonRegistration.setOnClickListener {
            (activity as? MainActivity)?.navigateToRegister()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}