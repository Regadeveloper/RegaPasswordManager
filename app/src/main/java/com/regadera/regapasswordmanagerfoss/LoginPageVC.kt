package com.regadera.regapasswordmanagerfoss

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.regadera.regapasswordmanagerfoss.databinding.LoginPageBinding
import com.regadera.regapasswordmanagerfoss.databinding.LogsAddBinding
import com.regadera.regapasswordmanagerfoss.modules.list.LogsLists

class LoginPageVC : AppCompatActivity() {
    var password = ""
    var username = ""
    private lateinit var binding: LoginPageBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
            closeKeyboard(binding.root)

            if (password.isNotEmpty() && username.isNotEmpty()){
                startActivity(Intent(this, LogsLists::class.java))
            }
            else{
                if (password.isEmpty()){
                    binding.etPassword.error = getString(R.string.empty_password)
                }
                if (username.isEmpty()){
                    binding.etUsername.error = getString(R.string.empty_username)
                }
            }
        }

    }

    private fun closeKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}