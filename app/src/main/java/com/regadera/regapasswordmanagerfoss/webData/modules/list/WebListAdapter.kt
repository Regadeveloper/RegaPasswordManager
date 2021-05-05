package com.regadera.regapasswordmanagerfoss.webData.modules.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.regadera.regapasswordmanagerfoss.R
import com.regadera.regapasswordmanagerfoss.relations.UserWithWebs
import com.regadera.regapasswordmanagerfoss.webData.model.Web
import kotlinx.android.synthetic.main.web_custom_row.view.*


class WebListAdapter: RecyclerView.Adapter<WebListAdapter.MyViewHolder>() {

    private var webList = emptyList<UserWithWebs?>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.web_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return webList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = webList[position]
        holder.itemView.text_web_webname.text = currentItem?.webs?.get(position)?.userName
        holder.itemView.text_web_username.text = currentItem?.webs?.get(position)?.mainPassword
        holder.itemView.text_web_password.text = currentItem?.webs?.get(position)?.website
    }

    fun setData(web: List<UserWithWebs?>){
        this.webList = web
        notifyDataSetChanged()
    }
}