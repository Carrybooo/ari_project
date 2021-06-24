package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuGonflageHistoriqueAriBinding

class MenuGonflageHistoriqueActivity : AppCompatActivity() {

    private lateinit var gonflageHisto : MenuGonflageHistoriqueAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gonflageHisto = MenuGonflageHistoriqueAriBinding.inflate(layoutInflater)
        setContentView(gonflageHisto.root)

        val accueil = findViewById<Button>(R.id.home_button)

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}