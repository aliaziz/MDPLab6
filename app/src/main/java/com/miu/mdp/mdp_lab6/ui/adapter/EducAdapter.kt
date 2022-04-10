package com.miu.mdp.mdp_lab6.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miu.mdp.mdp_lab6.model.School
import com.miu.mdp.mdp_lab6.databinding.EducItemBinding

class EducAdapter(private val schools: List<School>): RecyclerView.Adapter<EducAdapter.EducViewHolder>() {
    lateinit var educItemBinding: EducItemBinding

    override fun getItemCount(): Int {
        return schools.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducViewHolder {
        educItemBinding = EducItemBinding.inflate(LayoutInflater.from(parent.context))
        return EducViewHolder(educItemBinding)
    }

    override fun onBindViewHolder(holder: EducViewHolder, position: Int) {
        val school = schools[position]
        holder.bindTo(school)

    }

    inner class EducViewHolder(private val binding: EducItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindTo(school: School) {
            Glide.with(binding.root.context)
                .load(school.logo)
                .into(binding.schoolLogo)
            binding.courseTaken.text = school.courseTaken
            binding.schoolName.text = school.name
        }
    }
}
