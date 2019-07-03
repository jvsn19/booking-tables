package com.e.booking_tables.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.e.booking_tables.models.DishModel
import com.e.booking_tables.R
import kotlinx.android.synthetic.main.menu_layout_holder.view.*

class MenuAdapter(private val dishes : ArrayList<DishModel>,
                  private val context : Context): RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return dishes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dish = dishes[position]
        holder.name.text = dish.name
        holder.price.text = dish.price.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.menu_layout_holder, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.dish_name_lbl
        val price : TextView = itemView.dish_price_lbl
    }
}