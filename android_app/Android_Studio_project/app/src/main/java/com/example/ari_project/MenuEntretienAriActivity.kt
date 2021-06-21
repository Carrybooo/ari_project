package com.example.ari_project

import android.content.Intent
import android.os.Bundle
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
        //Button 6, 7 et 8 (Controle, Gonflage, Reparations)
        val controleButton = findViewById<Button>(R.id.button6)
        val gonflageButton = findViewById<Button>(R.id.button7)
        val reparationsButton = findViewById<Button>(R.id.button8)

        controleButton.setOnClickListener {
            val intent = Intent(this, MenuControleAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        gonflageButton.setOnClickListener {
            val intent = Intent(this, MenuGonflageAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        reparationsButton.setOnClickListener {
            val intent = Intent(this, MenuReparationsAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }






        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }
}