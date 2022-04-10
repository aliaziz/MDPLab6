package com.miu.mdp.mdp_lab6.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.miu.mdp.mdp_lab6.databinding.FragmentLoginBinding
import com.miu.mdp.mdp_lab6.logic.authUser
import com.miu.mdp.mdp_lab6.logic.dataSource
import com.miu.mdp.mdp_lab6.ui.LandingActivity
import com.miu.mdp.mdp_lab6.ui.MainActivity

class LoginFrag : Fragment() {

    private lateinit var loginFragBinder: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginFragBinder = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return loginFragBinder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginFragBinder.login.setOnClickListener {
            dataSource.also { resumeDataSource ->
                val user = resumeDataSource.getUser(
                    loginFragBinder.email.text.toString()
                )

                if (user != null &&
                    loginFragBinder.password.text.toString() == user.password
                ) {
                    authUser = user
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                } else Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        loginFragBinder.register.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace((requireActivity() as LandingActivity).binding.container.id, RegisterFrag())
                .commit()
        }

    }
}
