package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuValidationGonflageAriBinding

class MenuValidationGonflageAriActivity : AppCompatActivity(){

    private lateinit var validGonflage : MenuValidationGonflageAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        validGonflage = MenuValidationGonflageAriBinding.inflate(layoutInflater)
        setContentView(validGonflage.root)

        val accueil = findViewById<Button>(R.id.home_button)

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        title = getString(R.string.ID_equipe) + "(Validation) " + scanID //titre qui contient l'ID
    }

}