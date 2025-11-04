package com.example.evaluacion2

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityRecuperarClaveBinding

class RecuperarClaveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecuperarClaveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecuperarClaveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRecuperar.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Recuperar clave")
                .setMessage("Se ha enviado un correo de recuperación (simulado).")
                .setPositiveButton("Aceptar", null)
                .show()
        }
    }
}
