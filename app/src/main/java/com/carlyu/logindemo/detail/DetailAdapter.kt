package com.carlyu.logindemo.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.carlyu.logindemo.R

class RecyclerAdapter(private val textList: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = textList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val textPos = textList[position]
        holder.title.text = textPos
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${holder.title.text}", Toast.LENGTH_SHORT)
                .show()
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.mine_title)
    }
}