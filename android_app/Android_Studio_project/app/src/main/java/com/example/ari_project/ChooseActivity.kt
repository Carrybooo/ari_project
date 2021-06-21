package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAriBinding
import com.example.ari_project.databinding.MenuEntretienAriBinding

class ChooseActivity : AppCompatActivity() {

    private lateinit var ariBinding: MenuAriBinding

    val consultButton = findViewById<Button>(R.id.button)
    val entretButton = findViewById<Button>(R.id.button2)
    //val affectButton = findViewById<Button>(R.id.button3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ariBinding = MenuAriBinding.inflate(layoutInflater)
        setContentView(ariBinding.root)



        consultButton.setOnClickListener {
            val intent = Intent(consultButton.context, MainActivity::class.java) //TODO() Créer la vu de la consultation
            startActivity(intent)
        }

        entretButton.setOnClickListener {
            val intent = Intent(entretButton.context, MenuEntretienAriActivity::class.java)
            startActivity(intent)
        }

        /*affectButton.setOnClickListener {
            val intent = Intent(affectButton.context, MenuAffectationAriActivity::class.java)
            startActivity(intent)
        }*/

        title = getString(R.string.ID_equipe) + " " //TODO() Rajouter l'ID de l'équipement
    }
}