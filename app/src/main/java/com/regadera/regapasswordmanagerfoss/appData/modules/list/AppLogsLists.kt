package com.regadera.regapasswordmanagerfoss.appData.modules.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.regadera.regapasswordmanagerfoss.appData.viewmodel.AppViewModel
import com.regadera.regapasswordmanagerfoss.databinding.AppLogsListsBinding
import com.regadera.regapasswordmanagerfoss.appData.modules.add.AppLogsAdd


class AppLogsLists : AppCompatActivity() {

    private lateinit var binding: AppLogsListsBinding
    private lateinit var mAppViewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AppLogsListsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RecyclerView
        val adapter = AppListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //ViewModel
        mAppViewModel = ViewModelProvider(this).get((AppViewModel::class.java))
        mAppViewModel.readData.observe(this, Observer { user ->
            adapter.setData(user)
        })

        binding.floatBtnAdd.setOnClickListener{
            val intent = Intent(this, AppLogsAdd::class.java)
            startActivity(intent)
        }
    }
}