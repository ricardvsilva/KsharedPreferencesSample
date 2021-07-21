package com.rick.sharedpreference02

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call function listeners
        listeners()
        
    }

    private fun listeners() {
        // Declare View Objects
        val btn_record = findViewById<Button>(R.id.btn_record)
        val btn_clear = findViewById<Button>(R.id.btn_clear)
        val btn_restore = findViewById<Button>(R.id.btn_restore)
        val edt_name = findViewById<EditText>(R.id.edt_name)
        val edt_email = findViewById<EditText>(R.id.edt_email)

        // Record button Action
        btn_record.setOnClickListener() {
                val prefs = getSharedPreferences("pref", Context.MODE_PRIVATE) // instance the shared preference
                val ed = prefs.edit()
                ed.putString("name", edt_name.getText().toString()) // ( name is the key = ordinary word as reference , edt_name is the value to be storaged )
                ed.putString("email", edt_email.getText().toString())
                ed.apply() // very important. Apply() add value in the key.
                Toast.makeText(baseContext, " Successfully recorded ! ", Toast.LENGTH_SHORT).show() // Shows message
        }

        // Clear button Action
        btn_clear.setOnClickListener {
            edt_name.setText(" ") // put "nothing" in edit text.
            edt_email.setText(" ")
        }

        // Restores button Action
        btn_restore.setOnClickListener{
            val prefs = getSharedPreferences("pref", MODE_PRIVATE) // instance the shared preference
            edt_name.setText(prefs.getString("name", "não encontrado")) // get from key and write in edit text
            edt_email.setText(prefs.getString("email", "não encontrado"))
        }
    }
}