package com.example.pomodoro.viewmodel
enum class EstadoTimer {
    FOCUS, SHORT_REST, LONG_REST, IDLE
}
data class TimerUiState(
    val time:Int=1500,
    val timerState:EstadoTimer=EstadoTimer.FOCUS,
    val block:Int=4,
    val play:Boolean=false)