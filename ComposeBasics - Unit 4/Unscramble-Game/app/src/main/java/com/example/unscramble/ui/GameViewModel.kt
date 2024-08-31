package com.example.unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Game UI state



class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    public val uiState : StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentWord: String
    private var usedWords: MutableSet<String> = mutableSetOf()

    var userGuess by mutableStateOf("")
        private set


    init {
        resetGame()
    }

    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size >= MAX_NO_OF_WORDS) {
            //Last round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = 100000,
                    isGameOver = true
                )
            }
        } else {
            //A Normal round in the game
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    score = updatedScore,
                    currentWordCount = currentState.currentWordCount.inc()
                )

            }
        }
    }

    public fun skipWord() {
        updateGameState(_uiState.value.score)

        //Reset user guess
        updateUserGuess("")

    }

    public fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {

           updateGameState(_uiState.value.score.plus(SCORE_INCREASE))
        } else {
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }

        updateUserGuess("")


    }

    public fun updateUserGuess(guessedWord: String) {
        userGuess = guessedWord
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
