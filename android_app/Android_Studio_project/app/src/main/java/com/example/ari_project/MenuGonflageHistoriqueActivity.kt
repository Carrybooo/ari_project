package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ari_project.databinding.MenuGonflageHistoriqueAriBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.URL

class MenuGonflageHistoriqueActivity : AppCompatActivity() {

    //views ref
    private lateinit var texteHistoriqueGonflageID : TextView
    private lateinit var texteHistoriqueGonflageDate : TextView
    private lateinit var texteHistoriqueGonflageLieu : TextView
    private lateinit var texteHistoriqueGonflageCompresseur : TextView


    //elements ref
    private val url = URL("http://ari.juliendrieu.fr/api/historiquegonflage/liste_historique_gonflage.php")
    private var jsonText = "<JSON_String>"


    private lateinit var gonflageHisto : MenuGonflageHistoriqueAriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        gonflageHisto = MenuGonflageHistoriqueAriBinding.inflate(layoutInflater)
        setContentView(gonflageHisto.root)

        texteHistoriqueGonflageID = findViewById(R.id.text_historique_gonflage_ari_id)
        texteHistoriqueGonflageDate = findViewById(R.id.text_historique_gonflage_ari_date)
        texteHistoriqueGonflageLieu = findViewById(R.id.text_historique_gonflage_ari_lieu)
        texteHistoriqueGonflageCompresseur = findViewById(R.id.text_historique_gonflage_ari_compresseur)

        val accueil = findViewById<Button>(R.id.home_button)

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        lifecycleScope.launch(Dispatchers.IO){
            try{jsonText = url.readText()}
            catch (e: IOException){e.toString()}

            println(jsonText)

            withContext(Dispatchers.Default){
                val listGonflages = getListGonflages(jsonText, scanID)
                withContext(Dispatchers.Main) {
                    when(listGonflages){
                        null -> {
                            texteHistoriqueGonflageID.append("\n//")
                            texteHistoriqueGonflageDate.append("\n//")
                            texteHistoriqueGonflageLieu.append("\n//")
                            texteHistoriqueGonflageCompresseur.append("\n//")
                        }
                        else -> listGonflages.forEach{
                            texteHistoriqueGonflageID.append("\n"+it.id)
                            texteHistoriqueGonflageDate.append("\n"+it.date)
                            texteHistoriqueGonflageLieu.append("\n"+it.lieu)
                            texteHistoriqueGonflageCompresseur.append("\n"+it.compresseur)
                        }
                    }
                }

            }

        }


    }//OnCreate

    data class Gonflage(
        var id: String,
        var date: String,
        var lieu: String,
        var compresseur: String,
    )


    private fun getListGonflages(data:String, id:String): List<Gonflage>?{
        var elementGonf = Gonflage(
            "","","",""
        )
        val list : MutableList<Gonflage> = mutableListOf<Gonflage>()
        try {
            val array = JSONObject(data).getJSONArray("historique_gonflage")
            for(i in 0 until array.length()) {
                val obj = JSONObject(array[i].toString())
                if (obj.getString("ari") == id) {
                    val date = obj.getString("date")
                    val lieu = obj.getString("lieu")
                    val compresseur = obj.getString("compresseur")
                    elementGonf = Gonflage(
                        id, date, lieu, compresseur
                    )
                    list.add(elementGonf)
                }
            }
            list.sortByDescending{it.date}//on trie bien les éléments pour avoir le plus récent en haut
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }
        return if(list.isEmpty()) null
        else list
    }//GetListGonflages


}