package com.miu.mdp.mdp_lab6.model

import java.io.Serializable

data class Experience(
    val company: String,
    val companyLogo: String,
    val role: String,
    val duration: String,
    val location: String,
    val description: String
): Serializable
