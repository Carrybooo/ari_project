package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationAddAriBinding

class MenuAffectationAddAriActivity : AppCompatActivity(){

    private lateinit var affectAdd : MenuAffectationAddAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        affectAdd = MenuAffectationAddAriBinding.inflate(layoutInflater)
        setContentView(affectAdd.root)

        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }
}