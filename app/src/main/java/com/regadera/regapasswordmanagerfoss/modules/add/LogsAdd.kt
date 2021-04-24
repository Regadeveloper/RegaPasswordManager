package com.regadera.regapasswordmanagerfoss.modules.add

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.regadera.regapasswordmanagerfoss.R
import com.regadera.regapasswordmanagerfoss.data.User
import com.regadera.regapasswordmanagerfoss.data.UserViewModel
import com.regadera.regapasswordmanagerfoss.databinding.LogsAddBinding
import com.regadera.regapasswordmanagerfoss.modules.list.LogsLists
import java.util.regex.Pattern

class LogsAdd : AppCompatActivity() {

    private lateinit var binding: LogsAddBinding
    private lateinit var mUserViewModel: UserViewModel
    private var password = ""
    private var username = ""
    private var webAppNAme = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogsAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserViewModel = ViewModelProvider (this).get((UserViewModel::class.java))

        binding.btnAddNewUser.setOnClickListener{
            closeKeyboard(binding.root)
            if (isValid()){
                insertDataToDatabase()
            }
        }

        binding.edtextAddUsername.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                username = binding.edtextAddUsername.text.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }

        })

        binding.edtextAddPassword.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                password = binding.edtextAddPassword.text.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }

        })

        binding.edtextAddWebAppName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                webAppNAme = binding.edtextAddWebAppName.text.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }

        })
    }

    private fun insertDataToDatabase(){
        val user = User(0, username, password, webAppNAme)
        mUserViewModel.addUser(user = user)
        Toast.makeText(this, "Succesfully added user ${user.userName}," +
                " with password ${user.mainPassword}" +
                "  to the web/app ${user.siteApp}", Toast.LENGTH_LONG).show()
        val intent = Intent(this, LogsLists::class.java)
        startActivity(intent)
    }

    private fun isValid(): Boolean {
        //this code here is in its own function to make it easier to add requirements
        if (password.isEmpty()){
            binding.edtextAddPassword.error = getString(R.string.empty_password)
        }
        if (username.isEmpty()){
            binding.edtextAddUsername.error = getString(R.string.empty_username)
        }
        if (webAppNAme.isEmpty()){
            binding.edtextAddWebAppName.error = getString(R.string.empty_web_app_name)
        }
        return password.isNotEmpty() && username.isNotEmpty() && webAppNAme.isNotEmpty()
    }

    private fun closeKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}