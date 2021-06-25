package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationRemoveAriBinding
import kotlinx.android.synthetic.main.activity_main.*

class MenuAffectationRemoveAriActivity : AppCompatActivity(){

    private lateinit var affectRemove : MenuAffectationRemoveAriBinding
    private lateinit var textViewID : TextView
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        affectRemove = MenuAffectationRemoveAriBinding.inflate(layoutInflater)
        setContentView(affectRemove.root)
        confirmButton = findViewById(R.id.affectation_remove_confirm_button)
        textViewID = findViewById(R.id.text_id_affect_remove)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.
        textViewID.text = scanID

        val accueil = findViewById<Button>(R.id.home_button)
        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        confirmButton.setOnClickListener {
            Toast.makeText(this, "Fonctionnalité à venir !", Toast.LENGTH_SHORT).show()
        }

        title = getString(R.string.ID_equipe_affectation) + " " + scanID + " (Retirer)" //titre qui contient l'ID
    }
}