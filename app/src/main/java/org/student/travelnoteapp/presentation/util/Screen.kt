package org.student.travelnoteapp.presentation.util

sealed class Screen(val rout: String) {
    object Login: Screen(rout = "login_screen")
    object Registration: Screen(rout = "registration_screen")
    object Profile: Screen(rout = "profile_screen")
    object ProfileUpdate: Screen(rout = "profile_update_screen")
    object TravelList: Screen(rout = "travel_list_screen")
    object TravelDetails: Screen(rout = "travel_details_screen")
    object Map: Screen(rout = "map_screen")


}
