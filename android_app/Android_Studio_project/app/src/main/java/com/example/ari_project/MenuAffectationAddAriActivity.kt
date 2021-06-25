package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ari_project.databinding.MenuAffectationAddAriBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.menu_affectation_add_ari.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.URL


class MenuAffectationAddAriActivity : AppCompatActivity(){

    //views ref
    private lateinit var affectAdd : MenuAffectationAddAriBinding
    private lateinit var textEtatAffectationAdd : TextView
    private lateinit var textIdAffectAdd : TextView
    private lateinit var textEtatAffectationAddChange : TextView
    private lateinit var inputAffectationAdd : TextInputEditText
    private lateinit var affectationAddConfirmButton : Button

    //elements ref
    private val urlAriList = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")
    private var urlModifLieuStock = URL("http://ari.juliendrieu.fr/api/reglages/modifier_gonflage.php")
    private var jsonQuery = "<JSON_String>"
    private var jsonResponse = "<JSON_String>"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        affectAdd = MenuAffectationAddAriBinding.inflate(layoutInflater)
        setContentView(affectAdd.root)

        textEtatAffectationAdd = findViewById(R.id.text_etat_affectation_add)
        textIdAffectAdd = findViewById(R.id.text_id_affect_add)
        textEtatAffectationAddChange = findViewById(R.id.text_etat_affectation_add_change)
        inputAffectationAdd = findViewById(R.id.input_affectation_add)
        affectationAddConfirmButton = findViewById(R.id.affectation_add_confirm_button)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.
        title = getString(R.string.ID_equipe_affectation) + " " + scanID + " (Ajouter)"//titre qui contient l'ID

        val accueil = findViewById<Button>(R.id.home_button)
        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        lifecycleScope.launch(Dispatchers.IO) {
            try{jsonQuery = urlAriList.readText()}
            catch (e: IOException){e.toString()}

            println(jsonQuery)

            withContext(Dispatchers.Default) {
                val affectActuelle = getAriAffect(jsonQuery, scanID)
                val affectString = affectActuelle.affect
                val affectBool = affectActuelle.affectBool
                println(affectString)

                withContext(Dispatchers.Main) {
                    textIdAffectAdd.text = when(affectString){
                        null -> "ID non trouvé/ARI non affecté"
                        else -> affectString
                    }
                    affectation_add_confirm_button.setOnClickListener{
                        urlModifLieuStock = URL("http://ari.juliendrieu.fr/api/reglages/modifier_lieu.php")
                        val affectNew = inputAffectationAdd.text.toString()
                        if(affectBool) {//si l'ID est bien dans la base de données
                            when (affectNew) {//switch sur le texte entré
                                affectString -> {//si le CS voulu est le meme que l'actuel
                                    Toast.makeText(
                                        affectation_add_confirm_button.context,
                                        "Cet ARI est déjà affecté à ce centre",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                else -> {//sinon on vérifie que l'affectation n'est pas autre chose qu'un CS
                                    if (!affectNew.startsWith("CS", 0)) {
                                        println("ENTREEEE CS")
                                        Toast.makeText(
                                            affectation_add_confirm_button.context,
                                            "L'affectation doit se faire à un CS\n Exemple : \"CS23\"",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {//si c'est bien un CS, on procède au changement d'affectation voulu
                                        urlModifLieuStock =//on setup le lien de modif
                                            URL(urlModifLieuStock.toString()
                                                    +"?id="+scanID+"&lieu_stock="+affectNew)
                                        //on modif et on stock la réponse
                                        try{jsonResponse = urlModifLieuStock.readText()}
                                        catch (e: IOException){e.toString()}
                                        //on formate la réponse (problème avec les caratères spéciaux)
                                        jsonResponse=jsonResponse.replace("\\u00e9","é")
                                        //on l'affiche
                                        Toast.makeText(affectation_add_confirm_button.context,
                                            jsonResponse+" Nouvelle affectation : "+affectNew,
                                            Toast.LENGTH_LONG).show()
                                        //on retourne à l'écran principal
                                        val intent = Intent(affectation_add_confirm_button.context,
                                            MainActivity::class.java)
                                        startActivity(intent)
                                    }
                                }
                            }
                        }else{//si l'ID n'est pas trouvé dans la base de données
                            Toast.makeText(affectation_add_confirm_button.context,
                                "L'ID n'est pas un ARI reconnu. Impossible de l'affecter à un CS",
                                Toast.LENGTH_SHORT).show()
                        }
                    }//OnClicklistener
                }//Main scope
            }//Default scope
        }//IO scope
    }//OnCreate

    data class Affectation(
        var affect : String?,
        var affectBool : Boolean
    )

    private fun getAriAffect(data:String, id:String): Affectation{
        val result = Affectation(
            affect = null,
            affectBool = false
        )
        try {
            val array = JSONObject(data).getJSONArray("ari_list")
            for(i in 0 until array.length()) {
                val obj = JSONObject(array[i].toString())
                if (obj.getString("id") == id) {
                    result.affectBool = true
                    result.affect = obj.getString("lieu_stock")
                }
            }
        }catch (e: JSONException){
            Log.d("Exception", e.toString())
        }
        return result
    }//GetListGonflages

}