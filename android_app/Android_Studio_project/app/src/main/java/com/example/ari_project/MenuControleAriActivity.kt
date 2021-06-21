package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuControleAriBinding
import com.example.ari_project.databinding.MenuEntretienAriBinding

class MenuControleAriActivity : AppCompatActivity() {

    private lateinit var controleAriBinding: MenuControleAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //declarations éléments ---->
        controleAriBinding = MenuControleAriBinding.inflate(layoutInflater)
        setContentView(controleAriBinding.root)
    }
}