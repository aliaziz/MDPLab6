package com.miu.mdp.mdp_lab6.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.miu.mdp.mdp_lab6.databinding.FragmentHomeBinding
import com.miu.mdp.mdp_lab6.logic.authUser
import com.miu.mdp.mdp_lab6.logic.dataSource
import com.miu.mdp.mdp_lab6.logic.sessionUser

class HomeFrag : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sessionUser = dataSource.getSessionUser(authUser!!.email)

        Glide.with(requireContext())
            .load(sessionUser?.profilePic)
            .into(homeBinding.profilePic)

        with(homeBinding) {
            name.text = sessionUser?.fullName
            profession.text = sessionUser?.profession
            description.text = sessionUser?.description
            tools.text = sessionUser?.tools?.map { entry ->
                entry.key + ": "+entry.value
            }?.reduce { accumulator, next ->
                accumulator +"\n" + next + "\n"
            }
        }
    }
}
