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
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL


class MenuConsultationAriActivity : AppCompatActivity() {

    private lateinit var consultationAriBinding: MenuConsultationAriBinding
    private lateinit var textConsultation : TextView
    private lateinit var buttonPull : Button
    private var jsonString = "<JSON_String>"
    private val url = URL("http://ari.juliendrieu.fr/api/ari/liste_ari.php")

    override fun onCreate(savedInstanceState: Bundle?) = runBlocking {
        super.onCreate(savedInstanceState)

        //Scan ID
        val scanID = intent?.extras?.getString("id").toString()//Ligne qui extrait l'id de l'intent.

        consultationAriBinding = MenuConsultationAriBinding.inflate(layoutInflater)
        setContentView(consultationAriBinding.root)

        buttonPull = findViewById(R.id.buttonPull)
        textConsultation = findViewById(R.id.textView3)

        title = getString(R.string.ID_equipe_consultation) + " " + scanID //titre qui contient l'ID

        ////////////////TRY///////////////TODO() fichier a bien clean

        url.let { textConsultation.text = it.toString() }

        // io dispatcher for networking operation
        lifecycleScope.launch(Dispatchers.IO){
            jsonString = url.getString().toString()
            withContext(Dispatchers.Main) {
                textConsultation.text=jsonString
            }
            /*url.getString()?.apply {
                /*
                // default dispatcher for json parsing, cpu intensive work
                withContext(Dispatchers.Default){
                    val list = parseJson(this@apply)

                    // main dispatcher for interaction with ui objects
                    withContext(Dispatchers.Main){
                        textConsultation.append("\n\nReading data from json....\n")

                        list?.forEach {
                            textConsultation.append("\n${it.firstName}" +
                                    " ${it.lastName} ${it.age}")
                        }

                    }

                }*/
            }*/
        }
        print("ENDMARKER-----------------------------------MenuConsultationAriActivity----OnCreate")
    }//oncreate

    private fun fetch() = runBlocking {
        launch {
            println("JSONSTRING---------------------:"+jsonString)
            //jsonString = url.readText()
            url.let { jsonString = it.readText() }
            println("JSONSTRING---------------------:"+jsonString)
        }
        textConsultation.text = jsonString
    }


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

    data class Student(
        val firstName:String,
        val lastName:String,
        val age:Int
    )

    private fun parseJson(data:String):List<Student>?{
        val list = mutableListOf<Student>()

        try {
            val array = JSONObject(data).getJSONArray("students")
            for(i in 0 until array.length()){
                val obj = JSONObject(array[i].toString())
                val firstName = obj.getString("id")
                val lastName = obj.getString("lieu_stock")
                val age = obj.getInt("etat_gonflage")
                list.add(Student(firstName,lastName,age))
            }
        }catch (e:JSONException){
            Log.d("Exception", e.toString())
        }

        return list
    }


}