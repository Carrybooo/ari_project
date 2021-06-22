package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuControleAriBinding

class MenuControleAriActivity : AppCompatActivity() {

    private lateinit var controleAriBinding: MenuControleAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //declarations éléments ---->
        controleAriBinding = MenuControleAriBinding.inflate(layoutInflater)
        setContentView(controleAriBinding.root)

        //scanID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID

    }


}