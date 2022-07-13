package co.edu.udea.compumovil.gr09_20221.labs

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoPersonal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val butt = findViewById(R.id.button3) as Button

        butt.setOnClickListener{

            val intent = Intent(this,PersonalDataActivity::class.java)
            startActivity(intent)

        }
    }
}