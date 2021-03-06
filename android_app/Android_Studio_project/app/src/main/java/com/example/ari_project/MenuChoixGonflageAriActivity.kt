package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ari_project.databinding.MenuChoixGonflageAriBinding
import kotlinx.android.synthetic.main.menu_choix_gonflage_ari.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.URL


class MenuChoixGonflageAriActivity : AppCompatActivity() {

    //views refs
    private lateinit var gonflageAriBinding: MenuChoixGonflageAriBinding
    private lateinit var fieldEtatGonflage : TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonValider: Button

    //elements refs
    private val urlAriList = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")
    private var urlModifEtatGonflage = URL("http://ari.juliendrieu.fr/api/reglages/modifier_gonflage.php")
    private var jsonAriList = "<JSON_String>"
    private var jsonResponse = "<JSON_String>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        //declarations éléments ---->
        gonflageAriBinding = MenuChoixGonflageAriBinding.inflate(layoutInflater)
        setContentView(gonflageAriBinding.root)

        fieldEtatGonflage = findViewById(R.id.text_etat_gonflage_actuel_valeur)
        radioGroup = findViewById(R.id.radioGroup)
        buttonValider = findViewById(R.id.validation_gonflage_ari_button)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.
        title = getString(R.string.ID_equipe_entretien) + " " + scanID + " (Gonflage)" //titre qui contient l'ID

        val accueil = findViewById<Button>(R.id.home_button)
        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //IO dispatcher pour connexion réseau
        lifecycleScope.launch(Dispatchers.IO){
            try{jsonAriList = urlAriList.readText()}
            catch (e: IOException){e.toString()}
            //Default dispatcher pour les parsing (travail CPU)
            withContext(Dispatchers.Default){
                val etatGonflage = getAriState(jsonAriList, scanID)

                //main dispatcher pour les modifs d'UI
                withContext(Dispatchers.Main) {

                    fieldEtatGonflage.text = when(etatGonflage){
                        null -> "ID non trouvé"
                        1 -> "Gonflé"
                        else -> "Dégonflé"
                    }
                    buttonValider.setOnClickListener {
                        if(fieldEtatGonflage.text == "ID non trouvé"){
                            Toast.makeText(radioButton_gonflage_oui.context,"Cet ID d'ARI n'existe pas !",
                                Toast.LENGTH_SHORT).show()
                        }else {
                            val intent = Intent(buttonValider.context, MainActivity::class.java)


                            when (radioGroup.checkedRadioButtonId) {
                                //Update la table avec gonflage à 1 si modif effective
                                R.id.radioButton_gonflage_oui -> if (etatGonflage == 1) {
                                    Toast.makeText(
                                        radioButton_gonflage_oui.context, "L'ARI est déjà gonflé !",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    urlModifEtatGonflage = URL(urlModifEtatGonflage.toString()+
                                    "?id="+scanID+"&etat_gonflage=1")
                                    try{jsonResponse = urlModifEtatGonflage.readText()}
                                    catch (e: IOException){e.toString()}
                                    //on formate la réponse (problème avec les caratères spéciaux)
                                    jsonResponse=jsonResponse.replace("\\u00e9","é")
                                    //on l'affiche
                                    Toast.makeText(buttonValider.context,
                                        jsonResponse +" Nouvel état de gonflage : Gonflé !",
                                        Toast.LENGTH_LONG).show()
                                    startActivity(intent)
                                }
                                //Update la table avec gonlfage à 0 si modif effective
                                R.id.radioButton_gonflage_non -> if (etatGonflage == 0) {
                                    Toast.makeText(
                                        radioButton_gonflage_oui.context,
                                        "L'ARI est déjà dégonflé !",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    urlModifEtatGonflage = URL(urlModifEtatGonflage.toString()+
                                            "?id="+scanID+"&etat_gonflage=0")
                                    try{jsonResponse = urlModifEtatGonflage.readText()}
                                    catch (e: IOException){e.toString()}
                                    //on formate la réponse (problème avec les caratères spéciaux)
                                    jsonResponse=jsonResponse.replace("\\u00e9","é")
                                    //on l'affiche
                                    Toast.makeText(buttonValider.context,
                                        jsonResponse +" Nouvel état de gonflage : Dégonflé !",
                                        Toast.LENGTH_LONG).show()
                                    startActivity(intent)
                                }
                                //Toast avec obligation de choisir une option
                                else -> Toast.makeText(
                                    radioButton_gonflage_oui.context,
                                    "Vous devez choisir une option.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }//OnclickListener
                }//Main_dispatch
            }//Default_dispatch
        }//IO_dispatch
        println("ENDMARKER GONFLAGE")
    }//OnCREATE


    private fun getAriState(data:String, id:String): Int?{
        var etatGonflage : Int? = null
        try {
            val array = JSONObject(data).getJSONArray("ari_list")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                if(obj.getString("id")==id) {
                    etatGonflage = obj.getInt("etat_gonflage")
                }
            }
        }catch (e: JSONException){
            Log.d("Exception", e.toString())
        }
        return etatGonflage
    }//GetAriInfo

}