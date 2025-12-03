package com.example.evaluacion2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityRecuperarClaveBinding

class RecuperarClaveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecuperarClaveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecuperarClaveBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnVolver.setOnClickListener {
            finish()
        }

    }
}
