package com.miu.mdp.mdp_lab6.model

import java.io.Serializable

data class SessionUser(
    val profilePic: String? = null,
    val fullName: String,
    val profession: String,
    val careerNote: String,
    val description: String,
    val tools: Map<String, String>
):Serializable

