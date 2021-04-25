package com.regadera.regapasswordmanagerfoss.webData.modules.update

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.regadera.regapasswordmanagerfoss.databinding.WebLogsUpdateBinding

class WebUpdateVC : AppCompatActivity() {
    private lateinit var binding: WebLogsUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}