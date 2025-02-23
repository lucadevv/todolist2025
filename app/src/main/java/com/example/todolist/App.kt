package com.example.todolist

import androidx.compose.runtime.Composable
import com.example.todolist.presentation.HomeScreen
import com.example.todolist.ui.theme.TodolistTheme

@Composable
fun App(){
    TodolistTheme {
        HomeScreen()
    }
}