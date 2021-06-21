@file:Suppress("SpellCheckingInspection")

package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAriBinding

class ChooseActivity : AppCompatActivity() {

    private lateinit var ariBinding: MenuAriBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //declarations éléments ---->
        ariBinding = MenuAriBinding.inflate(layoutInflater)
        setContentView(ariBinding.root)
        val consultButton = findViewById<Button>(R.id.button)
        val entretButton = findViewById<Button>(R.id.button2)
        val affectButton = findViewById<Button>(R.id.button3)

        //scanID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        //listeners
        consultButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) //TODO() TEST ICI, Créer la vu de la consultation à la place
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        entretButton.setOnClickListener {
            val intent = Intent(this, MenuEntretienAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        affectButton.setOnClickListener {
            val intent = Intent(affectButton.context, MainActivity::class.java)
            startActivity(intent)
        }

        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }
}