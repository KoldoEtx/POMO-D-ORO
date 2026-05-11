package com.example.pomodoro.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TimerViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TimerUiState())
    val uiState: StateFlow<TimerUiState> = _uiState.asStateFlow()

    fun play() {
        _uiState.update { it.copy(play = true) }
        startTimer()
    }

    fun pause() {
        _uiState.update { it.copy(play = false) }
    }

    fun skip() {
        _uiState.update {
            it.copy(
                timerState = when (it.timerState) {
                    EstadoTimer.FOCUS -> EstadoTimer.SHORT_REST
                    EstadoTimer.SHORT_REST -> EstadoTimer.FOCUS
                    else -> EstadoTimer.FOCUS
                }
            )
        }
    }

    fun reset() {
        _uiState.value = TimerUiState()
    }

    //Temporizador para cuenta atrás en pantalla
    private fun startTimer() {
        val timer = object : CountDownTimer(_uiState.value.time.toLong()*1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _uiState.update { it.copy(time = (millisUntilFinished / 1000).toInt()) }
            }
            override fun onFinish() {
                skip()
            }
        }
        timer.start()
    }
}