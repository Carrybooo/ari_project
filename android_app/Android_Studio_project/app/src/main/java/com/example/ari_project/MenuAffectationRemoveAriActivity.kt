package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationRemoveAriBinding

class MenuAffectationRemoveAriActivity : AppCompatActivity(){

    private lateinit var affectRemove : MenuAffectationRemoveAriBinding
    private lateinit var textViewID : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val accueil = findViewById<Button>(R.id.home_button)

        affectRemove = MenuAffectationRemoveAriBinding.inflate(layoutInflater)
        setContentView(affectRemove.root)

        textViewID = findViewById(R.id.text_id_affect_remove)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        textViewID.text = scanID

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        title = getString(R.string.ID_equipe_affectation) + " " + scanID + " (Retirer)" //titre qui contient l'ID
    }
}