package com.regadera.regapasswordmanagerfoss.appData.modules.add

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
import com.regadera.regapasswordmanagerfoss.appData.model.App
import com.regadera.regapasswordmanagerfoss.appData.viewmodel.AppViewModel
import com.regadera.regapasswordmanagerfoss.databinding.AppLogsAddBinding
import com.regadera.regapasswordmanagerfoss.appData.modules.list.AppLogsLists

class AppLogsAdd : AppCompatActivity() {

    private lateinit var binding: AppLogsAddBinding
    private lateinit var mAppViewModel: AppViewModel
    private var password = ""
    private var username = ""
    private var appName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AppLogsAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAppViewModel = ViewModelProvider (this).get((AppViewModel::class.java))

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
                appName = binding.edtextAddWebAppName.text.toString()
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
        val appUser = App(0, username, password, appName)
        mAppViewModel.addWeb(app = appUser)
        Toast.makeText(this, "Succesfully added user: ${appUser.userName}," +
                " with password: ${appUser.mainPassword}" +
                "  for the site: ${appUser.appName}", Toast.LENGTH_LONG).show()
        val intent = Intent(this, AppLogsLists::class.java)
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
        if (appName.isEmpty()){
            binding.edtextAddWebAppName.error = getString(R.string.empty_web_app_name)
        }
        return password.isNotEmpty() && username.isNotEmpty() && appName.isNotEmpty()
    }

    private fun closeKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}