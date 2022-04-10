package com.miu.mdp.mdp_lab6.model

import java.io.Serializable

data class AuthUser(
    val email: String,
    val password: String
): Serializable
