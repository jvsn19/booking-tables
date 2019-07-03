package com.e.booking_tables.firebase

import android.app.Activity
import android.util.Log
import com.e.booking_tables.models.DishModel
import com.e.booking_tables.models.RestaurantModel
import com.google.firebase.database.*

class FirebaseManager(val activity : Activity) {
    // A reference to the database root (/)

    private var rootReference: DatabaseReference = FirebaseDatabase.getInstance().reference

    fun loadDatabase() : ArrayList<RestaurantModel> {
        // Dishes
        val dishA = DishModel(
            name = "Combinado de Sushi 20 pcs",
            price = 30.50,
            rating = 4
        )

        val dishB = DishModel(
            name = "Combinado de Sushi 50 pcs",
            price = 45.90,
            rating = 5
        )

        val dishC = DishModel(
            name = "Pizza Grande Especial",
            price = 45.90,
            rating = 5
        )

        val dishD = DishModel(
            name = "Pizza Média Especial",
            price = 40.90,
            rating = 2
        )

        // Restaurants
        val restaurantA = RestaurantModel(
            name = "Sushi10",
            address = "R. Comendador Bento Águiar, 255",
            rating = arrayListOf(),
            coords = hashMapOf(
                "lat" to -3.802800,
                "long" to -38.529800
            ),
            menu = arrayListOf(
                dishA,
                dishB
            )
        )

        val restaurantB = RestaurantModel(
            name = "Pizzaria Domino\'s",
            address = "Av. Caxangá, 3000",
            rating = arrayListOf(),
            coords = hashMapOf(
                "lat" to -3.801700,
                "long" to -38.529600
            ),
            menu = arrayListOf(
                dishC,
                dishD
            )
        )

        val restaurantC = RestaurantModel(
            name = "Lou's Burguer\'s",
            address = "Av. Doutor Silas Munguba, 6360",
            rating = arrayListOf(),
            coords = hashMapOf(
                "lat" to -3.800243,
                "long" to -38.534189
            ),
            menu = arrayListOf(
                dishC,
                dishD
            )
        )

        val availableRestaurants = arrayListOf(
            restaurantA,
            restaurantB,
            restaurantC
        )

//        for(restaurant in availableRestaurants) {
//            val restaurantKey = rootReference.child("restaurants").push().key
//            restaurant.uuid = restaurantKey.toString()
//            rootReference.child("restaurants").child(restaurant.uuid).setValue(restaurant)
//        }

        return availableRestaurants
    }

}