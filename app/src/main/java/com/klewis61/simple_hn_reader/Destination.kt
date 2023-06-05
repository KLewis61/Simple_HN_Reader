package com.klewis61.simple_hn_reader

sealed class Destination (val route: String){
    object Home: Destination("Home")
    object Search: Destination("Search")
    object Favorites: Destination("Favorites")
    object Detail: Destination("Detail/{Id}"){
        fun createRoute(id: String): String = "Detail/$id"
    }
    object User: Destination("User")

}