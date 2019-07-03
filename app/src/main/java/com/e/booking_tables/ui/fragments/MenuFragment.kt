package com.e.booking_tables.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.e.booking_tables.R
import com.e.booking_tables.models.DishModel
import com.e.booking_tables.ui.MenuAdapter

/**
 * A simple [Fragment] subclass.
 *
 */
class MenuFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_menu, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.menu_recycler_view)
        val layoutManager = LinearLayoutManager(this.context)

        recyclerView.adapter = MenuAdapter(arrayListOf(
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3),
            DishModel("TestA", 31.5, 3)
        ), this.context!!)

        recyclerView.layoutManager = layoutManager

        return rootView
    }


}
