package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationRemoveAriBinding

class MenuAffectationRemoveAriActivity : AppCompatActivity(){

    private lateinit var affectRemove : MenuAffectationRemoveAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        affectRemove = MenuAffectationRemoveAriBinding.inflate(layoutInflater)
        setContentView(affectRemove.root)

        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }
}