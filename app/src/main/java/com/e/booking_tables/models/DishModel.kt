package com.e.booking_tables.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DishModel(val name: String, val price: Double, val rating: Int) : Parcelable