package com.regadera.regapasswordmanagerfoss.modules.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.regadera.regapasswordmanagerfoss.viewmodel.UserViewModel
import com.regadera.regapasswordmanagerfoss.databinding.LogsListsBinding
import com.regadera.regapasswordmanagerfoss.modules.add.LogsAdd


class LogsLists : AppCompatActivity() {

    private lateinit var binding: LogsListsBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogsListsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RecyclerView
        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //ViewModel
        mUserViewModel = ViewModelProvider(this).get((UserViewModel::class.java))
        mUserViewModel.readData.observe(this, Observer { user ->
            adapter.setData(user)
        })

        binding.floatBtnAdd.setOnClickListener{
            val intent = Intent(this, LogsAdd::class.java)
            startActivity(intent)
        }
    }
}