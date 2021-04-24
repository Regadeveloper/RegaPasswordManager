package com.regadera.regapasswordmanagerfoss.modules.update

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.regadera.regapasswordmanagerfoss.R
import com.regadera.regapasswordmanagerfoss.databinding.LogsUpdateBinding

class UpdateVC : AppCompatActivity() {
    private lateinit var binding: LogsUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}