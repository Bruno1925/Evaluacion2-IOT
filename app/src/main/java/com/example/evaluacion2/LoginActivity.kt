package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Iniciar sesión")
                .setMessage("Has iniciado sesión correctamente (simulado).")
                .setPositiveButton("Aceptar", null)
                .show()
        }

        binding.tvRecuperarClave.setOnClickListener {
            startActivity(Intent(this, RecuperarClaveActivity::class.java))
        }

        binding.tvRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistrarCuentaActivity::class.java))
        }
    }
}
