package com.regadera.regapasswordmanagerfoss.AppData.modules.update

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.regadera.regapasswordmanagerfoss.databinding.AppLogsUpdateBinding

class UpdateVC : AppCompatActivity() {
    private lateinit var binding: AppLogsUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}