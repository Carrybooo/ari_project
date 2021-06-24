package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuControleHistoriqueAriBinding

class MenuControleHistoriqueAriActivity : AppCompatActivity() {
    
    private lateinit var histoControle : MenuControleHistoriqueAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        histoControle = MenuControleHistoriqueAriBinding.inflate(layoutInflater)
        setContentView(histoControle.root)

        val accueil = findViewById<Button>(R.id.home_button)

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}
