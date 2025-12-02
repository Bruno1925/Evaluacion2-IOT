package com.example.evaluacion2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityRecuperarClaveBinding
import com.google.firebase.auth.FirebaseAuth

class RecuperarClaveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecuperarClaveBinding
    private lateinit var auth: FirebaseAuth   // ← Agregado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecuperarClaveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()     // ← Inicialización obligatoria

        binding.btnRecuperar.setOnClickListener {
            val email = binding.etEmailRecuperar.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Ingresa un correo", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 🔥 Enviar correo real de recuperación
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        AlertDialog.Builder(this)
                            .setTitle("Recuperar clave")
                            .setMessage("Se ha enviado un correo para restablecer la contraseña.")
                            .setPositiveButton("Aceptar", null)
                            .show()
                    } else {
                        AlertDialog.Builder(this)
                            .setTitle("Error")
                            .setMessage(task.exception?.message ?: "No se pudo enviar el correo.")
                            .setPositiveButton("Aceptar", null)
                            .show()
                    }
                }
        }
    }
}
