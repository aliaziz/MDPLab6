package com.miu.mdp.mdp_lab6.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.mdp.mdp_lab6.R
import com.miu.mdp.mdp_lab6.databinding.FragmentEducationBinding
import com.miu.mdp.mdp_lab6.logic.dataSource
import com.miu.mdp.mdp_lab6.ui.adapter.ContactsAdapter

class ContactFrag : Fragment() {
    private lateinit var educationBinding: FragmentEducationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        educationBinding = FragmentEducationBinding.inflate(layoutInflater, container, false)
        return educationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        educationBinding.sectionTitle.text = getString(R.string.contact)
        educationBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = ContactsAdapter(dataSource.getContactDetails())
        }
    }

}
