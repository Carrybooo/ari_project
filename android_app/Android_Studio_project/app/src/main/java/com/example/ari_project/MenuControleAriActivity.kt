package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuControleAriBinding
import com.example.ari_project.databinding.MenuControleHistoriqueAriBinding

class MenuControleAriActivity : AppCompatActivity() {

    private lateinit var controleAriBinding: MenuControleAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //declarations éléments ---->
        controleAriBinding = MenuControleAriBinding.inflate(layoutInflater)
        setContentView(controleAriBinding.root)

        val accueil = findViewById<Button>(R.id.home_button)
        val histoButton = findViewById<Button>(R.id.historique_controle_ari_button)
        val effectControle = findViewById<Button>(R.id.effect_controle_ari_button)

        //scanID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        histoButton.setOnClickListener {
            val intent = Intent(this, MenuControleHistoriqueAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        effectControle.setOnClickListener {
            Toast.makeText(this, "Fonctionnalité à venir !", Toast.LENGTH_SHORT).show()
        }



        title = getString(R.string.ID_equipe_entretien) + " " + scanID + " (Contrôles)" //titre qui contient l'ID

    }


}