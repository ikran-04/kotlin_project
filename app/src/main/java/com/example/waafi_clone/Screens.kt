package com.example.project

sealed class Screens(val route :String){
    object Chat :Screens("Chat")

    object Calls :Screens("Calls")
    object Money :Screens("Money")

}