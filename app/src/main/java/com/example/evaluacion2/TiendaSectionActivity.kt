package com.example.evaluacion2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityTiendaSectionBinding

class TiendaSectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTiendaSectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiendaSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitulo.text = intent.getStringExtra("titulo") ?: "Tienda"
        binding.btnVolver.setOnClickListener {
            finish()
        }


    }
}
