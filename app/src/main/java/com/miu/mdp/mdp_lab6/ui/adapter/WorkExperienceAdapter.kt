package com.miu.mdp.mdp_lab6.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miu.mdp.mdp_lab6.model.Experience
import com.miu.mdp.mdp_lab6.databinding.WorkExpItemBinding

class WorkExperienceAdapter(private val experiences: List<Experience>) : RecyclerView.Adapter<WorkExperienceAdapter.ExperienceViewHolder>() {
    private lateinit var workExpItemBinding: WorkExpItemBinding

    class ExperienceViewHolder(private val binding: WorkExpItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(experience: Experience) {
            binding.companyName.text = experience.company
            binding.companyLocation.text = experience.location
            binding.roles.text = experience.description
            binding.yearsOfService.text = experience.duration
            Glide.with(binding.root.context)
                .load(experience.companyLogo)
                .into(binding.companyLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        workExpItemBinding = WorkExpItemBinding.inflate(LayoutInflater.from(parent.context))
        return ExperienceViewHolder(workExpItemBinding)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        holder.bindTo(experiences[position])
    }

    override fun getItemCount(): Int {
        return experiences.size
    }

}
