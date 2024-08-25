package com.example.unscramble.ui

import androidx.lifecycle.ViewModel
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Game UI state
private val _uiState = MutableStateFlow(GameUiState())
val uiState : StateFlow<GameUiState> = _uiState.asStateFlow()


class GameViewModel : ViewModel() {
    private lateinit var currentWord: String
    private var usedWords: MutableSet<String> = mutableSetOf()

    init {
        resetGame()
    }

    public fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        do {
            //shuffle the characters
            tempWord.shuffle()
        } while (String(tempWord).equals(word))

        return String(tempWord)
    }

    private fun pickRandomWordAndShuffle() : String {
        currentWord = allWords.random()

        if (usedWords.contains(currentWord)) {
            return pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }
}
