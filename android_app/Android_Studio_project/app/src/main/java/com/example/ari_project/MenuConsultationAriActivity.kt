package com.example.ari_project

///TEST
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ari_project.databinding.MenuConsultationAriBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.URL


class MenuConsultationAriActivity : AppCompatActivity() {

    //views refs
    private lateinit var consultationAriBinding: MenuConsultationAriBinding
    private lateinit var etatGonflage : TextView
    private lateinit var lieuStock : TextView
    private lateinit var textHistoriqueGonflagesValue : TextView
    private lateinit var textHistoriqueControlesValue : TextView
    private lateinit var textHistoriqueReparationsValue : TextView

    //elements refs
    private val urlAriList = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")
    private var jsonAriList = "<JSON_String>"
    private val urlHistoriqueGonflage = URL("http://ari.juliendrieu.fr/api/historiquegonflage/liste_historique_gonflage.php")
    private var jsonHistoriqueGonflage = "<JSON_String>"
    private val urlHistoriqueControle = URL("http://ari.juliendrieu.fr/api/historiquecontrole/liste_historique_controle.php")
    private var jsonHistoriqueControle  = "<JSON_String>"
    private val urlHistoriqueReparation  = URL("http://ari.juliendrieu.fr/api/historiquerepa/liste_historique_repa.php")
    private var jsonHistoriqueReparation = "<JSON_String>"

    @SuppressLint("SetTextI18n")//Pour utiliser des hardcoded strings sans warnings


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        consultationAriBinding = MenuConsultationAriBinding.inflate(layoutInflater)
        setContentView(consultationAriBinding.root)

        etatGonflage = findViewById(R.id.text_etat_gonflage_value)
        lieuStock = findViewById(R.id.text_lieu_de_stock_value)
        textHistoriqueGonflagesValue = findViewById(R.id.text_historique_gonflages_value)
        textHistoriqueControlesValue = findViewById(R.id.text_historique_controles_value)
        textHistoriqueReparationsValue = findViewById(R.id.text_historique_reparations_value)

        val accueil = findViewById<Button>(R.id.home_button)

        title = getString(R.string.ID_equipe_consultation) + " " + scanID //titre qui contient l'ID

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // io dispatcher pour les opérations réseau
        lifecycleScope.launch(Dispatchers.IO){
            //jsonString = url.getString().toString()
            try{jsonAriList = urlAriList.readText()}
            catch (e: IOException){e.toString()}
            try {jsonHistoriqueGonflage = urlHistoriqueGonflage.readText()}
            catch (e: IOException){e.toString()}
            try {jsonHistoriqueControle = urlHistoriqueControle.readText()}
            catch (e: IOException){e.toString()}
            try {jsonHistoriqueReparation = urlHistoriqueReparation.readText()}
            catch (e: IOException){e.toString()}

            /* PRINTER JSON TEST
            println("JSON PRINTER GONFL----------------------------------------------------------")
            println(jsonHistoriqueGonflage)
            println("JSON PRINTER CONTR----------------------------------------------------------")
            println(jsonHistoriqueControle)
            println("JSON PRINTER REPAR----------------------------------------------------------")
            println(jsonHistoriqueReparation)
            */

            // default dispatcher pour le parsing, gros travail CPU
            withContext(Dispatchers.Default){
                //on parse le JSON récupéré pour récupérer les infos liées au scanID
                val ari = getAriInfo(jsonAriList, scanID)
                val historiqueGonflages = getHistoriqueGonflages(jsonHistoriqueGonflage, scanID)
                val historiqueControles = getHistoriqueControles(jsonHistoriqueControle, scanID)
                val historiqueReparations = getHistoriqueReparations(jsonHistoriqueReparation, scanID)
                println(historiqueControles.toString())


                // main dispatcher pour les interactions avec l'UI
                withContext(Dispatchers.Main) {
                    etatGonflage.text = when(ari?.etat_gonflage){
                        null -> "ID non trouvé"
                        1 -> "Gonflé"
                        else -> "Non gonflé/Défectueux"
                    }
                    lieuStock.text = when(ari?.lieu_stock){
                        null -> "ID non trouvé"
                        else -> ari.lieu_stock
                    }
                    when(historiqueGonflages){
                        null -> textHistoriqueGonflagesValue.text = "aucun historique de gonflage"
                        else -> {
                            textHistoriqueGonflagesValue.text = ""
                            historiqueGonflages?.forEach {
                                textHistoriqueGonflagesValue.append("${it}\n")
                            }
                        }
                    }
                    when(historiqueControles){
                        null -> textHistoriqueControlesValue.text = "aucun historique de contrôle"
                        else -> {
                            textHistoriqueControlesValue.text = ""
                            historiqueControles?.forEach {
                                textHistoriqueControlesValue.append("${it}\n")
                            }
                        }
                    }
                    when(historiqueReparations){
                        null -> textHistoriqueReparationsValue.text = "aucun historique de réparation"
                        else -> {
                            textHistoriqueReparationsValue.text = ""
                            historiqueReparations?.forEach {
                                textHistoriqueReparationsValue.append("${it}\n")
                            }
                        }
                    }
                }
            }
        }
        println("ENDMARKER------------------MenuConsultationAriActivity------------------OnCreate")
    }//ONCREATE




    public data class ARI(
        var id:String,
        var etat_gonflage:Int,
        var lieu_stock:String,
        var historique_gonflages: List<String>?,
        var historique_controles: List<String>?,
        var historique_reparations: List<String>?
    )

    private fun getAriInfo(data:String, id:String):ARI?{
        var element = ARI("",0,"",
            null,null, null)
        try {
            val array = JSONObject(data).getJSONArray("ari_list")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                if(obj.getString("id")==id) {
                    val etatGonflage = obj.getInt("etat_gonflage")
                    val lieuStock = obj.getString("lieu_stock")
                    element = ARI(id, etatGonflage, lieuStock,
                        null, null, null)
                }
            }
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }
        return if(element.id != "") element
        else null
    }//GetAriInfo


    private fun getHistoriqueGonflages(data:String, id:String):List<String>?{
        val list = mutableListOf<String>()
        try {
            val array = JSONObject(data).getJSONArray("historique_gonflage")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                if(obj.getString("ari")==id) {
                    val date = obj.getString("date")
                    list.add(date)
                }
            }
            list.sortDescending()
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }
        return if(list.isEmpty()) null
        else list
    }//getHistoriqueGonflages


    private fun getHistoriqueControles(data:String, id:String):List<String>?{
        val list = mutableListOf<String>()
        try {
            val array = JSONObject(data).getJSONArray("historique_controle")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                if(obj.getString("id")==id) {
                    val date = obj.getString("date")
                    println(date)
                    list.add(date)
                }
            }
            list.sortDescending()
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }
        return if(list.isEmpty()) null
        else list
    }//getHistoriqueControles


    private fun getHistoriqueReparations(data:String, id:String):List<String>?{
        val list = mutableListOf<String>()
        try {
            val array = JSONObject(data).getJSONArray("historique_repa")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                if(obj.getString("id")==id) {
                    val date = obj.getString("date")
                    list.add(date)
                }
            }
            list.sortDescending()
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }
        return if(list.isEmpty()) null
        else list
    }//getHistoriqueReparations

}//ENBRACKET