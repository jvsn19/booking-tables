package com.e.booking_tables.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.e.booking_tables.R
import com.e.booking_tables.models.RatingModel
import com.e.booking_tables.ui.RatingAdapter

/**
 * A simple [Fragment] subclass.
 *
 */
class ReviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_review, container, false)
        var recyclerView = rootView.findViewById<RecyclerView>(R.id.review_recycler_view)
        val layoutManager = LinearLayoutManager(this.context)

        recyclerView.adapter = RatingAdapter(arrayListOf(
            RatingModel(5, "Melhor sushi da região"),
            RatingModel(4, "Poderia melhorar o preço do sushi"),
            RatingModel(3, "É bom, porem as peças são pequenas"),
            RatingModel(2, "Poderia melhorar muito o serviço"),
            RatingModel(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dignissim eros et pulvinar maximus. Donec quis metus velit. Nullam venenatis tempor dolor quis tempus. Integer at congue dui, non ultricies metus. Maecenas cursus hendrerit risus in vestibulum. Fusce malesuada tempor enim, at malesuada sem auctor nec. Nunc sit amet viverra diam. Donec commodo, orci et malesuada tristique, orci elit dapibus nibh, ac molestie metus justo id urna. Nunc sed purus a velit semper varius sit amet vel neque. Suspendisse dapibus a lacus vitae tempor. Nam viverra, lectus vitae blandit porttitor, erat magna scelerisque ante, in feugiat neque est sit amet libero. Praesent velit leo, viverra ac sem ut, eleifend blandit ex.")
        ), this.context!!)

        recyclerView.layoutManager = layoutManager


        return rootView
    }


}
