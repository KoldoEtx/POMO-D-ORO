package com.example.pomodoro.ui.timer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import com.example.pomodoro.viewmodel.EstadoTimer
import com.example.pomodoro.viewmodel.TimerUiState
import java.util.Timer

@Composable
fun TimerScreen(
    uiState: TimerUiState,
    onPlay: () -> Unit,
    onPause: () -> Unit,
    onSkip: () -> Unit,
    onReset: () -> Unit

){
    Column(modifier = Modifier.fillMaxSize()){
        TimerCircle(
            time=uiState.time,
            timer=uiState.timerState
        )
        TimerControls(
            onPlay = onPlay,
            onSkip = onSkip,
            onPause = onPause,
            onReset = onReset,
            play = uiState.play
        )
        SessionBlocks(
            block = uiState.block
        )
    }
}

@Composable
fun TimerCircle(
    time: Int,
    timer: EstadoTimer,
    ) {}
@Composable
fun TimerControls(
    onPlay: () -> Unit,
    onPause: () -> Unit,
    onSkip: () -> Unit,
    onReset: () -> Unit,
    play: Boolean
){}
@Composable
fun SessionBlocks(block: Int){}