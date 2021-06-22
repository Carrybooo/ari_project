package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationAddAriBinding

class MenuAffectationAddAriActivity : AppCompatActivity(){

    private lateinit var affectAdd : MenuAffectationAddAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        affectAdd = MenuAffectationAddAriBinding.inflate(layoutInflater)
        setContentView(affectAdd.root)
    }
}