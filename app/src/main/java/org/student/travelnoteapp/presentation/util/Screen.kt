package org.student.travelnoteapp.presentation.util

sealed class Screen(val route: String) {
    object Login: Screen(route = "login_screen")
    object Registration: Screen(route = "registration_screen")
    object Profile: Screen(route = "profile_screen")
    object ProfileUpdate: Screen(route = "profile_update_screen")
    object TravelList: Screen(route = "travel_list_screen")
    object TravelDetails: Screen(route = "travel_details_screen")
    object CurrentTravelTimetable: Screen(route = "current_travel_timetable_screen")
    object Map: Screen(route = "map_screen")


}
