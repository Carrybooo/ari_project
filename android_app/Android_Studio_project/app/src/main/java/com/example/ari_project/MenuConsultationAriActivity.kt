package com.example.ari_project

///TEST
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ari_project.databinding.MenuConsultationAriBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.net.URL


class MenuConsultationAriActivity : AppCompatActivity() {

    private lateinit var consultationAriBinding: MenuConsultationAriBinding
    private lateinit var etat_gonflage : TextView
    private lateinit var lieu_stock : TextView

    private lateinit var buttonPull : Button
    private var jsonString = "<JSON_String>"
    private val url = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")

    override fun onCreate(savedInstanceState: Bundle?) = runBlocking {
        super.onCreate(savedInstanceState)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        consultationAriBinding = MenuConsultationAriBinding.inflate(layoutInflater)
        setContentView(consultationAriBinding.root)

        etat_gonflage = findViewById(R.id.text_etat_gonflage_value)
        lieu_stock = findViewById(R.id.text_lieu_de_stock_value)

        title = getString(R.string.ID_equipe_consultation) + " " + scanID //titre qui contient l'ID

        ////////////////TRY///////////////TODO() fichier a bien clean

        //url.let { textConsultation.text = it.toString() }

        // io dispatcher pour les opérations réseau
        lifecycleScope.launch(Dispatchers.IO){
            //jsonString = url.getString().toString()
            jsonString = url.readText()

            // default dispatcher pour le parsing, gros travail CPU
            withContext(Dispatchers.Default){
                //on parse le JSON récupéré pour récupérer les infos liées au scanID
                val ari = parseJson(jsonString, scanID)

                // main dispatcher pour les interactions avec l'UI
                withContext(Dispatchers.Main) {
                    etat_gonflage.text = when(ari?.etat_gonflage.toString()){
                        "1" -> "Gonflé"
                        else -> "Non gonflé/Défectueux"
                    }
                    lieu_stock.text = ari?.lieu_stock
                }
            }
        }
        print("ENDMARKER-----------------------------------MenuConsultationAriActivity----OnCreate")
    }//oncreate




    data class ARI(
        var id:String,
        val etat_gonflage:Int,
        val lieu_stock:String
    )

    private fun parseJson(data:String, id:String):ARI?{
        var element = ARI("",0,"")
        println("ENTERTHEPARSIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIING")

        try {
            val array = JSONObject(data).getJSONArray("ari_list")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                println("newJSON : "+obj)
                println("newJSON2 : "+obj)
                println("newJSON3 : "+obj)
                if(obj.getString("id")==id) {
                    val etatGonflage = obj.getInt("etat_gonflage")
                    val lieuStock = obj.getString("lieu_stock")
                    element = ARI(id, etatGonflage, lieuStock)
                }
            }
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }
        return if(element.id != "") element
        else null
    }









    /*
    private fun fetch() = runBlocking {
        launch {
            println("JSONSTRING---------------------:"+jsonString)
            //jsonString = url.readText()
            url.let { jsonString = it.readText() }
            println("JSONSTRING---------------------:"+jsonString)
        }
        textConsultation.text = jsonString
    }*/

    /*
    fun URL.getString(): String? {
        val stream = openStream()
        return try {
            val r = BufferedReader(InputStreamReader(stream))
            val result = StringBuilder()
            var line: String?
            while (r.readLine().also { line = it } != null) {
                result.append(line).appendLine()
            }
            result.toString()
        }catch (e: IOException){
            e.toString()
        }
    }
    */



}