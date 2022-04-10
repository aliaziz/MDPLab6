package com.miu.mdp.mdp_lab6.model

import java.io.Serializable

data class Contact(
    val contactType: ContactType,
    val contactData: String
): Serializable
