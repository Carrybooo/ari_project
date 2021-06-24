package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuReparationsHistoriqueAriBinding

class MenuReparationsHistoriqueAriActivity : AppCompatActivity() {

    private lateinit var reparationsHistoriqueAri : MenuReparationsHistoriqueAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reparationsHistoriqueAri = MenuReparationsHistoriqueAriBinding.inflate(layoutInflater)
        setContentView(reparationsHistoriqueAri.root)

        val accueil = findViewById<Button>(R.id.home_button)

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}