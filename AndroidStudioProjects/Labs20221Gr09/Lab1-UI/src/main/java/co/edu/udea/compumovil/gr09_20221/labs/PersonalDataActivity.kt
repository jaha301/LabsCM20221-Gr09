package co.edu.udea.compumovil.gr09_20221.labs

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*
var eDate : EditText? = null

class PersonalDataActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val but = findViewById(R.id.button1) as Button
        eDate = findViewById(R.id.etDate)
        eDate?.setOnClickListener(this)

        but.setOnClickListener{
            val nom = findViewById(R.id.nombres) as TextView
            val ape = findViewById(R.id.apellidos) as TextView
            val esco = findViewById(R.id.escola) as Spinner
            var hombre = findViewById(R.id.checkBox2) as CheckBox
            var mujer = findViewById(R.id.checkBox) as CheckBox
            var nacio = ""
            nacio = eDate?.text.toString()
            var genero = ""
            if(hombre.isChecked){genero="Hombre"}
            if(mujer.isChecked){genero="Mujer"}
            val presona = Persona(nom.toString(),ape.toString(), eDate.toString(),genero, esco.selectedItem.toString())

           // println(presona.toString())

            Log.i(TAG, "\n."+" \nInformación Personal: \nNombre: "+nom.text.toString()+ " "+ape.text.toString()+"\n"+genero.toString()+"\nNació el "+ nacio+"\n"+esco.selectedItem.toString())
            val intent = Intent(this,PersonalDataActivity::class.java)
            startActivity(intent)

        }


    }
    override fun onClick(p0: View?) {
        var fecha = DatePickerFragment{year, month, day -> mostrarResultado(year, month, day)}
            fecha.show(supportFragmentManager, "DatePicker")
    }

    private fun mostrarResultado(year: Int, month: Int, day: Int) {
        eDate?.setText("$day/$month/$year")
    }

@SuppressLint("ValidFragment")
class DatePickerFragment (val listener: (year:Int, month:Int, day:Int ) -> Unit): DialogFragment(), DatePickerDialog.OnDateSetListener
{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(),this,year, month, day)
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        listener(year, month, day)
    }
}

    fun onCheckboxClicked(view: View) {


        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox2 -> {
                    if (checked) {
                                     } else {
                        // Remove the meat
                    }
                }
                R.id.checkBox-> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                // TODO: Veggie sandwich
            }
        }
    }

 data class Persona (val nombre: String,val apellido: String,    val age: String ,val gender: String,val esolcaridad: String )




}



