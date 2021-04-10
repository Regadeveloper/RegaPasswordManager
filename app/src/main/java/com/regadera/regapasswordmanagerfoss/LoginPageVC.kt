package com.regadera.regapasswordmanagerfoss

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginPageVC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        val loginButton: Button = findViewById<Button>(R.id.btnLogin)
        loginButton.setOnClickListener(){
            val intent = Intent(this, MainView::class.java)
            startActivity(intent)
        }

    }
}