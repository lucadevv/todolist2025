package com.example.todolist.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        innerPadding ->
        Main(
            modifier = Modifier.padding(innerPadding)
        )

    }
}

@Composable
fun Main(modifier: Modifier){}