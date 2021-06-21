package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuEntretienAriBinding
import com.example.ari_project.databinding.MenuReparationsAriBinding

class MenuReparationsAriActivity : AppCompatActivity() {

    private lateinit var reparationsAriBinding: MenuReparationsAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //scanID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        //declarations éléments ---->
        reparationsAriBinding = MenuReparationsAriBinding.inflate(layoutInflater)
        setContentView(reparationsAriBinding.root)
    }
}