package com.regadera.regapasswordmanagerfoss.webData.modules.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.regadera.regapasswordmanagerfoss.webData.viewmodel.WebViewModel
import com.regadera.regapasswordmanagerfoss.databinding.WebLogsListsBinding
import com.regadera.regapasswordmanagerfoss.globals.MyGlobals
import com.regadera.regapasswordmanagerfoss.userData.viewmodel.UserViewModel
import com.regadera.regapasswordmanagerfoss.webData.modules.add.WebLogsAdd


class WebLogsLists : AppCompatActivity() {

    private lateinit var binding: WebLogsListsBinding
    private lateinit var mUserViewModel: UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WebLogsListsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RecyclerView
        val adapter = WebListAdapter()
        val recyclerView = binding.recyclerViewWeb
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL ))

        //ViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        mUserViewModel.userWithWebs.observe(this, { userWithWebs->
            Log.i("UserQuery", "El valor de userWithWebs es $userWithWebs")
            if (userWithWebs.isNotEmpty()){
                userWithWebs.first()?.let { adapter.setData(it.webs) }
            }
        })


        binding.floatBtnAddWeb.setOnClickListener{
            val intent = Intent(this, WebLogsAdd::class.java)
            startActivity(intent)
        }
    }
}