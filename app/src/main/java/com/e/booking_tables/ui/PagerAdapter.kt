package com.e.booking_tables.ui

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.Menu
import com.e.booking_tables.ui.fragments.AboutFragment
import com.e.booking_tables.ui.fragments.MenuFragment
import com.e.booking_tables.ui.fragments.ReviewFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    var menuFragment = MenuFragment()
    var reviewFragment = ReviewFragment()
    var aboutFragment = AboutFragment()

    // Returns the number of pages. We can return an constant number if we know how many tabs we have
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                menuFragment
            }
            1 -> {
                reviewFragment
            }
            else -> {
                return aboutFragment
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "Menu"
            }
            1 -> {
                "Review"
            }
            else -> {
                return "About"
            }
        }
    }
}