package com.e.booking_tables.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.e.booking_tables.R
import kotlinx.android.synthetic.main.activity_restaurant.*

class RestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val intent = intent

        val fragmentAdapter = PagerAdapter(supportFragmentManager)

        view_pager_restaurant.adapter = fragmentAdapter

        tabs_restaurant.setupWithViewPager(view_pager_restaurant)

        name_lbl.text = intent.extras["restaurantName"].toString()
        address_label.text = intent.extras["restaurantAddress"].toString()

        this.title = intent.extras["restaurantName"].toString()
    }
}
