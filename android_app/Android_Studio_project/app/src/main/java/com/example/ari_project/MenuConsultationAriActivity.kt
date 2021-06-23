package com.example.ari_project

///TEST
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
import java.net.URL


class MenuConsultationAriActivity : AppCompatActivity() {

    private lateinit var consultationAriBinding: MenuConsultationAriBinding
    private lateinit var etatGonflage : TextView
    private lateinit var lieuStock : TextView

    private val urlAriList = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")
    private var jsonAriList = "<JSON_String>"
    private val urlHistoriqueGonflages = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")
    private var jsonHistoriqueGonflages = "<JSON_String>"
    private val urlHistoriqueControles = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")
    private var jsonHistoriqueControles  = "<JSON_String>"
    private val urlHistoriqueReparations  = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")
    private var jsonHistoriqueReparations = "<JSON_String>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        consultationAriBinding = MenuConsultationAriBinding.inflate(layoutInflater)
        setContentView(consultationAriBinding.root)

        etatGonflage = findViewById(R.id.text_etat_gonflage_value)
        lieuStock = findViewById(R.id.text_lieu_de_stock_value)
        val accueil = findViewById<Button>(R.id.home_button)

        title = getString(R.string.ID_equipe_consultation) + " " + scanID //titre qui contient l'ID

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // io dispatcher pour les opérations réseau
        lifecycleScope.launch(Dispatchers.IO){
            //jsonString = url.getString().toString()
            jsonAriList = urlAriList.readText()


            // default dispatcher pour le parsing, gros travail CPU
            withContext(Dispatchers.Default){
                //on parse le JSON récupéré pour récupérer les infos liées au scanID
                val ari = getAriInfo(jsonAriList, scanID)

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

                }
            }
        }
        println("ENDMARKER------------------MenuConsultationAriActivity------------------OnCreate")
    }//ONCREATE




    data class ARI(
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
    }//GETARIINFO


    private fun getHistoriqueGonflages(data:String, id:String):List<String>?{
        val list = mutableListOf<String>()
        try {
            val array = JSONObject(data).getJSONArray("ari_list")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                if(obj.getString("id")==id) {
                    val date = obj.getString("date")
                    list.add(date)
                }
            }
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }
        return if(list != null) list
        else null
    }//getHistoriqueGonflages


    private fun getHistoriqueControles(data:String, id:String):List<String>?{
        val list = mutableListOf<String>()
        try {
            val array = JSONObject(data).getJSONArray("ari_list")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                if(obj.getString("id")==id) {
                    val date = obj.getString("date")
                    list.add(date)
                }
            }
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }
        return if(list != null) list
        else null
    }//getHistoriqueControles


    private fun getHistoriqueReparations(data:String, id:String):List<String>?{
        val list = mutableListOf<String>()
        try {
            val array = JSONObject(data).getJSONArray("ari_list")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                if(obj.getString("id")==id) {
                    val date = obj.getString("date")
                    list.add(date)
                }
            }
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }
        return if(list != null) list
        else null
    }//getHistoriqueReparations

}//ENBRACKET