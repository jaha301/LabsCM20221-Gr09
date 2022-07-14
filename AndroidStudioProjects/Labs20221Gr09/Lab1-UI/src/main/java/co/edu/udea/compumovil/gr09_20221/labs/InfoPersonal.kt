package co.edu.udea.compumovil.gr09_20221.labs

import android.content.ContentValues
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class InfoPersonal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val butt = findViewById(R.id.button3) as Button

        butt.setOnClickListener {
            val COUNTRIES = arrayOf(
                "Afghanistan",
                "Albania",
                "Algeria",
                "American Samoa",
                "Andorra",
                "Angola",
                "Anguilla",
                "Antarctica",
                "Antigua and Barbuda",
                "Argentina",
                "Armenia",

            )
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                COUNTRIES
            )
            val pais = findViewById<AutoCompleteTextView>(R.id.autoPais)
            pais.setAdapter(adapter)

            val Cities = arrayOf(
                "Medellén", "Bogota", "Cali", "Barranquilla", "Cartagena",

                )
            val adapter1 = ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                COUNTRIES
            )
            val ciudad = findViewById<AutoCompleteTextView>(R.id.autoCiudad)
            ciudad.setAdapter(adapter)

//##########################################################################################
            butt.setOnClickListener {
                val tel = findViewById(R.id.Telefono) as EditText
                val mail = findViewById(R.id.Email) as EditText
                val pais = findViewById(R.id.autoPais) as EditText
                var ciudad = findViewById(R.id.autoCiudad) as EditText
                var direccion = findViewById(R.id.Direcc) as EditText


                if(tel.text.toString()==""||mail.text.toString()==""|| pais.toString()=="") {
                    Log.d(ContentValues.TAG, "los campos con * son obligatorios")
                }
                else {
                Log.i(
                    ContentValues.TAG,
                    "\n." + " \nInformación de Contacto: \nTeléfono: " + tel.text.toString() + "\nEmail: " + mail.text.toString() + "\nPais: " + pais.text.toString() + "\nCiudad " + ciudad.text.toString() + "\nDirección: " + direccion.text.toString()
                )

                val intent = Intent(this, PersonalDataActivity::class.java)
                startActivity(intent)
                }
            }


        }
    }
}


