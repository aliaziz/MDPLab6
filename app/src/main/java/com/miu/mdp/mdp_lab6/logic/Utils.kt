package com.miu.mdp.mdp_lab6.logic

import com.miu.mdp.mdp_lab6.datasource.ResumeDataSource
import com.miu.mdp.mdp_lab6.model.AuthUser
import com.miu.mdp.mdp_lab6.model.SessionUser

lateinit var dataSource: ResumeDataSource
var authUser: AuthUser? = null
var sessionUser: SessionUser? = null
