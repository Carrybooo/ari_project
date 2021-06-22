package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationAriBinding

class MenuAffectationAriActivity : AppCompatActivity() {

    private lateinit var affectationAriBinding: MenuAffectationAriBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        affectationAriBinding = MenuAffectationAriBinding.inflate(layoutInflater)
        setContentView(affectationAriBinding.root)

        val addButton = findViewById<Button>(R.id.affectation_add_button)
        val removeButton = findViewById<Button>(R.id.affectation_remove_button)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        //Listeners
        addButton.setOnClickListener {
            val intent = Intent(this, MenuAffectationAddAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        removeButton.setOnClickListener {
            val intent = Intent(this, MenuAffectationRemoveAriActivity::class.java)
            intent.putExtra("id", scanID)
            startActivity(intent)
        }

        title = getString(R.string.ID_equipe) + " " + scanID //titre qui contient l'ID
    }
}