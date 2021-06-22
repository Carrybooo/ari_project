package com.example.ari_project

import android.os.Bundle
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

        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }

}