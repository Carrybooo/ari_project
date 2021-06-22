package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuConsultationAriBinding

class MenuConsultationAriActivity : AppCompatActivity() {

    private lateinit var consultationAriBinding: MenuConsultationAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        consultationAriBinding = MenuConsultationAriBinding.inflate(layoutInflater)
        setContentView(consultationAriBinding.root)

    }

}