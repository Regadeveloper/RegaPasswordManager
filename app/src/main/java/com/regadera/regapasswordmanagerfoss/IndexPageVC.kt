package com.regadera.regapasswordmanagerfoss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.regadera.regapasswordmanagerfoss.appData.modules.list.AppLogsLists
import com.regadera.regapasswordmanagerfoss.databinding.IndexPageBinding
import com.regadera.regapasswordmanagerfoss.webData.modules.list.WebLogsLists

class IndexPageVC : AppCompatActivity() {

    private lateinit var binding: IndexPageBinding
    private lateinit var appBtn: Button
    private lateinit var webBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IndexPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appBtn = binding.appButton
        webBtn = binding.webButton

        appBtn.setOnClickListener(){
            val intent = Intent(this, AppLogsLists::class.java)
            startActivity(intent)
        }
        webBtn.setOnClickListener(){
            val intent = Intent(this, WebLogsLists::class.java)
            startActivity(intent)
        }
    }

}