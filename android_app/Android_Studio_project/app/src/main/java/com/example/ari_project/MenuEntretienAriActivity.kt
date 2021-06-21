package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuEntretienAriBinding

class MenuEntretienAriActivity : AppCompatActivity() {

    private lateinit var entretienAriBinding: MenuEntretienAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        entretienAriBinding = MenuEntretienAriBinding.inflate(layoutInflater)
        setContentView(entretienAriBinding.root)

    }
}