package co.edu.udea.compumovil.gr09_20221.labs

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class PersonalDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val but =findViewById(R.id.button1) as Button

        but.setOnClickListener{

            val intent = Intent(this,InfoPersonal::class.java)
            startActivity(intent)

        }


    }


}