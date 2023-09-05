package com.example.peludosdicas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.peludosdicas.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)
    }
}