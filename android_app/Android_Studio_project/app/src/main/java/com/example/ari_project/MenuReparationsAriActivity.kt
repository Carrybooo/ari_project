package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuReparationsAriBinding

class MenuReparationsAriActivity : AppCompatActivity() {

    private lateinit var reparationsAriBinding: MenuReparationsAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //scanID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        //declarations éléments ---->
        reparationsAriBinding = MenuReparationsAriBinding.inflate(layoutInflater)
        setContentView(reparationsAriBinding.root)

        val accueil = findViewById<Button>(R.id.home_button)
        val histoRepa = findViewById<Button>(R.id.historique_reparations_ari_button)
        val progRepa = findViewById<Button>(R.id.prog_repa_ari_button)
        val effectRepa = findViewById<Button>(R.id.effect_repa_ari_button)

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        histoRepa.setOnClickListener {
            val intent = Intent(this, MenuReparationsHistoriqueAriActivity::class.java)
            intent.putExtra("id",scanID)
            startActivity(intent)
        }

        progRepa.setOnClickListener {
            Toast.makeText(this, "Fonctionnalité à venir !", Toast.LENGTH_SHORT).show()
        }

        effectRepa.setOnClickListener {
            Toast.makeText(this, "Fonctionnalité à venir !", Toast.LENGTH_SHORT).show()
        }

        title = getString(R.string.ID_equipe_entretien) + " " + scanID + " (Réparations)"//titre qui contient l'ID
    }
}