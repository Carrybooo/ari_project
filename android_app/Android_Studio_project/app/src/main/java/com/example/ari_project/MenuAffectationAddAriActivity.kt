package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ari_project.databinding.MenuAffectationAddAriBinding
import java.net.URL

class MenuAffectationAddAriActivity : AppCompatActivity(){

    //views ref
    private lateinit var textIdAffectAdd : TextView
    private lateinit var texteHistoriqueGonflageDate : TextView


    //elements ref
    private val url = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")
    private var jsonText = "<JSON_String>"

    private lateinit var affectAdd : MenuAffectationAddAriBinding
    private lateinit var textViewID : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        affectAdd = MenuAffectationAddAriBinding.inflate(layoutInflater)
        setContentView(affectAdd.root)

        textViewID = findViewById(R.id.text_id_affect_add)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.
        textViewID.text = scanID

        val accueil = findViewById<Button>(R.id.home_button)
        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        title = getString(R.string.ID_equipe_affectation) + " " + scanID + " (Ajouter)"//titre qui contient l'ID
    }
}