package com.regadera.regapasswordmanagerfoss

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log

class LoginPageVC : AppCompatActivity() {
    lateinit var password : String
    lateinit var username : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        val loginButton: Button = findViewById<Button>(R.id.btnLogin)
        var eUsername = findViewById<EditText>(R.id.etUsername)
        var ePassword = findViewById<EditText>(R.id.etPassword)

        eUsername.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                username = eUsername.text.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })

        ePassword.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                password = ePassword.text.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })


        loginButton.setOnClickListener(){
            Toast.makeText(this, "esta es la password:" + password, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainView::class.java)
            startActivity(intent)
        }

    }
}