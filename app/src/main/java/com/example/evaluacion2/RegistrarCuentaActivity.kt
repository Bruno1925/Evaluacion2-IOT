package com.example.evaluacion2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityRegistrarCuentaBinding

class RegistrarCuentaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarCuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnVolver.setOnClickListener {
            finish()
        }

    }
}
