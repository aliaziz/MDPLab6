package com.miu.mdp.mdp_lab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.mdp_lab6.databinding.ActivityLoginBinding

class LandingActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = ""
    }
}
