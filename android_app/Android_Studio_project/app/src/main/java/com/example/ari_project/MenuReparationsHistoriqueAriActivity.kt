package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuReparationsHistoriqueAriBinding

class MenuReparationsHistoriqueAriActivity : AppCompatActivity() {

    private lateinit var reparationsHistoriqueAri : MenuReparationsHistoriqueAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reparationsHistoriqueAri = MenuReparationsHistoriqueAriBinding.inflate(layoutInflater)
        setContentView(reparationsHistoriqueAri.root)
    }
}