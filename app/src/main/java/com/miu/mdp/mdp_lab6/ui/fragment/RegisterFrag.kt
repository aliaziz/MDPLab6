package com.miu.mdp.mdp_lab6.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.miu.mdp.mdp_lab6.databinding.FragmentRegisterBinding
import com.miu.mdp.mdp_lab6.logic.dataSource
import com.miu.mdp.mdp_lab6.ui.MainActivity

class RegisterFrag : Fragment() {
    private lateinit var registerBinding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        registerBinding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return registerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(registerBinding) {
            register.setOnClickListener {
                dataSource.saveUser(
                    fullName.text.toString(),
                    email.text.toString(),
                    password.text.toString()
                )

                Toast.makeText(requireContext(), "Saved user, login", Toast.LENGTH_SHORT).show()

                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        }
    }
}
