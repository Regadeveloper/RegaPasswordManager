package com.regadera.regapasswordmanagerfoss

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.ColumnInfo
import com.regadera.regapasswordmanagerfoss.databinding.LoginPageBinding
import com.regadera.regapasswordmanagerfoss.globals.MyGlobals
import com.regadera.regapasswordmanagerfoss.userData.model.User
import com.regadera.regapasswordmanagerfoss.userData.viewmodel.UserViewModel

class LoginPageVC : AppCompatActivity() {
    var password = ""
    var username = ""
    private lateinit var binding: LoginPageBinding
    private lateinit var mUserViewModel: UserViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val loginButton: Button = binding.btnLogin
        var eUsername = binding.etUsername
        var ePassword = binding.etPassword
        mUserViewModel = ViewModelProvider (this).get((UserViewModel::class.java))


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
                insertDataToDatabase()
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

    private fun insertDataToDatabase(){
        val user = User( username, password)
        mUserViewModel.getCurrentUser(username, password)
        var intent= Intent(this, IndexPageVC::class.java)
        if (mUserViewModel.currentUser.value?.userName == null){
            mUserViewModel.addUser(user = user)
            Toast.makeText(this, "${getText(R.string.added_user)} ${username}", Toast.LENGTH_LONG).show()
            MyGlobals.currentUserName = username
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "${getText(R.string.log_as_user)} ${mUserViewModel.currentUser.value?.userName}", Toast.LENGTH_LONG).show()
            MyGlobals.currentUserName = username
            startActivity(intent)
        }
    }

    private fun closeKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
