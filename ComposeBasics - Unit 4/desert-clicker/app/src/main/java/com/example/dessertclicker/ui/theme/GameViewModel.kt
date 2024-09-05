package com.example.dessertclicker.ui.theme

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import com.example.dessertclicker.ui.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    public val uiState : StateFlow<GameUiState> = _uiState.asStateFlow()

    private val desserts = Datasource.dessertList
    init {
        resetGame()
    }
    public fun resetGame() {
        _uiState.value =
            GameUiState(
                totalRevenue = 0,
                dessertsSold = 0,
                currentDessert = desserts.first()
            )
    }

    public fun onDessertClicked() {
        _uiState.update { currentState ->
            currentState.copy(
                totalRevenue = currentState.totalRevenue + currentState.currentDessert.price,
                dessertsSold = currentState.dessertsSold + 1,
                currentDessert = determineDessertToShow(desserts, currentState.dessertsSold)
            )
        }
    }

    private fun determineDessertToShow(
        desserts: List<Dessert>,
        dessertsSold: Int
    ): Dessert {
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertToShow = dessert
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }

        return dessertToShow
    }
}