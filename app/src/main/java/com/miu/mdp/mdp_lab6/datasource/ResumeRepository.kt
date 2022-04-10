package com.miu.mdp.mdp_lab6.datasource

import com.miu.mdp.mdp_lab6.model.*

interface ResumeRepository {
    fun saveUser(fullName: String, email: String, password: String)
    fun getUser(email: String): AuthUser?
    fun getSessionUser(email: String): SessionUser?
    fun getEducation(): Education
    fun getExperience(): WorkExperience
    fun getContactDetails(): List<Contact>
}
