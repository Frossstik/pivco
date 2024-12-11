package com.example.pivco.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pivco.Data.Person
import com.example.pivco.MainActivity
import com.example.pivco.R
import com.example.pivco.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding ?: RuntimeException(":(") as FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonEnter.setOnClickListener {
            val mailText = binding.editTextTextEmailAddress.text.toString()
            val passwordText = binding.editTextNumberPassword.text.toString()
            var isAuthenticated = false

            for (person in Person.list) {
                if (mailText == person.mail && passwordText == person.password) {
                    isAuthenticated = true

                    (activity as? MainActivity)?.navigateToHome(person)
                    break
                }
            }

            if (!isAuthenticated) {
                binding.incorrect.text = "Неверный email или пароль!"
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}