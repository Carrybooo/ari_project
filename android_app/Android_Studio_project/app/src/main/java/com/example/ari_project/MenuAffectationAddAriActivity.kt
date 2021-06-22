package com.example.ari_project

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationAddAriBinding

class MenuAffectationAddAriActivity : AppCompatActivity(){

    private lateinit var affectAdd : MenuAffectationAddAriBinding
    private lateinit var textViewID : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        affectAdd = MenuAffectationAddAriBinding.inflate(layoutInflater)
        setContentView(affectAdd.root)

        textViewID = findViewById(R.id.scanner_view)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        textViewID.text = scanID

        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }
}