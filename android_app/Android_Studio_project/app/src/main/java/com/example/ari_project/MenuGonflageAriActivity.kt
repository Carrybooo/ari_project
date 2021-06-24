package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuGonflageAriBinding

class MenuGonflageAriActivity : AppCompatActivity() {

    private lateinit var gonflageAri : MenuGonflageAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gonflageAri = MenuGonflageAriBinding.inflate(layoutInflater)
        setContentView(gonflageAri.root)

        val histoButton = findViewById<Button>(R.id.historique_gonflage_ari)
        val effectGonflage = findViewById<Button>(R.id.effect_gonflage_ari)
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        histoButton.setOnClickListener {
            val intent = Intent(this, MenuGonflageHistoriqueActivity::class.java)
            intent.putExtra("id",scanID)
            startActivity(intent)
        }

        effectGonflage.setOnClickListener {
            val intent = Intent(this, MenuChoixGonflageAriActivity::class.java)
            intent.putExtra("id",scanID)
            startActivity(intent)
        }

        val accueil = findViewById<Button>(R.id.home_button)

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}