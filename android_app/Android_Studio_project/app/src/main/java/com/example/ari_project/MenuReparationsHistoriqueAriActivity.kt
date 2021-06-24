package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ari_project.databinding.MenuReparationsHistoriqueAriBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.URL

class MenuReparationsHistoriqueAriActivity : AppCompatActivity() {

    private lateinit var reparationsHistoriqueAri: MenuReparationsHistoriqueAriBinding

    //elements ref
    private val url =
        URL("http://ari.juliendrieu.fr/api/historiquerepa/liste_historique_repa.php")
    private var jsonText = "<JSON_String>"

    //views ref
    private lateinit var texteHistoriqueRepaID: TextView
    private lateinit var texteHistoriqueRepaDate: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reparationsHistoriqueAri = MenuReparationsHistoriqueAriBinding.inflate(layoutInflater)
        setContentView(reparationsHistoriqueAri.root)

        texteHistoriqueRepaID = findViewById(R.id.text_historique_reparation_ari_id)
        texteHistoriqueRepaDate = findViewById(R.id.text_historique_reparation_ari_date)

        val accueil = findViewById<Button>(R.id.home_button)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        accueil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            try {
                jsonText = url.readText()
            } catch (e: IOException) {
                e.toString()
            }

            println(jsonText)

            withContext(Dispatchers.Default) {
                val listRepa = getListRepa(jsonText, scanID)
                withContext(Dispatchers.Main) {
                    when (listRepa) {
                        null -> {
                            texteHistoriqueRepaID.append("\n//")
                            texteHistoriqueRepaDate.append("\n//")
                        }
                        else -> listRepa.forEach {
                            texteHistoriqueRepaID.append("\n" + it.id)
                            texteHistoriqueRepaID.append("\n" + it.date)
                        }
                    }
                }

            }

        }

        title = getString(R.string.ID_equipe_histo) + " " + scanID + " (Réparations)"//titre qui contient l'ID
    }


    data class Repa(
        var id: String,
        var date: String,
    )

    private fun getListRepa(data: String, id: String): List<Repa>? {
        var elementRepa = Repa(
            "", ""
        )
        val list: MutableList<Repa> =
            mutableListOf<Repa>()
        try {
            val array = JSONObject(data).getJSONArray("historique_repa")
            for (i in 0 until array.length()) {
                val obj = JSONObject(array[i].toString())
                if (obj.getString("ari") == id) {
                    val date = obj.getString("date")
                    elementRepa = Repa(
                        id, date
                    )
                    list.add(elementRepa)
                }
            }
            list.sortByDescending { it.date }//on trie bien les éléments pour avoir le plus récent en haut
        } catch (e: JSONException) {
            Log.d("Exception", e.toString())
        }
        return if (list.isEmpty()) null
        else list
    }
}