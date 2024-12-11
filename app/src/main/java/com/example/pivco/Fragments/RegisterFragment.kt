package com.example.pivco.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pivco.Data.Person
import com.example.pivco.MainActivity
import com.example.pivco.R
import com.example.pivco.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding ?: RuntimeException(":(") as FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonEnter.setOnClickListener {
            val mailText = binding.editTextTextEmailAddress.text.toString()
            val passwordText1 = binding.editTextNumberPassword.text.toString()
            val passwordText2 = binding.editTextNumberPassword2.text.toString()

            if (passwordText1 == passwordText2) {
                val person = Person(mailText, passwordText1)
                Person.list.add(person)

                val bundle = Bundle().apply {
                    putSerializable("person", person)
                }

                val fragment = HomeFragment().apply {
                    arguments = bundle
                }
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                binding.incorrect.text = "Пароли не совпадают!"
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
