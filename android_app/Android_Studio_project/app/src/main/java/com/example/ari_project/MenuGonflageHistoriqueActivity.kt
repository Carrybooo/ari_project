package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuGonflageHistoriqueAriBinding

class MenuGonflageHistoriqueActivity : AppCompatActivity() {

    private lateinit var gonflageHisto : MenuGonflageHistoriqueAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gonflageHisto = MenuGonflageHistoriqueAriBinding.inflate(layoutInflater)
        setContentView(gonflageHisto.root)
    }
}