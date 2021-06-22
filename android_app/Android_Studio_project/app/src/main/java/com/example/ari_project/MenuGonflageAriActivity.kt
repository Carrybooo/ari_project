package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuEntretienAriBinding
import com.example.ari_project.databinding.MenuGonflageAriBinding

class MenuGonflageAriActivity : AppCompatActivity() {

    private lateinit var gonflageAriBinding: MenuGonflageAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        //declarations éléments ---->
        gonflageAriBinding = MenuGonflageAriBinding.inflate(layoutInflater)
        setContentView(gonflageAriBinding.root)

        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }
}