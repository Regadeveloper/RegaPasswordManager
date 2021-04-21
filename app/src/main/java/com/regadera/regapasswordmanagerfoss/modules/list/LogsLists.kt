package com.regadera.regapasswordmanagerfoss.modules.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.regadera.regapasswordmanagerfoss.R
import com.regadera.regapasswordmanagerfoss.databinding.LogsListsBinding
import com.regadera.regapasswordmanagerfoss.modules.add.LogsAdd


class LogsLists : AppCompatActivity() {

    private lateinit var binding: LogsListsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogsListsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatBtnAdd.setOnClickListener{
            val intent = Intent(this, LogsAdd::class.java)
            startActivity(intent)
        }
    }
}