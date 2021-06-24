package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuControleHistoriqueAriBinding

class MenuControleHistoriqueAriActivity : AppCompatActivity() {
    
    private lateinit var histoControle : MenuControleHistoriqueAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        histoControle = MenuControleHistoriqueAriBinding.inflate(layoutInflater)
        setContentView(histoControle.root)
    }

}
