package com.regadera.regapasswordmanagerfoss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.regadera.regapasswordmanagerfoss.databinding.IndexPageBinding

class IndexPageVC : AppCompatActivity() {

    private lateinit var binding: IndexPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IndexPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}