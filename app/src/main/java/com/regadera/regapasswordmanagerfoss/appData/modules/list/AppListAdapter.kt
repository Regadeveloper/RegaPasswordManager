package com.regadera.regapasswordmanagerfoss.appData.modules.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.regadera.regapasswordmanagerfoss.R
import com.regadera.regapasswordmanagerfoss.appData.model.App
import kotlinx.android.synthetic.main.app_custom_row.view.*

class AppListAdapter: RecyclerView.Adapter<AppListAdapter.MyViewHolder>() {

    private var appList = emptyList<App>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.app_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return appList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = appList[position]
        holder.itemView.text_appName.text = currentItem.appName
        holder.itemView.text_username.text = currentItem.userName
        holder.itemView.text_password.text = currentItem.mainPassword

    }

    fun setData (app: List<App>){
        this.appList = app
        notifyDataSetChanged()
    }
}