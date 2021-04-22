package com.regadera.regapasswordmanagerfoss.modules.add

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.regadera.regapasswordmanagerfoss.data.User
import com.regadera.regapasswordmanagerfoss.data.UserViewModel
import com.regadera.regapasswordmanagerfoss.databinding.LogsAddBinding
import com.regadera.regapasswordmanagerfoss.modules.list.LogsLists

class LogsAdd : AppCompatActivity() {

    private lateinit var binding: LogsAddBinding
    private lateinit var mUserViewModel: UserViewModel
    protected var password = ""
    protected var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogsAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserViewModel = ViewModelProvider (this).get((UserViewModel::class.java))

        binding.btnAddNewUser.setOnClickListener{
            insertDataToDatabase()
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
    }

    private fun insertDataToDatabase(){
        val user = User(0, username, password)
        mUserViewModel.addUser(user = user)
        Toast.makeText(this, "Succesfully added user ${user.userName}", Toast.LENGTH_LONG).show()
        val intent = Intent(this, LogsLists::class.java)
    }
}