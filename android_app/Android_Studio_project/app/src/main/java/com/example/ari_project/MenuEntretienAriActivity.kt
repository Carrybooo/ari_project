package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuEntretienAriBinding

class MenuEntretienAriActivity : AppCompatActivity() {

    private lateinit var entretienAriBinding: MenuEntretienAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //declarations éléments ---->
        entretienAriBinding = MenuEntretienAriBinding.inflate(layoutInflater)
        setContentView(entretienAriBinding.root)

        //scanID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        //listeners
        //Buttons (Controles, Gonflages, Reparations)
        val controlesButton = findViewById<Button>(R.id.controles_button_ari)
        val gonflagesButton = findViewById<Button>(R.id.gonflage_button_ari)
        val reparationsButton = findViewById<Button>(R.id.reparations_button_ari)

        controlesButton.setOnClickListener {
            val intent = Intent(this, MenuControleAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        gonflagesButton.setOnClickListener {
            val intent = Intent(this, MenuGonflageAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        reparationsButton.setOnClickListener {
            val intent = Intent(this, MenuReparationsAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        title = getString(R.string.ID_equipe_entretien) + " " + scanID //titre qui contient l'ID
    }

}
