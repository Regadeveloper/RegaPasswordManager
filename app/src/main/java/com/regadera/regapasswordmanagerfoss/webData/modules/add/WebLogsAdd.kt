package com.regadera.regapasswordmanagerfoss.webData.modules.add

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
import com.regadera.regapasswordmanagerfoss.webData.model.Web
import com.regadera.regapasswordmanagerfoss.webData.viewmodel.WebViewModel
import com.regadera.regapasswordmanagerfoss.databinding.WebLogsAddBinding
import com.regadera.regapasswordmanagerfoss.webData.modules.list.WebLogsLists

class WebLogsAdd : AppCompatActivity() {

    private lateinit var binding: WebLogsAddBinding
    private lateinit var mAppViewModel: WebViewModel
    private var password = ""
    private var username = ""
    private var webName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WebLogsAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAppViewModel = ViewModelProvider (this).get((WebViewModel::class.java))

        binding.btnAddNewWebUser.setOnClickListener{
            closeKeyboard(binding.root)
            if (isValid()){
                insertDataToDatabase()
            }
        }

        binding.edtextAddWebUsername.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                username = binding.edtextAddWebUsername.text.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }

        })

        binding.edtextAddWebPassword.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                password = binding.edtextAddWebPassword.text.toString()
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }

        })

        binding.edtextAddWebName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                webName = binding.edtextAddWebName.text.toString()
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
        val webUser = Web(0, username, password, webName)
        mAppViewModel.addWeb(web = webUser)
        Toast.makeText(this, "Succesfully added user: ${webUser.userName}," +
                " with password: ${webUser.mainPassword}" +
                "  for the site: ${webUser.website}", Toast.LENGTH_LONG).show()
        val intent = Intent(this, WebLogsLists::class.java)
        startActivity(intent)
    }

    private fun isValid(): Boolean {
        //this code here is in its own function to make it easier to add requirements
        if (password.isEmpty()){
            binding.edtextAddWebPassword.error = getString(R.string.empty_password)
        }
        if (username.isEmpty()){
            binding.edtextAddWebUsername.error = getString(R.string.empty_username)
        }
        if (webName.isEmpty()){
            binding.edtextAddWebName.error = getString(R.string.empty_web_app_name)
        }
        return password.isNotEmpty() && username.isNotEmpty() && webName.isNotEmpty()
    }

    private fun closeKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}