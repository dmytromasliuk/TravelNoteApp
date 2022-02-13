package org.student.travelnoteapp.presentation.util

sealed class Screen(val route: String) {
    object Login: Screen(route = "login_screen")
    object Registration: Screen(route = "registration_screen")
    object Profile: Screen(route = "profile_screen")
    object ProfileUpdate: Screen(route = "profile_update_screen")
    object TravelList: Screen(route = "travel_list_screen")
    object TravelDetails: Screen(route = "travel_details_screen/{id}")
    object AddNewTravel: Screen(route = "add_new_travel_screen")
    object TravelEdit: Screen(route = "travel_edit_screen/{id}")
    object TicketDetails: Screen(route = "ticket_details_screen/{id}")
    object AddTicket: Screen(route = "add_ticket_screen/{travelId}")
    object TicketEdit: Screen(route = "ticket_edit_screen/{id}")
    object BookingDetails: Screen(route = "booking_details_screen/{id}")
    object AddBooking: Screen(route = "add_booking_screen/{travelId}")
    object BookingEdit: Screen(route = "booking_edit_screen/{id}")
    object PlaceDetails: Screen(route = "place_details_screen/{id}")
    object AddPlace: Screen(route = "add_place_screen/{travelId}")
    object PlaceEdit: Screen(route = "place_edit_screen/{id}")
    object CurrentTravelTimetable: Screen(route = "current_travel_timetable_screen")

}
