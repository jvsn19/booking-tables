package com.e.booking_tables.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantModel(val name: String,
                           val address: String,
                           val rating: ArrayList<RatingModel>,
                           val menu: ArrayList<DishModel>,
                           val coords: HashMap<String, Double>,
                           var uuid: String = "",
                           var availableTables: Int = 0) : Parcelable
