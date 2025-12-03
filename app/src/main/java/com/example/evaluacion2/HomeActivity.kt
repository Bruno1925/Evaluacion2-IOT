package com.example.evaluacion2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluacion2.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvBienvenido.text =
            "Bienvenido a MusicStore, ${auth.currentUser?.email}"

        // --- Eventos de las tarjetas ---
        binding.cardAuriculares.setOnClickListener {
            openSection("Auriculares")
        }

        binding.cardCanciones.setOnClickListener {
            openSection("Canciones")
        }

        binding.cardInstrumentos.setOnClickListener {
            openSection("Instrumentos")
        }

        binding.cardDJ.setOnClickListener {
            openSection("Equipo DJ")
        }
        binding.btnVolver.setOnClickListener {
            finish()
        }
        binding.btnLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()


        }
    }

    private fun openSection(name: String) {
        val intent = Intent(this, TiendaSectionActivity::class.java)
        intent.putExtra("titulo", name)
        startActivity(intent)
    }
}
