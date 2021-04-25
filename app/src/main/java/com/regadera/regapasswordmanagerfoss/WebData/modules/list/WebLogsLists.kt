package com.regadera.regapasswordmanagerfoss.WebData.modules.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.regadera.regapasswordmanagerfoss.WebData.viewmodel.WebViewModel
import com.regadera.regapasswordmanagerfoss.databinding.WebLogsListsBinding
import com.regadera.regapasswordmanagerfoss.WebData.modules.add.WebLogsAdd


class WebLogsLists : AppCompatActivity() {

    private lateinit var binding: WebLogsListsBinding
    private lateinit var mAppViewModel: WebViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WebLogsListsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RecyclerView
        val adapter = WebListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //ViewModel
        mAppViewModel = ViewModelProvider(this).get((WebViewModel::class.java))
        mAppViewModel.readData.observe(this, Observer { user ->
            adapter.setData(user)
        })

        binding.floatBtnAdd.setOnClickListener{
            val intent = Intent(this, WebLogsAdd::class.java)
            startActivity(intent)
        }
    }
}