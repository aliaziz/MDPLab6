package com.miu.mdp.mdp_lab6.model

import java.io.Serializable

data class School(
    val name: String,
    val courseTaken: String,
    val yearOfStudy: String,
    val logo: String
): Serializable
