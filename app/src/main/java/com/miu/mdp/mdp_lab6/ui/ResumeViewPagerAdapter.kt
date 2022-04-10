package com.miu.mdp.mdp_lab6.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.miu.mdp.mdp_lab6.ui.fragment.ContactFrag
import com.miu.mdp.mdp_lab6.ui.fragment.EducationFrag
import com.miu.mdp.mdp_lab6.ui.fragment.HomeFrag
import com.miu.mdp.mdp_lab6.ui.fragment.WorkExpFrag

class ResumeViewPagerAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFrag()
            1 -> EducationFrag()
            2 -> WorkExpFrag()
            3 -> ContactFrag()
            else -> HomeFrag()
        }
    }

}
