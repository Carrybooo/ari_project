package com.example.ari_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ari_project.databinding.MenuControleHistoriqueAriBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.URL

class MenuControleHistoriqueAriActivity : AppCompatActivity() {
    
    private lateinit var histoControle : MenuControleHistoriqueAriBinding

    //elements ref
    private val url =
        URL("http://ari.juliendrieu.fr/api/historiquecontrole/liste_historique_controle.php")
    private var jsonText = "<JSON_String>"

    //views ref
    private lateinit var texteHistoriqueControleID: TextView
    private lateinit var texteHistoriqueControleDate: TextView
    private lateinit var texteHistoriqueControleExec: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        histoControle = MenuControleHistoriqueAriBinding.inflate(layoutInflater)
        setContentView(histoControle.root)

        texteHistoriqueControleID = findViewById(R.id.text_historique_controle_ari_id)
        texteHistoriqueControleDate = findViewById(R.id.text_historique_controle_ari_date)
        texteHistoriqueControleExec = findViewById(R.id.text_historique_controle_ari_executeur)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        val accueil = findViewById<Button>(R.id.home_button)
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
                val listRepa = getListControle(jsonText, scanID)
                withContext(Dispatchers.Main) {
                    when (listRepa) {
                        null -> {
                            texteHistoriqueControleID.append("\n//")
                            texteHistoriqueControleDate.append("\n//")
                            texteHistoriqueControleExec.append("\n//")
                        }
                        else -> listRepa.forEach {
                            texteHistoriqueControleID.append("\n" + it.id)
                            texteHistoriqueControleDate.append("\n" + it.date)
                            texteHistoriqueControleExec.append("\n" + it.executeur)
                        }
                    }
                }

            }

        }

        title = getString(R.string.ID_equipe_histo) + " " + scanID + " (Controle)"//titre qui contient l'ID


    }

    data class Controle(
        var id: String,
        var date: String,
        var executeur: String,
    )

    private fun getListControle(data: String, id: String): List<Controle>? {
        var elementControle: Controle
        val list: MutableList<Controle> =
            mutableListOf<Controle>()
        try {
            val array = JSONObject(data).getJSONArray("historique_controle")
            for (i in 0 until array.length()) {
                val obj = JSONObject(array[i].toString())
                if (obj.getString("id") == id) {
                    val date = obj.getString("date")
                    val executeur = obj.getString("executeur")
                    elementControle = Controle(
                        id, date, executeur
                    )
                    list.add(elementControle)
                }
            }
            list.sortByDescending { it.date }//on trie bien les ??l??ments pour avoir le plus r??cent en haut
        } catch (e: JSONException) {
            Log.d("Exception", e.toString())
        }
        return if (list.isEmpty()) null
        else list
    }

}
