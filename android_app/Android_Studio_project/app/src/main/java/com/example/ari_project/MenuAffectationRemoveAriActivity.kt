package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationRemoveAriBinding

class MenuAffectationRemoveAriActivity : AppCompatActivity(){

    private lateinit var affectRemove : MenuAffectationRemoveAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        affectRemove = MenuAffectationRemoveAriBinding.inflate(layoutInflater)
        setContentView(affectRemove.root)
    }
}