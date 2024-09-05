package com.example.dessertclicker.ui

import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert

data class GameUiState(
    val totalRevenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessert: Dessert = Datasource.dessertList.first(),
    val currentDessertIndex: Int = 0

)
