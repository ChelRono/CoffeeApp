package com.example.foodapp

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.home,"home")
    object Cart: BottomNavItem("Menu",R.drawable.shopping_bag,"cart")
    object Settings: BottomNavItem("Settings",R.drawable.settings,"settings")
}