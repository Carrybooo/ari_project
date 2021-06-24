package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuControleAriBinding

class MenuControleAriActivity : AppCompatActivity() {

    private lateinit var controleAriBinding: MenuControleAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //declarations éléments ---->
        controleAriBinding = MenuControleAriBinding.inflate(layoutInflater)
        setContentView(controleAriBinding.root)

        val accueil = findViewById<Button>(R.id.home_button)

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //scanID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        title = getString(R.string.ID_equipe_entretien) + " " + scanID + " (Contrôles)" //titre qui contient l'ID

    }


}