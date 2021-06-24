package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        title = getString(R.string.ID_equipe_entretien) + " " + scanID + " (Réparations)"//titre qui contient l'ID
    }
}