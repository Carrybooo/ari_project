package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ari_project.databinding.MenuAriBinding

class chooseActivity : AppCompatActivity() {

    private lateinit var ariBinding: MenuAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ariBinding = MenuAriBinding.inflate(layoutInflater)
        setContentView(ariBinding.root)

        val consultButton = findViewById<Button>(R.id.button)

        consultButton.setOnClickListener {
            val intent = Intent(consultButton.context, MainActivity::class.java) //TODO() Créer la vu de la consultation
            startActivity(intent)
        }

        title = getString(R.string.ID_equipe) + " " //TODO() Rajouter l'ID de l'équipement
    }
}