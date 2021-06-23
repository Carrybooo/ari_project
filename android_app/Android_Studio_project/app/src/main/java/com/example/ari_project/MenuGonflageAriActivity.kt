package com.example.ari_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuEntretienAriBinding
import com.example.ari_project.databinding.MenuGonflageAriBinding

class MenuGonflageAriActivity : AppCompatActivity() {

    private lateinit var gonflageAriBinding: MenuGonflageAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        //declarations éléments ---->
        gonflageAriBinding = MenuGonflageAriBinding.inflate(layoutInflater)
        setContentView(gonflageAriBinding.root)

        val selectedValGonflage = gonflageAriBinding.radioGroup.checkedRadioButtonId

        when(selectedValGonflage){
            R.id.radioButton -> "Oui" //Update la table avec gonflage à 1 si modif effective
            R.id.radioButton2 -> "Non" //Update la table avec gonlfage à 0 si modif effective
            else -> "You must check an option !" //Toast avec obligation de choisir une option
        }



        title = getString(R.string.ID_equipe_entretien) + " " + scanID + " (Gonflage)" //titre qui contient l'ID
    }
}