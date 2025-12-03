package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {

            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Ir a la tienda
                        val intent = Intent(this, HomeActivity::class.java)
                        intent.putExtra("titulo", "Tienda de Música")
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, "Usuario o clave incorrectos", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        binding.btnSalirApp.setOnClickListener {
            finishAffinity()
        }

        binding.tvRecuperarClave.setOnClickListener {
            startActivity(Intent(this, RecuperarClaveActivity::class.java))
        }

        binding.tvRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistrarCuentaActivity::class.java))


        }
    }
}
