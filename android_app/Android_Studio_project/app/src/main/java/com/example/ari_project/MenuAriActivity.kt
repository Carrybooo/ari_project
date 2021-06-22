@file:Suppress("SpellCheckingInspection")

package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAriBinding

class MenuAriActivity : AppCompatActivity() {

    private lateinit var ariBinding: MenuAriBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //declarations éléments ---->
        ariBinding = MenuAriBinding.inflate(layoutInflater)
        setContentView(ariBinding.root)
        val consultButton = findViewById<Button>(R.id.consultation_button_ari)
        val entretButton = findViewById<Button>(R.id.entretien_button_ari)
        val affectButton = findViewById<Button>(R.id.affectation_button_ari)

        //scanID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        //listeners
        consultButton.setOnClickListener {
            val intent = Intent(this, MenuConsultationAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        entretButton.setOnClickListener {
            val intent = Intent(this, MenuEntretienAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        affectButton.setOnClickListener {
            val intent = Intent(affectButton.context, MenuAffectationAriActivity::class.java)
            startActivity(intent)
        }

        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }
}