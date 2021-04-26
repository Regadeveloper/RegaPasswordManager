package com.regadera.regapasswordmanagerfoss.webData.modules.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.regadera.regapasswordmanagerfoss.R
import com.regadera.regapasswordmanagerfoss.webData.model.Web
import kotlinx.android.synthetic.main.web_custom_row.view.*


class WebListAdapter: RecyclerView.Adapter<WebListAdapter.MyViewHolder>() {

    private var webList = emptyList<Web>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.web_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return webList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = webList[position]
        holder.itemView.text_web_webname.text = currentItem.website.toString()
        holder.itemView.text_web_username.text = currentItem.userName.toString()
        holder.itemView.text_web_password.text = currentItem.mainPassword.toString()

    }

    fun setData(web: List<Web>){
        this.webList = web
        notifyDataSetChanged()
    }
}