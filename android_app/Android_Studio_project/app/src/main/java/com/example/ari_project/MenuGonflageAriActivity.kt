package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuEntretienAriBinding
import com.example.ari_project.databinding.MenuGonflageAriBinding

class MenuGonflageAriActivity : AppCompatActivity() {

    private lateinit var gonflageAriBinding: MenuGonflageAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //declarations éléments ---->
        gonflageAriBinding = MenuGonflageAriBinding.inflate(layoutInflater)
        setContentView(gonflageAriBinding.root)
    }
}