package com.miu.mdp.mdp_lab6.ui.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.miu.mdp.mdp_lab6.R
import com.miu.mdp.mdp_lab6.model.Contact
import com.miu.mdp.mdp_lab6.model.ContactType
import com.miu.mdp.mdp_lab6.databinding.ContactItemBinding
import java.util.*

class ContactsAdapter(private val contacts: List<Contact>): RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {
    private lateinit var binding: ContactItemBinding

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindTo(contacts[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)
    }

    inner class ContactViewHolder(private val binding: ContactItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindTo(contact: Contact) {
            binding.uriDetail.text = contact.contactType.name.lowercase().replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            }
            binding.uriDesc.text = contact.contactData

            binding.layout.setOnClickListener {

                val intent: Intent = when(contact.contactType) {
                    ContactType.PHONE -> {
                        Intent(Intent.ACTION_DIAL).apply {
                            data = Uri.parse("tel:${contact.contactData}")
                        }
                    }
                    ContactType.EMAIL -> {
                        Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:")
                            putExtra(Intent.EXTRA_EMAIL, contact.contactData)
                            putExtra(Intent.EXTRA_SUBJECT, "Mary G Talemwa Resume")
                        }
                    }
                    ContactType.LINK -> {
                        Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(contact.contactData)
                        }
                    }
                }
                val context = binding.root.context
                if (intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "No app to open this", Toast.LENGTH_SHORT).show()
                }
            }
            val context = binding.root.context.resources
            when(contact.contactType) {
                ContactType.PHONE -> binding.avatar.setImageDrawable(context.getDrawable(R.drawable.ic_call_black_24dp,
                    null))
                ContactType.EMAIL -> binding.avatar.setImageDrawable(context.getDrawable(R.drawable.ic_email_black_24dp,
                    null))
                ContactType.LINK -> binding.avatar.setImageDrawable(context.getDrawable(R.drawable.ic_public_black_24dp,
                    null))
            }

        }
    }
}
