package com.miu.mdp.mdp_lab6.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.mdp_lab6.R
import com.miu.mdp.mdp_lab6.databinding.ActivityLoginBinding
import com.miu.mdp.mdp_lab6.datasource.ResumeDataSource
import com.miu.mdp.mdp_lab6.logic.authUser
import com.miu.mdp.mdp_lab6.logic.dataSource
import com.miu.mdp.mdp_lab6.ui.fragment.RegisterFrag

class LandingActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataSource = ResumeDataSource(this)

        if (authUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = ""
    }
}
