package com.example.evaluacion2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityRegistrarCuentaBinding
import com.google.firebase.auth.FirebaseAuth

class RegistrarCuentaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarCuentaBinding
    private lateinit var auth: FirebaseAuth   // ← agregado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()     // ← inicialización

        binding.btnRegistrar.setOnClickListener {
            val email = binding.etEmailRegistro.text.toString().trim()
            val password = binding.etPasswordRegistro.text.toString().trim()
            val password2 = binding.etPasswordRegistro2.text.toString().trim()

            // Validaciones básicas
            if (email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != password2) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 6) {
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 🔥 Crear usuario real en Firebase
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        AlertDialog.Builder(this)
                            .setTitle("Registro exitoso")
                            .setMessage("La cuenta ha sido creada correctamente.")
                            .setPositiveButton("Aceptar") { _, _ ->
                                finish() // vuelve al login
                            }
                            .show()

                    } else {
                        AlertDialog.Builder(this)
                            .setTitle("Error")
                            .setMessage(task.exception?.message ?: "No se pudo registrar el usuario.")
                            .setPositiveButton("Aceptar", null)
                            .show()
                    }
                }
        }
    }
}
