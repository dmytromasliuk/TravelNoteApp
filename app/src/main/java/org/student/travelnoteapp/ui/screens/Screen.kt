package org.student.travelnoteapp.ui.screens

sealed class Screen(val rout: String) {
    object Login: Screen(rout = "login_screen")
    object Registration: Screen(rout = "registration_screen")
    object Profile: Screen(rout = "profile_screen")

}
