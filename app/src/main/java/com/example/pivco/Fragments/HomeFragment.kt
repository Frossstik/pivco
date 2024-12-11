package com.example.pivco.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pivco.Data.Person
import com.example.pivco.R
import com.example.pivco.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: RuntimeException(":(") as FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val person = arguments?.getSerializable("person") as? Person
        person?.let {
            binding.yourMail.text = it.mail
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}