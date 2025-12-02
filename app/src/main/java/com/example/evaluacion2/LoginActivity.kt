package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth   // <-- agregado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()     // <-- inicializado

        binding.btnLogin.setOnClickListener {

            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 🔥 Inicio de sesión real con Firebase
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        // Ya no abre HomeActivity
                        AlertDialog.Builder(this)
                            .setTitle("Iniciar sesión")
                            .setMessage("Has iniciado sesión correctamente.")
                            .setPositiveButton("Aceptar", null)
                            .show()

                    } else {
                        AlertDialog.Builder(this)
                            .setTitle("Error")
                            .setMessage(task.exception?.message ?: "Error desconocido")
                            .setPositiveButton("Aceptar", null)
                            .show()
                    }
                }
        }

        binding.tvRecuperarClave.setOnClickListener {
            startActivity(Intent(this, RecuperarClaveActivity::class.java))
        }

        binding.tvRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistrarCuentaActivity::class.java))
        }
    }
}
