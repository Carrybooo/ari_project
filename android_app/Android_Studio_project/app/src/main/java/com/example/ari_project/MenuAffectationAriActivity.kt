package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationAriBinding

class MenuAffectationAriActivity : AppCompatActivity() {

    private lateinit var affectationAriBinding: MenuAffectationAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        affectationAriBinding = MenuAffectationAriBinding.inflate(layoutInflater)
        setContentView(affectationAriBinding.root)
    }
}