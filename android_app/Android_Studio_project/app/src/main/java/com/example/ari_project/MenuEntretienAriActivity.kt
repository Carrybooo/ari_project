package com.example.ari_project

import android.os.Bundle
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






        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }
}